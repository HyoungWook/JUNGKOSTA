package jungkosta.trade.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SaleVO implements Serializable{
	private int sale_id;
	private String item_name;
	private int item_cost;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date buy_time;
	
	private String item_status;
	private String item_scratch;
	private String additional_info;
	private String buy_info;
	private Date sale_date;

	private String email = "test2@test2.com";
	private int subca_id;
	private char flag = '0';
	private String sale_status;
	private String item_pic1;
	private String item_pic2;
	private String item_pic3;
	private String item_pic4;
	
	public SaleVO(){}

	public SaleVO(int sale_id, String item_name, int item_cost, Date buy_time, String item_status, String item_scratch,
			String additional_info, String buy_info, Date sale_date, String email, int subca_id, char flag,
			String sale_status, String item_pic1, String item_pic2, String item_pic3, String item_pic4) {
		super();
		this.sale_id = sale_id;
		this.item_name = item_name;
		this.item_cost = item_cost;
		this.buy_time = buy_time;
		this.item_status = item_status;
		this.item_scratch = item_scratch;
		this.additional_info = additional_info;
		this.buy_info = buy_info;
		this.sale_date = sale_date;
		this.email = email;
		this.subca_id = subca_id;
		this.flag = flag;
		this.sale_status = sale_status;
		this.item_pic1 = item_pic1;
		this.item_pic2 = item_pic2;
		this.item_pic3 = item_pic3;
		this.item_pic4 = item_pic4;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(int item_cost) {
		this.item_cost = item_cost;
	}

	public Date getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(Date buy_time) {
		this.buy_time = buy_time;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public String getItem_scratch() {
		return item_scratch;
	}

	public void setItem_scratch(String item_scratch) {
		this.item_scratch = item_scratch;
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}

	public String getBuy_info() {
		return buy_info;
	}

	public void setBuy_info(String buy_info) {
		this.buy_info = buy_info;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSubca_id() {
		return subca_id;
	}

	public void setSubca_id(int subca_id) {
		this.subca_id = subca_id;
	}

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		this.flag = flag;
	}

	public String getSale_status() {
		return sale_status;
	}

	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}

	public String getItem_pic1() {
		return item_pic1;
	}

	public void setItem_pic1(String item_pic1) {
		this.item_pic1 = item_pic1;
	}

	public String getItem_pic2() {
		return item_pic2;
	}

	public void setItem_pic2(String item_pic2) {
		this.item_pic2 = item_pic2;
	}

	public String getItem_pic3() {
		return item_pic3;
	}

	public void setItem_pic3(String item_pic3) {
		this.item_pic3 = item_pic3;
	}

	public String getItem_pic4() {
		return item_pic4;
	}

	public void setItem_pic4(String item_pic4) {
		this.item_pic4 = item_pic4;
	}

	@Override
	public String toString() {
		return "SaleVO [sale_id=" + sale_id + ", item_name=" + item_name + ", item_cost=" + item_cost + ", buy_time="
				+ buy_time + ", item_status=" + item_status + ", item_scratch=" + item_scratch + ", additional_info="
				+ additional_info + ", buy_info=" + buy_info + ", sale_date=" + sale_date + ", email=" + email
				+ ", subca_id=" + subca_id + ", flag=" + flag + ", sale_status=" + sale_status + ", item_pic1="
				+ item_pic1 + ", item_pic2=" + item_pic2 + ", item_pic3=" + item_pic3 + ", item_pic4=" + item_pic4
				+ "]";
	}

}
