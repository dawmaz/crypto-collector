package com.mrdave19.Exchange.Kraken;


import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Offer{
	
	private Object[][] bids;
	private Object[][] asks;
	
	
	public Object[][] getBids() {
		return bids;
	}
	public void setBids(Object[][] bids) {
		this.bids = bids;
	}
	public Object[][] getAsks() {
		return asks;
	}
	public void setAsks(Object[][] asks) {
		this.asks = asks;
	}
	@Override
	public String toString() {
		return "Offer [bids=" + Arrays.toString(bids) + ", asks=" + Arrays.toString(asks) + "]\n";
	}
	
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private Map<String,Offer> result;

	public Map<String, Offer> getResult() {
		return result;
	}

	public void setResult(Map<String, Offer> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Quotation [result=" + result + "]";
	}

	
	
}
