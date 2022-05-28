package com.mrdave19.Exchange;

import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Quote {
	
	private String[][] bids;
	private String[][] asks;
	private Exchange exchange;
	private Ticker ticker;
	
	
	public String[][] getBids() {
		return bids;
	}
	public Quote setBids(String[][] bids) {
		this.bids = bids;
		return this;
	}
	public String[][] getAsks() {
		return asks;
	}
	public Quote setAsks(String[][] asks) {
		this.asks = asks;
		return this;
	}
	public Exchange getExchange() {
		return exchange;
	}
	public Quote setExchange(Exchange exchange) {
		this.exchange = exchange;
		return this;
	}
	public Ticker getTicker() {
		return ticker;
	}
	public Quote setTicker(Ticker ticker) {
		this.ticker = ticker;
		return this;
	}
	
	

}
