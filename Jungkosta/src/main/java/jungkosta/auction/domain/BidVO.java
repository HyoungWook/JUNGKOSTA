package jungkosta.auction.domain;

import java.sql.Timestamp;

public class BidVO {

	private int bid_id;
	private int bidding_id;
	private String payment_method;
	private String del_address;
	private String bid_status;
	private int total_cost;
	private Timestamp purchase_deadline;
	private Timestamp purchase_date;

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getBidding_id() {
		return bidding_id;
	}

	public void setBidding_id(int bidding_id) {
		this.bidding_id = bidding_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getDel_address() {
		return del_address;
	}

	public void setDel_address(String del_address) {
		this.del_address = del_address;
	}

	public String getBid_status() {
		return bid_status;
	}

	public void setBid_status(String bid_status) {
		this.bid_status = bid_status;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public Timestamp getPurchase_deadline() {
		return purchase_deadline;
	}

	public void setPurchase_deadline(Timestamp purchase_deadline) {
		this.purchase_deadline = purchase_deadline;
	}

	public Timestamp getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Timestamp purchase_date) {
		this.purchase_date = purchase_date;
	}

	@Override
	public String toString() {
		return "BidVO [bid_id=" + bid_id + ", bidding_id=" + bidding_id + ", payment_method=" + payment_method
				+ ", del_address=" + del_address + ", bid_status=" + bid_status + ", total_cost=" + total_cost
				+ ", purchase_deadline=" + purchase_deadline + ", purchase_date=" + purchase_date + "]";
	}

}
