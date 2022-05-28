package com.mrdave19.Exchange.Gemini;

import java.net.MalformedURLException;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Gemini implements Quoatable {
	
	private Exchange exchange;
	
	
	public Gemini(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}
	
	public static void showSymbols() throws MalformedURLException {
		String[] exchange = Utility.getPOJO("https://api.gemini.com/v1/symbols", String[].class);
	
		for(String str: exchange) {
			System.out.println(str+",");
		}

	}
	
	public static void showQuotes() throws MalformedURLException {
		Quotation exchange = Utility.getPOJO("https://api.gemini.com/v1/book/"+SymbolGemini.zecusd, Quotation.class);
	
		for(Quotee bid : exchange.getBids()) {
			System.out.println("Price: " + bid.getPrice() + " Quantity: " + bid.getAmount());
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation gemini = Utility.getPOJO("https://api.gemini.com/v1/book/"+tickerName, Quotation.class);
		
		String[][]bids = new String[5][0];
		String[][]asks = new String[5][0];
		
		
		for(int i=0;i<5;i++) {
			bids[i]=new String[] {gemini.getBids()[i].getPrice(),
					(gemini.getBids()[i].getAmount())};
			asks[i]=new String[] {gemini.getAsks()[i].getPrice(),
					(gemini.getAsks()[i].getAmount())};
			}
		
		
		quotes.add(new Quote()
				.setAsks(asks)
				.setBids(bids)
				.setExchange(exchange)
				.setTicker(ticker));
		
		}
	}
	


