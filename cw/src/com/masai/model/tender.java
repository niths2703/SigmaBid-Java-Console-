package com.masai.model;

import java.sql.Date;
import java.time.LocalDate;

public class Tender {


	private int t_id;
	private String t_name;
	private String t_type;
	private int t_price;
	private String t_desc;
	private LocalDate t_deadline;
	private String t_location;
	
	public Tender() {
		
	}

	public Tender( int t_id, String t_name, String t_type, int t_price, String t_desc, LocalDate t_deadline,
			String t_location) {
		super();
		
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_type = t_type;
		this.t_price = t_price;
		this.t_desc = t_desc;
		this.t_deadline = t_deadline;
		this.t_location = t_location;
	}

	

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_type() {
		return t_type;
	}

	public void setT_type(String t_type) {
		this.t_type = t_type;
	}

	public int getT_price() {
		return t_price;
	}

	public void setT_price(int t_price) {
		this.t_price = t_price;
	}

	public String getT_desc() {
		return t_desc;
	}

	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}

	public LocalDate getT_deadline() {
		return t_deadline;
	}

	public void setT_deadline(LocalDate t_deadline2) {
		this.t_deadline =  t_deadline2;
	}

	public String getT_location() {
		return t_location;
	}

	public void setT_location(String t_location) {
		this.t_location = t_location;
	}

	@Override
	public String toString() {
		return "tender [t_id=" + t_id + ", t_name=" + t_name + ", t_type=" + t_type + ", t_price="
				+ t_price + ", t_desc=" + t_desc + ", t_deadline=" + t_deadline + ", t_location=" + t_location + "]";
	}
	
	
	
	
	
}
