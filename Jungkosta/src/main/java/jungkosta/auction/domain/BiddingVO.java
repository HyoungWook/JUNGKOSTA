package jungkosta.auction.domain;

import java.sql.Timestamp;

public class BiddingVO {

	private int bidding_id;
	private int bidding_cost;
	private Timestamp bidding_time;
	private String email;
	private int auction_id;

	public int getBidding_id() {
		return bidding_id;
	}

	public void setBidding_id(int bidding_id) {
		this.bidding_id = bidding_id;
	}

	public int getBidding_cost() {
		return bidding_cost;
	}

	public void setBidding_cost(int bidding_cost) {
		this.bidding_cost = bidding_cost;
	}

	public Timestamp getBidding_time() {
		return bidding_time;
	}

	public void setBidding_time(Timestamp bidding_time) {
		this.bidding_time = bidding_time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuction_id() {
		return auction_id;
	}

	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}

	@Override
	public String toString() {
		return "BiddingVO [bidding_id=" + bidding_id + ", bidding_cost=" + bidding_cost + ", bidding_time="
				+ bidding_time + ", email=" + email + ", auction_id=" + auction_id + "]";
	}

}
