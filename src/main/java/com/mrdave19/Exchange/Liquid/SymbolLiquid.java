package com.mrdave19.Exchange.Liquid;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolLiquid implements Tickerable {

	//BTCEUR("3"),
	XRPUSD("84"),
	//ETCBTC("110"),
	//XLMETH("141"),
	//VETBTC("139"),
	//ETHEUR("28"),
	//ETHUSDT("625"),
	//BCHBTC("114"),
	ETHUSD("27"),
	ETHBTC("37"),
	//XRPEUR("85"),
	//BCHUSD("39"),
	BTCUSD("1");
	//LTCBTC("112");
	//TRXBTC("117"),
	//XRPBTC("111");
	//XLMBTC("115"),
	//OMGBTC("125"),
	//ZECBTC("107"),
	//TRXETH("120"),
	//NEOBTC("119"),
	//DASHBTC("116");
	//XMRBTC("109");


	
	private String id;

	private SymbolLiquid(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getTicker() {
		return this.name();
	}

	@Override
	public String getSymbol() {
		return this.id;
	}

	
	


	}
	
	

