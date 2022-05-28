package com.mrdave19.Exchange.Gemini;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolGemini implements Tickerable{

	btcusd,
	ethbtc,
	ethusd,
	bchusd,
	bchbtc,
	ltcusd,
	ltcbtc,
	zecusd,
	zecbtc,
	batusd,
	batbtc,
	bateth,
	linketh,;

	@Override
	public String getTicker() {
		return this.name().toUpperCase();
	}

	@Override
	public String getSymbol() {
		return this.name();
	}

}
