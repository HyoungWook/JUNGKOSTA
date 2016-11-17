package jungkosta.trade.domain;

public class CategoryVO {
	private int ca_id;
	private String ca_name;
	
	public CategoryVO(){}

	public CategoryVO(int ca_id, String ca_name) {
		super();
		this.ca_id = ca_id;
		this.ca_name = ca_name;
	}

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

	@Override
	public String toString() {
		return "CategoryVO [ca_id=" + ca_id + ", ca_name=" + ca_name + "]";
	}
	
	
	
}
