package com.mrdave19.Exchange.Binance;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Binance implements Quoatable {
	
	private Exchange exchange;

	
	public Binance(Exchange exchange) {
		this.exchange=exchange;
	}
	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}

	public static void showSymbols() {
		ExchangeBinance binance = Utility.getPOJO("https://api.binance.com/api/v3/exchangeInfo", ExchangeBinance.class);

		Arrays.asList(binance.getSymbols()).stream()
		.filter(i -> i.getStatus().equals("TRADING"))
		.map(i -> i.getSymbol())
		.forEach(i -> System.out.println(i + ","));
	}

	public static void showQuotes() {
		Quotation binance = Utility.getPOJO("https://api.binance.com/api/v3/depth?symbol=ETHBTC", Quotation.class);

		for (String[] bid : binance.getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker,String tickerName,List<Quote> quotes) {
		
		
		Quotation binance = Utility.getPOJO("https://api.binance.com/api/v3/depth?symbol=" + tickerName+"&limit=5", Quotation.class);
		
		quotes.add(new Quote()
				.setBids(binance.getBids())
				.setAsks(binance.getAsks())
				.setTicker(ticker)
				.setExchange(exchange));
		
		
	}

}
