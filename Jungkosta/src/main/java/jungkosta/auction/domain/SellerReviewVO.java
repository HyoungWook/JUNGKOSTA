package jungkosta.auction.domain;

public class SellerReviewVO {

	private int seller_review_id;
	private String content;
	private String satisfaction;
	private String purchaser;
	private String seller;
	
	public SellerReviewVO(){}
	
	public int getSeller_review_id() {
		return seller_review_id;
	}
	public void setSeller_review_id(int seller_review_id) {
		this.seller_review_id = seller_review_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
}
