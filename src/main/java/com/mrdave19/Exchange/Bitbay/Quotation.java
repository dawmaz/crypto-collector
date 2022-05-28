package com.mrdave19.Exchange.Bitbay;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private Double[][] bids;
	private Double[][] asks;
	
	
	public Double[][] getBids() {
		return bids;
	}
	public void setBids(Double[][] bids) {
		this.bids = bids;
	}
	public Double[][] getAsks() {
		return asks;
	}
	public void setAsks(Double[][] asks) {
		this.asks = asks;
	}
	
	
	
}
