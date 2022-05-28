package com.mrdave19.Exchange.Bittrex;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBittrex implements Tickerable {

	LTCBTC("BTC-LTC"), DASHBTC("BTC-DASH"), XMRBTC("BTC-XMR"), XRPBTC("BTC-XRP"), ETHBTC("BTC-ETH"), XLMBTC("BTC-XLM"),
	ETCBTC("BTC-ETC"), NEOBTC("BTC-NEO"), ZECBTC("BTC-ZEC"), GNTBTC("BTC-GNT"), ETHUSDT("USDT-ETH"), BATETH("ETH-BAT"),
	BATBTC("BTC-BAT"), OMGBTC("BTC-OMG"), OMGETH("ETH-OMG"), XLMETH("ETH-XLM"), BCHBTC("BTC-BCH"), ZRXBTC("BTC-ZRX"),
	TRXBTC("BTC-TRX"), TRXETH("ETH-TRX"), BTCUSD("USD-BTC"), ETHUSD("USD-ETH"), XRPUSD("USD-XRP"), ZECUSD("USD-ZEC"),
	LTCUSD("USD-LTC"), BCHUSD("USD-BCH"), BATUSD("USD-BAT"), EOSETH("ETH-EOS"), VETBTC("BTC-VET"), LINKETH("ETH-LINK"),
	BTCEUR("EUR-BTC"), ETHEUR("EUR-ETH");

	private String symbol;

	private SymbolBittrex(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public String getTicker() {
		return this.name();
	}

}
