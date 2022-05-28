package com.mrdave19.Exchange.Bitstamp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Bitstamp implements Quoatable {
	
	private Exchange exchange;
	
	
	public Bitstamp(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}
	
	public static void showSymbols() throws MalformedURLException {
		ExchangeSymbol[] exchange = Utility.getPOJO("https://www.bitstamp.net/api/v2/trading-pairs-info/", ExchangeSymbol[].class);
		
		for(ExchangeSymbol ex: exchange) {
			System.out.println(ex.getSymbol()+",");
		}

	}
	
	public static void showQuotes() throws MalformedURLException {
		Tick exchange = Utility.getPOJO("https://www.bitstamp.net/api/v2/order_book/ethbtc/", Tick.class);
	
		for(String[] bid : exchange.getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Tick bitstamp = Utility.getPOJO("https://www.bitstamp.net/api/v2/order_book/"+tickerName, Tick.class);
		
		quotes.add(new Quote()
				.setAsks(bitstamp.getAsks())
				.setBids(bitstamp.getBids())
				.setExchange(exchange)
				.setTicker(ticker));
		
	}
	

}
