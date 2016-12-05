package jungkosta.main.domain;

import java.sql.Timestamp;

public class TradePurVO {

	private String email;
	private int sale_id;
	private String item_name;
	private String item_pic1;
	private int purchase_id;
	private Timestamp purchase_date;
	private int purchase_cost;
	private String purchase_status;
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
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public Timestamp getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Timestamp purchase_date) {
		this.purchase_date = purchase_date;
	}
	public int getPurchase_cost() {
		return purchase_cost;
	}
	public void setPurchase_cost(int purchase_cost) {
		this.purchase_cost = purchase_cost;
	}
	public String getPurchase_status() {
		return purchase_status;
	}
	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
	}
	public String getSale_status() {
		return sale_status;
	}
	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}
	
	

}
