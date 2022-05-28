package com.mrdave19.Exchange.Kraken;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeKraken {
	
	private Map<String,ExchangeSymbol> result;

	public Map<String, ExchangeSymbol> getResult() {
		return result;
	}

	public void setResult(Map<String, ExchangeSymbol> result) {
		this.result = result;
	}
	



	
	
	
}
