package jungkosta.main.domain;

import java.sql.Timestamp;

public class AucAndSaleVO {

	private int sale_id;
	private int auction_id;
	private String item_name;
	private int auction_stcost;
	private Timestamp sale_date;
	private Timestamp auction_end_date;
	private String sale_status;
	private String email;
	private String item_pic1;
	private int bidding_cost;

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

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getAuction_stcost() {
		return auction_stcost;
	}

	public void setAuction_stcost(int auction_stcost) {
		this.auction_stcost = auction_stcost;
	}

	public Timestamp getSale_date() {
		return sale_date;
	}

	public void setSale_date(Timestamp sale_date) {
		this.sale_date = sale_date;
	}

	public Timestamp getAuction_end_date() {
		return auction_end_date;
	}

	public void setAuction_end_date(Timestamp auction_end_date) {
		this.auction_end_date = auction_end_date;
	}

	public String getSale_status() {
		return sale_status;
	}

	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getItem_pic1() {
		return item_pic1;
	}

	public void setItem_pic1(String item_pic1) {
		this.item_pic1 = item_pic1;
	}

	public int getBidding_cost() {
		return bidding_cost;
	}

	public void setBidding_cost(int bidding_cost) {
		this.bidding_cost = bidding_cost;
	}

	@Override
	public String toString() {
		return "AucAndSaleVO [sale_id=" + sale_id + ", auction_id=" + auction_id + ", item_name=" + item_name
				+ ", auction_stcost=" + auction_stcost + ", sale_date=" + sale_date + ", auction_end_date="
				+ auction_end_date + ", sale_status=" + sale_status + ", email=" + email + ", item_pic1=" + item_pic1
				+ ", bidding_cost=" + bidding_cost + "]";
	}

}
