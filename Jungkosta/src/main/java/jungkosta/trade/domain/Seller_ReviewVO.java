package jungkosta.trade.domain;

public class Seller_ReviewVO {

	private int seller_review_id;
	private String content;
	private String satisfaction;
	private String purchaser;
	private String seller;
	
	public Seller_ReviewVO(){}

	public Seller_ReviewVO(int seller_review_id, String content, String satisfaction, String purchaser, String seller) {
		super();
		this.seller_review_id = seller_review_id;
		this.content = content;
		this.satisfaction = satisfaction;
		this.purchaser = purchaser;
		this.seller = seller;
	}

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

	@Override
	public String toString() {
		return "Seller_ReviewVO [seller_review_id=" + seller_review_id + ", content=" + content + ", satisfaction="
				+ satisfaction + ", purchaser=" + purchaser + ", seller=" + seller + "]";
	}
	
	
	
}
