package jungkosta.main.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board2VO implements Serializable{
	private int board_id;
	private String name;
	private String title;
	private String content;
	private int views_num;
	private Timestamp write_date;
	
	public Board2VO() {
		// TODO Auto-generated constructor stub
	}
	
	public Board2VO(int board_id, String name, String title,
			String content, int views_num, Timestamp write_date) {
		super();
		this.board_id = board_id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setViews_num(int views_num) {
		this.views_num = views_num;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

}
