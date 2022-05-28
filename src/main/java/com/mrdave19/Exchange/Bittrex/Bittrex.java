package com.mrdave19.Exchange.Bittrex;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Bittrex implements Quoatable {
	
	private Exchange exchange;
	
	
	public Bittrex(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showSymbols();
	}
	
	public static void showSymbols() throws MalformedURLException {
		ExchangeBittrex exchange = Utility.getPOJO("https://api.bittrex.com/api/v1.1/public/getmarkets", ExchangeBittrex.class);
		
		List<String> list = new ArrayList<>();
		for(SymbolBittrex symbol:SymbolBittrex.values()) {
			list.add(symbol.name());
		}
		
		Arrays.asList(exchange.getData()).stream()
		.filter(i ->i.getStatus())
		//.map(i->i.getSymbol())
		//.map(i->i.getQuoteAsset()+i.getBaseAsset())
		.filter(i->list.contains(i.getSymbol().replace("-", "")))
		
		//.forEach(i->System.out.println(i.toUpperCase().replace("-", "")+"(\""+i+"\"),"));
		.forEach(i->System.out.println(i.getQuoteAsset()+i.getBaseAsset()+"(\""+i.getSymbol()+"\"),"));
	}
	
	public static void showQuotes() throws MalformedURLException {
		Quotation exchange = Utility.getPOJO("https://api.bittrex.com/api/v1.1/public/getorderbook?market=BTC-LTC&type=both", Quotation.class);
	
		
		for(Quotee bid : exchange.getResult().getBuy()) {
			System.out.println("Price: " + bid.getPrice() + " Quantity: " + bid.getQuantity());
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation bittrex = Utility.getPOJO("https://api.bittrex.com/api/v1.1/public/getorderbook?market="+tickerName+"&type=both", Quotation.class);
		
		String[][]bids = new String[5][0];
		String[][]asks = new String[5][0];
		
		
		for(int i=0;i<5;i++) {
			bids[i]=new String[] {((Double)bittrex.getResult().getBuy()[i].getPrice()).toString(),
					((Double)bittrex.getResult().getBuy()[i].getQuantity()).toString()};
			asks[i]=new String[] {((Double)bittrex.getResult().getSell()[i].getPrice()).toString(),
					((Double)bittrex.getResult().getBuy()[i].getQuantity()).toString()};
			}
		
		
		quotes.add(new Quote()
				.setAsks(asks)
				.setBids(bids)
				.setExchange(exchange)
				.setTicker(ticker));
		
		}
		

	}
	

