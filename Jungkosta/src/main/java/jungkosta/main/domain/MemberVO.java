package jungkosta.main.domain;

import java.io.Serializable;

public class MemberVO implements Serializable{
	private String email;
	private String password;
	private String name;
	private String address;
	private String phone_num;
	private String question;
	private String answer;
	private String account_num;
	private int point;
	private String grade;
	private String interests_1;
	private String interests_2;
	private String interests_3;
	private String resident_id;
	private int warning_num;
	private String bank_name;
	
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phone_num=" + phone_num + ", question=" + question + ", answer=" + answer + ", account_num="
				+ account_num + ", point=" + point + ", grade=" + grade + ", interests_1=" + interests_1
				+ ", interests_2=" + interests_2 + ", interests_3=" + interests_3 + ", resident_id=" + resident_id
				+ ", warning_num=" + warning_num + ", bank_name=" + bank_name + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getInterests_1() {
		return interests_1;
	}
	public void setInterests_1(String interests_1) {
		this.interests_1 = interests_1;
	}
	public String getInterests_2() {
		return interests_2;
	}
	public void setInterests_2(String interests_2) {
		this.interests_2 = interests_2;
	}
	public String getInterests_3() {
		return interests_3;
	}
	public void setInterests_3(String interests_3) {
		this.interests_3 = interests_3;
	}
	public String getResident_id() {
		return resident_id;
	}
	public void setResident_id(String resident_id) {
		this.resident_id = resident_id;
	}
	public int getWarning_num() {
		return warning_num;
	}
	public void setWarning_num(int warning_num) {
		this.warning_num = warning_num;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	
}
