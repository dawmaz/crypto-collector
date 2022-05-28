package com.mrdave19.Exchange.Kraken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeSymbol {
	
	@JsonProperty("altname")
	private String symbol;
	@JsonProperty("base")
	private String baseAsset;
	@JsonProperty("quote")
	private String quoteAsset;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
		return "ExchangeSymbol [symbol=" + symbol + ", baseAsset=" + baseAsset + ", quoteAsset="
				+ quoteAsset + "]";
	}


	
	

}
