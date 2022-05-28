package com.mrdave19.Exchange.Huobi;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolHuobi implements Tickerable {

	VETBTC,
	EOSETH,
	ZECBTC,
	BATBTC,
	BATETH,
	OMGETH,
	NEOBTC,
	LTCBTC,
	ETHBTC,
	XLMETH,
	DASHBTC,
	BCHBTC,
	ETCBTC,
	ZRXBTC,
	TRXETH,
	XMRBTC,
	XRPBTC,
	ETHUSDT,
	TRXBTC,
	OMGBTC,
	XLMBTC,
	GNTBTC,
	LINKETH,;

	@Override
	public String getTicker() {
		return this.name();
	}

	@Override
	public String getSymbol() {
		return this.name().toLowerCase();
	}

}
