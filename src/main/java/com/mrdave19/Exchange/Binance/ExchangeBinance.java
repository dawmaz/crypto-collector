package com.mrdave19.Exchange.Binance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeBinance {
	
	private ExchangeSymbol[] symbols;

	public ExchangeSymbol[] getSymbols() {
		return symbols;
	}

	public void setSymbols(ExchangeSymbol[] symbols) {
		this.symbols = symbols;
	}
	
	
	
}
