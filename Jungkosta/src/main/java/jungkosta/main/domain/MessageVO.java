package jungkosta.main.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class MessageVO implements Serializable{

	
	private int message_id;
	private String title;
	private String content;
	private Timestamp send_time;
	private String receiver;
	private String sender;
	private String message_isread;
	
	public MessageVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MessageVO(int message_id, String title, String content,
			Timestamp send_time, String receiver,
			String sender, String message_isread) {
		super();
		this.message_id = message_id;
		this.title = title;
		this.content = content;
		this.send_time = send_time;
		this.receiver = receiver;
		this.sender = sender;
		this.message_isread = message_isread;
	}



	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSend_time() {
		return send_time;
	}
	public void setSend_time(Timestamp send_time) {
		this.send_time = send_time;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage_isread() {
		return message_isread;
	}
	public void setMessage_isread(String message_isread) {
		this.message_isread = message_isread;
	}
}
