package jungkosta.auction.domain;

import java.sql.Timestamp;

public class AuctionVO {

	private int autcion_id;
	private int auction_stcost;
	private int immediate_bid_cost;
	private Timestamp register_date;
	private Timestamp auction_end_date;
	private String auction_end_status;
	private int sale_id;

	private String item_name;
	private Timestamp buy_time;
	private String item_status;
	private String item_scratch;
	private String additional_info;
	private String buy_info;
	private Timestamp sale_date;
	private String item_pic1;
	private String item_pic2;
	private String item_pic3;
	private String item_pic4;
	private String email;
	private int item_cost;
	private int subca_id;



	private String flag;

	public int getAutcion_id() {
		return autcion_id;
	}

	public void setAutcion_id(int autcion_id) {
		this.autcion_id = autcion_id;
	}

	public int getAuction_stcost() {
		return auction_stcost;
	}

	public void setAuction_stcost(int auction_stcost) {
		this.auction_stcost = auction_stcost;
	}

	public int getImmediate_bid_cost() {
		return immediate_bid_cost;
	}

	public void setImmediate_bid_cost(int immediate_bid_cost) {
		this.immediate_bid_cost = immediate_bid_cost;
	}

	public Timestamp getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Timestamp register_date) {
		this.register_date = register_date;
	}

	public Timestamp getAuction_end_date() {
		return auction_end_date;
	}

	public void setAuction_end_date(Timestamp auction_end_date) {
		this.auction_end_date = auction_end_date;
	}

	public String getAuction_end_status() {
		return auction_end_status;
	}

	public void setAuction_end_status(String auction_end_status) {
		this.auction_end_status = auction_end_status;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Timestamp getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(Timestamp buy_time) {
		this.buy_time = buy_time;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public String getItem_scratch() {
		return item_scratch;
	}

	public void setItem_scratch(String item_scratch) {
		this.item_scratch = item_scratch;
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}

	public String getBuy_info() {
		return buy_info;
	}

	public void setBuy_info(String buy_info) {
		this.buy_info = buy_info;
	}

	public Timestamp getSale_date() {
		return sale_date;
	}

	public void setSale_date(Timestamp sale_date) {
		this.sale_date = sale_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(int item_cost) {
		this.item_cost = item_cost;
	}

	public int getSubca_id() {
		return subca_id;
	}

	public void setSubca_id(int subca_id) {
		this.subca_id = subca_id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getItem_pic1() {
		return item_pic1;
	}

	public void setItem_pic1(String item_pic1) {
		this.item_pic1 = item_pic1;
	}

	public String getItem_pic2() {
		return item_pic2;
	}

	public void setItem_pic2(String item_pic2) {
		this.item_pic2 = item_pic2;
	}

	public String getItem_pic3() {
		return item_pic3;
	}

	public void setItem_pic3(String item_pic3) {
		this.item_pic3 = item_pic3;
	}

	public String getItem_pic4() {
		return item_pic4;
	}

	public void setItem_pic4(String item_pic4) {
		this.item_pic4 = item_pic4;
	}

	@Override
	public String toString() {
		return "AuctionVO [autcion_id=" + autcion_id + ", auction_stcost=" + auction_stcost + ", immediate_bid_cost="
				+ immediate_bid_cost + ", register_date=" + register_date + ", auction_end_date=" + auction_end_date
				+ ", auction_end_status=" + auction_end_status + ", sale_id=" + sale_id + ", item_name=" + item_name
				+ ", buy_time=" + buy_time + ", item_status=" + item_status + ", item_scratch=" + item_scratch
				+ ", additional_info=" + additional_info + ", buy_info=" + buy_info + ", sale_date=" + sale_date
				+ ", item_pic1=" + item_pic1 + ", item_pic2=" + item_pic2 + ", item_pic3=" + item_pic3 + ", item_pic4="
				+ item_pic4 + ", email=" + email + ", item_cost=" + item_cost + ", subca_id=" + subca_id
				 + ", flag=" + flag + "]";
	}



	

}

