package com.masai.model;

public class VendorDTO {

	private String v_name;
	private double v_mob;
	private String email;
	private String company;
	private String Address;
	public VendorDTO(String v_name, double v_mob, String email, String company, String address) {
		super();
		this.v_name = v_name;
		this.v_mob = v_mob;
		this.email = email;
		this.company = company;
		Address = address;
	}
	public VendorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public double getV_mob() {
		return v_mob;
	}
	public void setV_mob(double v_mob) {
		this.v_mob = v_mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "vendorDTO [v_name=" + v_name + ", v_mob=" + v_mob + ", email=" + email + ", company=" + company
				+ ", Address=" + Address + "]";
	}
	
	
}
