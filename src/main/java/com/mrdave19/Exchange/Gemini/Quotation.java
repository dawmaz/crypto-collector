package com.mrdave19.Exchange.Gemini;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Quotee{
	
	private String price;
	private String amount;
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private Quotee[] bids;
	private Quotee[] asks;
	
	
	public Quotee[] getBids() {
		return bids;
	}
	public void setBids(Quotee[] bids) {
		this.bids = bids;
	}
	public Quotee[] getAsks() {
		return asks;
	}
	public void setAsks(Quotee[] asks) {
		this.asks = asks;
	}

	
	
}
