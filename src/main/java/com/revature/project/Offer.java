package com.revature.project;

public class Offer {
	
	@Override
	public String toString() {
		return "Offer [offer_id=" + offer_id + ", customerid=" + customerid + ", carid=" + carid + ", status_id="
				+ status_id + ", offer_price=" + offer_price + "]";
	}

	private Integer offer_id;
	private Integer customerid;
	private Integer carid;
	private Integer status_id;
	private Double offer_price;
	
	
	public Offer(Integer offer_id, Integer customerid, Integer carid, Double offer_price,Integer status_id ) {
		super();
		this.offer_id = offer_id;
		this.customerid = customerid;
		this.carid = carid;
		this.status_id = status_id;
		this.offer_price = offer_price;
	}
	
	public Offer( Integer customerid, Integer carid, Double offer_price, Integer status_id) {
		super();
		
		this.customerid = customerid;
		this.carid = carid;
		this.status_id = status_id;
		this.offer_price = offer_price;
	}

	public Integer getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(Integer offer_id) {
		this.offer_id = offer_id;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public Double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(Double offer_price) {
		this.offer_price = offer_price;
	}
	
	
	
	
	
	

}
