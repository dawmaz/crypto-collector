package com.mrdave19.Exchange.Bittrex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeSymbol {
	
	@JsonProperty("MarketName")
	private String symbol;
	@JsonProperty("IsActive")
	private boolean status;
	@JsonProperty("BaseCurrency")
	private String baseAsset;
	@JsonProperty("MarketCurrency")
	private String quoteAsset;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
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
