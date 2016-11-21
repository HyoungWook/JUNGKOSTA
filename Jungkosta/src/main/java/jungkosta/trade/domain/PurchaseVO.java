package jungkosta.trade.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class PurchaseVO implements Serializable{
	private int purchase_id;
	private int purchase_cost;
	private String payment_method;
	private Timestamp purchase_date;
	private String email;
	private int sale_id;
	private Timestamp purchase_deadline;
	private String purchase_status;
	
	public PurchaseVO(){}

	public PurchaseVO(int purchase_id, int purchase_cost, String payment_method, Timestamp purchase_date, String email,
			int sale_id, Timestamp purchase_deadline, String purchase_status) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_cost = purchase_cost;
		this.payment_method = payment_method;
		this.purchase_date = purchase_date;
		this.email = email;
		this.sale_id = sale_id;
		this.purchase_deadline = purchase_deadline;
		this.purchase_status = purchase_status;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getPurchase_cost() {
		return purchase_cost;
	}

	public void setPurchase_cost(int purchase_cost) {
		this.purchase_cost = purchase_cost;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public Timestamp getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Timestamp purchase_date) {
		this.purchase_date = purchase_date;
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

	public String getPurchase_status() {
		return purchase_status;
	}

	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
	}

	@Override
	public String toString() {
		return "PurchaseVO [purchase_id=" + purchase_id + ", purchase_cost=" + purchase_cost + ", payment_method="
				+ payment_method + ", purchase_date=" + purchase_date + ", email=" + email + ", sale_id=" + sale_id
				+ ", purchase_deadline=" + purchase_deadline + ", purchase_status=" + purchase_status + "]";
	}


	
}
