package com.mrdave19.Exchange.Huobi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeHuobi {
	
	@JsonProperty("data")
	private ExchangeSymbol[] data;
	

	public ExchangeSymbol[] getData() {
		return data;
	}

	public void setData(ExchangeSymbol[] data) {
		this.data = data;
	}


	
	
	
}
