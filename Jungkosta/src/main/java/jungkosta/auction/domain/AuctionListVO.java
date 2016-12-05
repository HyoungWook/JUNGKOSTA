package jungkosta.auction.domain;

import java.io.Serializable;
import java.sql.Timestamp;

//2016/12/01 우성 추가
public class AuctionListVO implements Serializable {
	
	private String item_pic1;
	private String item_name;
	private String email;
	private int sale_id;
	private Timestamp purchase_deadline;
	
	public AuctionListVO() {
		// TODO Auto-generated constructor stub
	}
	
	public AuctionListVO(String item_pic1, String item_name, String email, int sale_id, Timestamp purchase_deadline) {
		this.item_pic1 = item_pic1;
		this.item_name = item_name;
		this.email = email;
		this.sale_id = sale_id;
		this.purchase_deadline = purchase_deadline;
	}



	public String getItem_pic1() {
		return item_pic1;
	}

	public void setItem_pic1(String item_pic1) {
		this.item_pic1 = item_pic1;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

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

	public Timestamp getPurchase_deadline() {
		return purchase_deadline;
	}

	public void setPurchase_deadline(Timestamp purchase_deadline) {
		this.purchase_deadline = purchase_deadline;
	}
	
	
}
