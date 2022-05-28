package com.mrdave19.Exchange.Binance;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private String[][] bids;
	private String[][] asks;
	
	
	public String[][] getBids() {
		return bids;
	}
	public void setBids(String[][] bids) {
		this.bids = bids;
	}
	public String[][] getAsks() {
		return asks;
	}
	public void setAsks(String[][] asks) {
		this.asks = asks;
	}
	@Override
	public String toString() {
		return "BinanceQuotation [bids=" + Arrays.toString(bids) + ", asks=" + Arrays.toString(asks) + "]\n";
	}
	
	

}
