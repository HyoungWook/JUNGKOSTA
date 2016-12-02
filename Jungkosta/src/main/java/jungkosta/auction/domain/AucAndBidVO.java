package jungkosta.auction.domain;

public class AucAndBidVO {

	private int sale_id;
	private int auction_id;
	private int bidding_id;
	private int bid_id;
	private String payment_method;
	private int total_cost;

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getAuction_id() {
		return auction_id;
	}

	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}

	public int getBidding_id() {
		return bidding_id;
	}

	public void setBidding_id(int bidding_id) {
		this.bidding_id = bidding_id;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	@Override
	public String toString() {
		return "AucAndBidVO [sale_id=" + sale_id + ", auction_id=" + auction_id + ", bidding_id=" + bidding_id
				+ ", bid_id=" + bid_id + ", payment_method=" + payment_method + ", total_cost=" + total_cost + "]";
	}

}
