package com.mrdave19.Exchange.BitFinex;

import com.mrdave19.Exchange.Tickerable;

public enum SymbolBitfinex implements Tickerable {

	tBTCUSD,
	//tLTCUSD,
	tLTCBTC,
	//tETHUSD,
	tETHBTC,
	//tETCBTC,
	//tZECUSD,
	//tZECBTC,
	//tXMRBTC,
	tBTCEUR,
	tXRPUSD,
	tXRPBTC,
	//tEOSETH,
	//tOMGBTC,
	//tOMGETH,
	tNEOBTC,
	/*
	 * tGNTBTC, tBATUSD, tBATBTC, tBATETH, tZRXBTC, tTRXBTC, tTRXETH, tETHEUR,
	 * tXLMBTC, tXLMETH,
	 */
	tVETBTC;

	@Override
	public String getTicker() {
		return this.name().replaceAll("t", "");
	}

	@Override
	public String getSymbol() {
		return this.name();
	}

}
