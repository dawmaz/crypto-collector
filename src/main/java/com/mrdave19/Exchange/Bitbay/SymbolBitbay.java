package com.mrdave19.Exchange.Bitbay;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBitbay implements Tickerable {

	BTCUSD,
	ETHUSD,
	LTCUSD,
	XRPUSD,
	ZECUSD,
	BATUSD,
	BTCEUR,
	ETHEUR,
	XRPEUR,
	ETHBTC,
	LTCBTC,
	DASHBTC,
	XRPBTC,
	ZECBTC,
	GNTBTC,
	OMGBTC,
	ZRXBTC,
	BATBTC,
	TRXBTC,;

	@Override
	public String getTicker() {
		return this.name();
	}

	@Override
	public String getSymbol() {
		return this.name();
	}


}
