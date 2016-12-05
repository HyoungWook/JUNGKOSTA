package jungkosta.main.domain;

import java.io.Serializable;

public class CustomPreferVO implements Serializable {
	
	private int customprefer_id;
	private int view_num;
	private int sale_id;
	private String email;
	
	
	public CustomPreferVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomPreferVO(int customprefer_id, int view_num, int sale_id, String email) {
		super();
		this.customprefer_id = customprefer_id;
		this.view_num = view_num;
		this.sale_id = sale_id;
		this.email = email;
	}

	public int getCustomprefer_id() {
		return customprefer_id;
	}
	public void setCustomprefer_id(int customprefer_id) {
		this.customprefer_id = customprefer_id;
	}
	public int getView_num() {
		return view_num;
	}
	public void setView_num(int view_num) {
		this.view_num = view_num;
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
	
}
