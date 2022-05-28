package com.mrdave19.Exchange.Bitstamp;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBitstamp implements Tickerable{

	btcusd,
	btceur,
	xrpusd,
	xrpeur,
	xrpbtc,
	ltcusd,
	ltcbtc,
	ethusd,
	etheur,
	ethbtc,
	bchusd,
	bchbtc,;

	@Override
	public String getTicker() {
		return this.name().toUpperCase();
	}

	@Override
	public String getSymbol() {
		return this.name();
	}


}
