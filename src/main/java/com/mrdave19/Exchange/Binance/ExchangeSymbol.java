package com.mrdave19.Exchange.Binance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeSymbol {
	
	private String symbol;
	private String status;
	private String baseAsset;
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
		return "BinanceSymbol [symbol=" + symbol + ", status=" + status + ", baseAsset=" + baseAsset + ", quateAsset="
				+ quoteAsset + "]";
	}

	
	

}
