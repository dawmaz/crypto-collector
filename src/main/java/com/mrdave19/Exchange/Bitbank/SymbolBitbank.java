package com.mrdave19.Exchange.Bitbank;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBitbank implements Tickerable {

	
	xrp_btc, 
	ltc_btc, 
	eth_btc;

	@Override
	public String getTicker() {
		return this.name().replace("_", "").toUpperCase();
	}

	@Override
	public String getSymbol() {
		return this.name();
	} 
	
}
