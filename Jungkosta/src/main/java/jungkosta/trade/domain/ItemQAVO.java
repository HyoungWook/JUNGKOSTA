package jungkosta.trade.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ItemQAVO {
	
	private int item_qa_id;
	private String content;
	private Date register_date;
	private int sale_id;
	private String email;
	
	public ItemQAVO(){}

	public ItemQAVO(int item_qa_id, String content, Date register_date, int sale_id, String email) {
		super();
		this.item_qa_id = item_qa_id;
		this.content = content;
		this.register_date = register_date;
		this.sale_id = sale_id;
		this.email = email;
	}

	public int getItem_qa_id() {
		return item_qa_id;
	}

	public void setItem_qa_id(int item_qa_id) {
		this.item_qa_id = item_qa_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ItemQAVO [item_qa_id=" + item_qa_id + ", content=" + content + ", register_date=" + register_date
				+ ", sale_id=" + sale_id + ", email=" + email + "]";
	}

}
