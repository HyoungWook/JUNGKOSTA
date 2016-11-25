package jungkosta.trade.domain;

import java.io.Serializable;

public class SubCategoryVO implements Serializable{
	private int subca_id;
	private String subca_name;
	private int ca_id;
	
	public SubCategoryVO(){}

	public SubCategoryVO(int subca_id, String subca_name, int ca_id) {
		super();
		this.subca_id = subca_id;
		this.subca_name = subca_name;
		this.ca_id = ca_id;
	}

	public int getSubca_id() {
		return subca_id;
	}

	public void setSubca_id(int subca_id) {
		this.subca_id = subca_id;
	}

	public String getSubca_name() {
		return subca_name;
	}

	public void setSubca_name(String subca_name) {
		this.subca_name = subca_name;
	}

	public int getCa_id() {
		return ca_id;
	}

	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}

	@Override
	public String toString() {
		return "SubCategoryVO [subca_id=" + subca_id + ", subca_name=" + subca_name + ", ca_id=" + ca_id + "]";
	}
	
	
}
