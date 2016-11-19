package jungkosta.auction.domain;

import java.sql.Timestamp;

public class AuctionReplyVO {

	private int item_qa_id;
	private String content;
	private Timestamp register_date;
	private int sale_id;
	private String email;
	private int ref;
	private int qa_level;
	private int step;

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

	public Timestamp getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Timestamp register_date) {
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

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getQa_level() {
		return qa_level;
	}

	public void setQa_level(int qa_level) {
		this.qa_level = qa_level;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "AuctionReplyVO [item_qa_id=" + item_qa_id + ", content=" + content + ", register_date=" + register_date
				+ ", sale_id=" + sale_id + ", email=" + email + ", ref=" + ref + ", qa_level=" + qa_level + ", step="
				+ step + "]";
	}

}
