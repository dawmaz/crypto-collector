package com.mrdave19.Exchange.Bittrex;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

class Quotee{
	@JsonProperty("Quantity")
	private double quantity;
	@JsonProperty("Rate")
	private double price;
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}

class Result{
	
	
	private Quotee[] buy;
	private Quotee[] sell;
	
	
	public Quotee[] getBuy() {
		return buy;
	}
	public void setBuy(Quotee[] buy) {
		this.buy = buy;
	}
	public Quotee[] getSell() {
		return sell;
	}
	public void setSell(Quotee[]sell) {
		this.sell = sell;
	}
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
	
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	

	
	
}
