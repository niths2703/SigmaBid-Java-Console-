package com.masai.model;

public class BidDTO {

	private int b_id;
	private int v_id;
	
	private double bid_value;

	public BidDTO(int b_id, int v_id, double bid_value) {
		super();
		this.b_id = b_id;
		this.v_id = v_id;
		this.bid_value = bid_value;
	}

	public BidDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public double getBid_value() {
		return bid_value;
	}

	public void setBid_value(double bid_value) {
		this.bid_value = bid_value;
	}

	@Override
	public String toString() {
		return "bidDTO [b_id=" + b_id + ", v_id=" + v_id + ", bid_value=" + bid_value + "]";
	}
	
	
}
