package magic.board;

import java.sql.Timestamp;

public class BoardBean {
	private int bod_id;
	private String bod_name;
	private String bod_email;
	private String bod_title;
	private String bod_content;
	private Timestamp bod_date;
	
	public int getBod_id() {
		return bod_id;
	}
	public void setBod_id(int bod_id) {
		this.bod_id = bod_id;
	}
	public String getBod_name() {
		return bod_name;
	}
	public void setBod_name(String bod_name) {
		this.bod_name = bod_name;
	}
	public String getBod_email() {
		return bod_email;
	}
	public void setBod_email(String bod_email) {
		this.bod_email = bod_email;
	}
	public String getBod_title() {
		return bod_title;
	}
	public void setBod_title(String bod_title) {
		this.bod_title = bod_title;
	}
	public String getBod_content() {
		return bod_content;
	}
	public void setBod_content(String bod_content) {
		this.bod_content = bod_content;
	}
	public Timestamp getBod_date() {
		return bod_date;
	}
	public void setBod_date(Timestamp bod_date) {
		this.bod_date = bod_date;
	}
	
}
