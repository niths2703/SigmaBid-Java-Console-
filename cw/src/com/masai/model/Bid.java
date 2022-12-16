package com.masai.model;

public class Bid {

	private int b_id;
	private int v_id;
	private int t_id;
	private double bid_value;
	
	private boolean bid_status;

	public Bid(int b_id, int v_id, int t_id, double bid_value, boolean bid_status) {
		super();
		this.b_id = b_id;
		this.v_id = v_id;
		this.t_id = t_id;
		this.bid_value = bid_value;
		this.bid_status = bid_status;
	}

	public Bid() {
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

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public double getBid_value() {
		return bid_value;
	}

	public void setBid_value(double bid_value) {
		this.bid_value = bid_value;
	}

	public boolean isBid_status() {
		return bid_status;
	}

	public void setBid_status(boolean bid_status) {
		this.bid_status = bid_status;
	}

	@Override
	public String toString() {
		return "bid [b_id=" + b_id + ", v_id=" + v_id + ", t_id=" + t_id + ", bid_value=" + bid_value + ", bid_status="
				+ bid_status + "]";
	}
	
	
	
}
