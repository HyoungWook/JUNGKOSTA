package jungkosta.main.domain;

import java.io.Serializable;

public class BlackListVO implements Serializable {
	private int blacklist_id;
	private String reason;
	private String email;
	private int admin_id;
	
	public BlackListVO() {
	}
	
	public BlackListVO(int blacklist_id, String reason, String email,
			int admin_id) {
		super();
		this.blacklist_id = blacklist_id;
		this.reason = reason;
		this.email = email;
		this.admin_id = admin_id;
	}
	
	public int getBlacklist_id() {
		return blacklist_id;
	}
	public void setBlacklist_id(int blacklist_id) {
		this.blacklist_id = blacklist_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
}
