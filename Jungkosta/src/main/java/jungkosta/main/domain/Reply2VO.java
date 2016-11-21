package jungkosta.main.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply2VO implements Serializable {
	
	private int reply_id;
	private int board_id;
	private String name;
	private String content;
	private Timestamp write_date;
	
	public Reply2VO() {
		// TODO Auto-generated constructor stub
	}

	public Reply2VO(int reply_id, int board_id, String name,
			String content, Timestamp write_date) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.name = name;
		this.content = content;
		this.write_date = write_date;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
}
