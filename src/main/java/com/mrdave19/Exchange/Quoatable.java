package com.mrdave19.Exchange;

import java.util.List;

import com.mrdave19.Exchange.Entity.Ticker;

public interface Quoatable {

	public void addQuote(Ticker ticker,String tickerName,List<Quote> quotes);

}
