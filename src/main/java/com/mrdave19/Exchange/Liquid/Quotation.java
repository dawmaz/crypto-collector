package com.mrdave19.Exchange.Liquid;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	@JsonProperty("buy_price_levels")
	private String[][] bids;
	@JsonProperty("sell_price_levels")
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
