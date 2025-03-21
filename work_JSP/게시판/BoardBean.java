package magic.board;

import java.sql.Timestamp;

public class BoardBean {
	private int bod_id;
	private String bod_name;
	private String bod_email;
	private String bod_title;
	private String bod_content;
	private Timestamp bod_date;
	private int bod_hit;
	private String bod_pwd;
	private String bod_ip;
	private int bod_ref=0;
	private int bod_step=0;
	private int bod_level=0;
	
	public int getBod_ref() {
		return bod_ref;
	}
	public void setBod_ref(int bod_ref) {
		this.bod_ref = bod_ref;
	}
	public int getBod_step() {
		return bod_step;
	}
	public void setBod_step(int bod_step) {
		this.bod_step = bod_step;
	}
	public int getBod_level() {
		return bod_level;
	}
	public void setBod_level(int bod_level) {
		this.bod_level = bod_level;
	}
	public String getBod_ip() {
		return bod_ip;
	}
	public void setBod_ip(String bod_ip) {
		this.bod_ip = bod_ip;
	}
	public String getBod_pwd() {
		return bod_pwd;
	}
	public void setBod_pwd(String bod_pwd) {
		this.bod_pwd = bod_pwd;
	}
	public int getBod_hit() {
		return bod_hit;
	}
	public void setBod_hit(int bod_hit) {
		this.bod_hit = bod_hit;
	}
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
