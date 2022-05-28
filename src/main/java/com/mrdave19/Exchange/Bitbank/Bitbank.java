package com.mrdave19.Exchange.Bitbank;

import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Bitbank implements Quoatable {
	
	private Exchange exchange;
	

	
	public Bitbank(Exchange exchange) {
		this.exchange = exchange;
	}


	public static void main(String[] args)  {
		showQuotes();
	}
	
	
	public static void showQuotes() {
		Quotation bitbank = Utility.getPOJO("https://public.bitbank.cc/eth_btc/depth", Quotation.class);
	
		
		for(String[] bid : bitbank.getData().getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}


	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation bitbank = Utility.getPOJO("https://public.bitbank.cc/" + tickerName+"/depth", Quotation.class);
		
		quotes.add(new Quote()
				.setBids(bitbank.getData().getBids())
				.setAsks(bitbank.getData().getAsks())
				.setTicker(ticker)
				.setExchange(exchange));
		
	}
	

}
