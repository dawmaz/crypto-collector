package com.mrdave19.Exchange.Huobi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeSymbol {
	
	private String symbol;
	@JsonProperty("state")
	private String status;
	@JsonProperty("base-currency")
	private String baseAsset;
	@JsonProperty("quote-currency")
	private String quoteAsset;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBaseAsset() {
		return baseAsset;
	}
	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}
	public String getQuoteAsset() {
		return quoteAsset;
	}
	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}
	@Override
	public String toString() {
		return "ExchangeSymbol [symbol=" + symbol + ", status=" + status + ", baseAsset=" + baseAsset + ", quoteAsset="
				+ quoteAsset + "]";
	}


	
	

}
