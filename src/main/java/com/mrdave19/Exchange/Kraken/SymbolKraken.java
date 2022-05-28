package com.mrdave19.Exchange.Kraken;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolKraken implements Tickerable {

	BATETH,
	BATUSD,
	BCHUSD,
	EOSETH,
	ETHUSDT,
	LINKETH,
	OMGETH,
	TRXETH,
	ETHEUR,
	ETHUSD,
	LTCUSD,
	XRPEUR,
	XRPUSD,
	ZECUSD,;

	@Override
	public String getTicker() {
		return this.name();
	}

	@Override
	public String getSymbol() {
		return this.name();
	}


}
