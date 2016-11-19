package jungkosta.trade.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class PurchaseVO implements Serializable{
	private int purchase_id;
	private int delivery_cost;
	private String payment_method;
	private Timestamp purchase_date;
	private String email;
	private int sale_id;
	private Timestamp purchase_deadline;
	
	public PurchaseVO(){}

	public PurchaseVO(int purchase_id, int delivery_cost, String payment_method, Timestamp purchase_date, String email,
			int sale_id, Timestamp purchase_deadline) {
		super();
		this.purchase_id = purchase_id;
		this.delivery_cost = delivery_cost;
		this.payment_method = payment_method;
		this.purchase_date = purchase_date;
		this.email = email;
		this.sale_id = sale_id;
		this.purchase_deadline = purchase_deadline;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getDelivery_cost() {
		return delivery_cost;
	}

	public void setDelivery_cost(int delivery_cost) {
		this.delivery_cost = delivery_cost;
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

	@Override
	public String toString() {
		return "PurchaseVO [purchase_id=" + purchase_id + ", delivery_cost=" + delivery_cost + ", payment_method="
				+ payment_method + ", purchase_date=" + purchase_date + ", email=" + email + ", sale_id=" + sale_id
				+ ", purchase_deadline=" + purchase_deadline + "]";
	}
	
	
}
