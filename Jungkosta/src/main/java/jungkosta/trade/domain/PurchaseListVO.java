package jungkosta.trade.domain;

import java.io.Serializable;
import java.sql.Timestamp;
//2016/12/01 우성 추가

public class PurchaseListVO implements Serializable {
	
	private String item_pic1;
	private String item_name;
	private String sale_id;
	private int purchase_cost;
	private Timestamp purchase_deadline;
	private String email;
	
	public PurchaseListVO() {
		// TODO Auto-generated constructor stub
	}

	


	public PurchaseListVO(String item_pic1, String item_name, String sale_id, int purchase_cost,
			Timestamp purchase_deadline, String email) {
		super();
		this.item_pic1 = item_pic1;
		this.item_name = item_name;
		this.sale_id = sale_id;
		this.purchase_cost = purchase_cost;
		this.purchase_deadline = purchase_deadline;
		this.email = email;
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

	public int getPurchase_cost() {
		return purchase_cost;
	}

	public void setPurchase_cost(int purchase_cost) {
		this.purchase_cost = purchase_cost;
	}

	public Timestamp getPurchase_deadline() {
		return purchase_deadline;
	}

	public void setPurchase_deadline(Timestamp purchase_deadline) {
		this.purchase_deadline = purchase_deadline;
	}

	public String getSale_id() {
		return sale_id;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
