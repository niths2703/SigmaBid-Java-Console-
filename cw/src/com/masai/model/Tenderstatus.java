package com.masai.model;

public class Tenderstatus {

	private int tender_id;
	
	private boolean tender_status;
	
	private int vendor_id;

	public Tenderstatus(int tender_id, boolean tender_status, int vendor_id) {
		super();
		this.tender_id = tender_id;
		this.tender_status = tender_status;
		this.vendor_id = vendor_id;
	}

	public Tenderstatus() {
		super();
	}

	public int getTender_id() {
		return tender_id;
	}

	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}

	public boolean isTender_status() {
		return tender_status;
	}

	public void setTender_status(boolean tender_status) {
		this.tender_status = tender_status;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	@Override
	public String toString() {
		return "tenderstatus [tender_id=" + tender_id + ", tender_status=" + tender_status + ", vendor_id=" + vendor_id
				+ "]";
	}
	
	
}
