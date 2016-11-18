package jungkosta.main.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardVO implements Serializable{
	
	private int board_id;
	private String email;
	private String title;
	private String content;
	private int views_num;
	private Timestamp write_date;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int board_id, String email, String title, String content,
			int views_num, Timestamp write_date) {
		super();
		this.board_id = board_id;
		this.email = email;
		this.title = title;
		this.content = content;
		this.views_num = views_num;
		this.write_date = write_date;
	}
	
	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getViews_num() {
		return views_num;
	}

	public void setViews_Num(int views_num) {
		this.views_num = views_num;
	}

	public Timestamp getWrite_Date() {
		return write_date;
	}

	public void setWrite_Date(Timestamp write_Date) {
		this.write_date = write_Date;
	}

	
}
