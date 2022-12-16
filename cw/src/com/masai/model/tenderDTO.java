package com.masai.model;

import java.sql.Date;
import java.time.LocalDate;

public class TenderDTO {

	private String t_name;
	private String t_type;
	private String t_price;
	private String t_desc;
	private LocalDate t_deadline;
	private String t_location;
	
	private boolean tender_status;

	public TenderDTO(String t_name, String t_type, String t_price, String t_desc, LocalDate t_deadline, String t_location,
			boolean tender_status) {
		super();
		this.t_name = t_name;
		this.t_type = t_type;
		this.t_price = t_price;
		this.t_desc = t_desc;
		this.t_deadline = t_deadline;
		this.t_location = t_location;
		this.tender_status = tender_status;
	}

	public TenderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "tenderDTO [t_name=" + t_name + ", t_type=" + t_type + ", t_price=" + t_price + ", t_desc=" + t_desc
				+ ", t_deadline=" + t_deadline + ", t_location=" + t_location + ", tender_status=" + tender_status
				+ "]";
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

	public String getT_price() {
		return t_price;
	}

	public void setT_price(String t_price) {
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

	public void setT_deadline(LocalDate t_deadline) {
		this.t_deadline = t_deadline;
	}

	public String getT_location() {
		return t_location;
	}

	public void setT_location(String t_location) {
		this.t_location = t_location;
	}

	public boolean isTender_status() {
		return tender_status;
	}

	public void setTender_status(boolean tender_status) {
		this.tender_status = tender_status;
	}
	
	
	
}
