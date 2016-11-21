package jungkosta.auction.domain;

public class CategoryVO  {

	private int ca_id;
	private String ca_name;
	private int subca_id;
	private String subca_name;

	public int getCa_id() {
		return ca_id;
	}

	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}

	public String getCa_name() {
		return ca_name;
	}

	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
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

	@Override
	public String toString() {
		return "CategoryVO [ca_id=" + ca_id + ", ca_name=" + ca_name + ", subca_id=" + subca_id + ", subca_name="
				+ subca_name + "]";
	}

}
