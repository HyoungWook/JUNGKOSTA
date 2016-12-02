package jungkosta.auction.domain;

import java.sql.Timestamp;

public class AucPayVO {

	private int auctionpay_id;
	private int cost;
	private String pay_status = "결제 완료";
	private Timestamp pay_date;
	private int bid_id;

	public int getAuctionpay_id() {
		return auctionpay_id;
	}

	public void setAuctionpay_id(int auctionpay_id) {
		this.auctionpay_id = auctionpay_id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public Timestamp getPay_date() {
		return pay_date;
	}

	public void setPay_date(Timestamp pay_date) {
		this.pay_date = pay_date;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	@Override
	public String toString() {
		return "AucPayVO [auctionpay_id=" + auctionpay_id + ", cost=" + cost + ", pay_status=" + pay_status
				+ ", pay_date=" + pay_date + ", bid_id=" + bid_id + "]";
	}

}
