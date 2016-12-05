package jungkosta.main.domain;

import java.sql.Timestamp;

public class AucPurVO {

	private String email;
	private int sale_id;
	private String item_name;
	private String item_pic1;
	private int bid_id;
	private Timestamp purchase_date;
	private int total_cost;
	private String bid_status;
	private String del_address;
	private String sale_status;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getItem_pic1() {
		return item_pic1;
	}

	public void setItem_pic1(String item_pic1) {
		this.item_pic1 = item_pic1;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public Timestamp getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Timestamp purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public String getBid_status() {
		return bid_status;
	}

	public void setBid_status(String bid_status) {
		this.bid_status = bid_status;
	}

	public String getDel_address() {
		return del_address;
	}

	public void setDel_address(String del_address) {
		this.del_address = del_address;
	}

	public String getSale_status() {
		return sale_status;
	}

	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}

	@Override
	public String toString() {
		return "AucPurVO [email=" + email + ", sale_id=" + sale_id + ", item_name=" + item_name + ", item_pic1="
				+ item_pic1 + ", bid_id=" + bid_id + ", purchase_date=" + purchase_date + ", total_cost=" + total_cost
				+ ", bid_status=" + bid_status + ", del_address=" + del_address + ", sale_status=" + sale_status + "]";
	}

}
