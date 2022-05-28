package com.mrdave19.Exchange.Bitbank;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Tick{
	
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
		return "Tick [bids=" + Arrays.toString(bids) + ", asks=" + Arrays.toString(asks) + "]\n";
	}
	
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private Tick data;

	public Tick getData() {
		return data;
	}

	public void setData(Tick tick) {
		this.data = tick;
	}

	@Override
	public String toString() {
		return "Quotation [tick=" + data + "]";
	}

	
	
}
