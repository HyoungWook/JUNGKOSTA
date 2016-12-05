package jungkosta.commons.util;

import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AucPayService;
import jungkosta.auction.service.BidManageService;
import jungkosta.auction.service.BiddingService;
import jungkosta.main.domain.MessageVO;
import jungkosta.main.service.MessageService;

//@Component
public class BidThread extends Thread {

	@Inject
	private BidManageService service;

	@Inject
	private MessageService messageService;

	@Inject
	private BiddingService biddingService;
	
	@Inject
	private AucPayService paymentService;

	/*public BidThread() {
		start();
	}*/

	@Override
	public void run() {

		System.out.println("경매 관리 Thread 시작!....");

		while (true) {
			try {

				List<AuctionVO> endList = null;

				try {
					endList = service.endAuctionList();

					for (AuctionVO vo : endList) {
						auctionManager(vo);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void auctionManager(AuctionVO vo) throws Exception {
		service.endAuction(vo.getAuction_id());
		service.updateSale_status(vo.getSale_id());

		sendBidMessage(vo);
	}

	private void sendBidMessage(AuctionVO auction) throws Exception {
		MessageVO saler = null;
		MessageVO costomer = null;

		List<BiddingVO> biddingList = biddingService.biddingList(auction.getAuction_id());

		if (biddingList.size() == 0 || biddingList == null) {
			saler = contentSaler(auction, false);
			paymentService.updateSale_status(auction.getSale_id());
		} else {
			saler = contentSaler(auction, true);
			costomer = contentCos(auction);
			costomer.setSender("admin@admin.com");
		}

		saler.setSender("admin@admin.com");
		messageService.insertMessage(saler);

		if (costomer != null) {
			messageService.insertMessage(costomer);
		}
	}

	private MessageVO contentSaler(AuctionVO auction, boolean flag) throws Exception {
		MessageVO messageSaler = new MessageVO();

		String saler_title = "";
		String saler_content = "";

		if (flag) {
			BiddingVO bid_person = biddingService.bid_person(auction.getAuction_id());

			DecimalFormat fomat = new DecimalFormat("#,###");
			String cost = fomat.format(auction.getItem_cost()) + "원";

			saler_title = "[낙찰 알림] 경매 상품 : " + auction.getItem_name() + " " + cost + "에 낙찰 되었습니다.";
			saler_content = "낙찰자 : " + bid_person.getEmail() + " 에게  " + auction.getItem_name() + " 이(가) " + cost
					+ "에 낙찰 되었습니다.";

		} else {
			saler_title = "[유찰 알림] 경매 상품 : " + auction.getItem_name() + " 이(가) 유찰 되었습니다.";
			saler_content = "단 한번의 낙찰이 없었기에 회원님의 경매 상품이 유찰되었슴을 알려드립니다.";
		}

		messageSaler.setTitle(saler_title);
		messageSaler.setContent(saler_content);
		messageSaler.setReceiver(auction.getEmail());

		return messageSaler;
	}

	private MessageVO contentCos(AuctionVO auction) throws Exception {
		MessageVO messageCos = new MessageVO();

		BiddingVO bid_person = biddingService.bid_person(auction.getAuction_id());

		DecimalFormat fomat = new DecimalFormat("#,###");
		String cost = fomat.format(auction.getItem_cost()) + "원";

		String cos_title = "[낙찰 알림] 회원님이 참여하신 경매 상품 " + auction.getItem_name() + "가(이) 낙찰 되셨습니다.";
		String cos_content = "회원님이 참여하신 경매상품 " + auction.getItem_name() + "가(이) " + cost + "에 낙찰 되어 알림을 보내드립니다.<br>";
		cos_content += "아래의 버튼을 누르시면 바로 주문 가능하며 주문 가능일은 이 메시지가 전달된 시점에서 3일 후까지 입니다. 주문해 주세요!! <br><br>";
		cos_content += "<a href='auctionPurchaseForm?sale_id=" + auction.getSale_id() + "&bidding_id="
				+ bid_person.getBidding_id() + "' class='btn btn-primary' id='auctionPurchase'>주문하기</a>";

		messageCos.setTitle(cos_title);
		messageCos.setContent(cos_content);
		messageCos.setReceiver(bid_person.getEmail());

		return messageCos;
	}

}
