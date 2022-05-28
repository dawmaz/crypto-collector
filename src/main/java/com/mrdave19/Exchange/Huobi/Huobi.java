package com.mrdave19.Exchange.Huobi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Huobi implements Quoatable{
	
	private Exchange exchange;
	
	
	
	public Huobi(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}
	
	public static void showSymbols() throws MalformedURLException {
		ExchangeHuobi exchange = Utility.getPOJO("https://api.huobi.pro/v1/common/symbols", ExchangeHuobi.class);
		
		Arrays.asList(exchange.getData()).stream()
		.filter(i ->i.getStatus().equals("online"))
		.map(i->i.getSymbol())
		.forEach(i->System.out.println(i.toUpperCase()+","));
	}
	
	public static void showQuotes() throws MalformedURLException {
		Quotation exchange = Utility.getPOJO("https://api.huobi.pro/market/depth?symbol=boxeth&type=step0", Quotation.class);
	
		for(String[] bid : exchange.getTick().getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation huobi = Utility.getPOJO("https://api.huobi.pro/market/depth?symbol="+tickerName+"&type=step0", Quotation.class);

		quotes.add(new Quote()
				.setAsks(huobi.getTick().getAsks())
				.setBids(huobi.getTick().getBids())
				.setExchange(exchange)
				.setTicker(ticker));
		
		
	}
	

}
