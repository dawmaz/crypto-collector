package com.mrdave19.Exchange.Binance;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBinance implements Tickerable{

	ETHBTC,
	LTCBTC,
	NEOBTC,
	EOSETH,
	ETHUSDT,
	OMGBTC,
	OMGETH,
	ZRXBTC,
	LINKETH,
	ETCBTC,
	ZECBTC,
	DASHBTC,
	TRXBTC,
	TRXETH,
	XRPBTC,
	XMRBTC,
	BATBTC,
	BATETH,
	XLMBTC,
	XLMETH,
	GNTBTC,
	VETBTC,
	BCHBTC,
	BTCEUR,
	ETHEUR,
	XRPEUR,;

	@Override
	public String getTicker() {
		return this.name();
	}

	@Override
	public String getSymbol() {
		return this.name();
	}





}
