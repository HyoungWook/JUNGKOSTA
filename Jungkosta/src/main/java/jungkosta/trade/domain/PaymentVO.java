package jungkosta.trade.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class PaymentVO implements Serializable{
	private int payment_id;
	private int payment_cost;
	private String payment_status;
	private Timestamp payment_date;
	private int purchase_id;
	
	public PaymentVO(){}

	public PaymentVO(int payment_id, int payment_cost, String payment_status, Timestamp payment_date, int purchase_id) {
		super();
		this.payment_id = payment_id;
		this.payment_cost = payment_cost;
		this.payment_status = payment_status;
		this.payment_date = payment_date;
		this.purchase_id = purchase_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getPayment_cost() {
		return payment_cost;
	}

	public void setPayment_cost(int payment_cost) {
		this.payment_cost = payment_cost;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Timestamp getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Timestamp payment_date) {
		this.payment_date = payment_date;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	@Override
	public String toString() {
		return "PaymentVO [payment_id=" + payment_id + ", payment_cost=" + payment_cost + ", payment_status="
				+ payment_status + ", payment_date=" + payment_date + ", purchase_id=" + purchase_id + "]";
	}

	
	
	
}
