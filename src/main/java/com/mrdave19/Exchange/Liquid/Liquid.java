package com.mrdave19.Exchange.Liquid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Liquid implements Quoatable {
	
	private Exchange exchange;
	
	
	public Liquid(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showSymbols();
	}
	
	public static void showSymbols() throws MalformedURLException {
		ExchangeSymbol[] exchange = Utility.getPOJO("https://api.liquid.com/products", ExchangeSymbol[].class);
		
		for(ExchangeSymbol ex:exchange) {
			//System.out.println(ex.getSymbol()+"(\""+ex.getId()+"\"),");
			System.out.println(ex.getSymbol()+",");
		}
		
	}
	
	public static void showQuotes()  {
		Quotation exchange = Utility.getPOJO("https://api.liquid.com/products/"+SymbolLiquid.ETHBTC.getId()+"/price_levels", Quotation.class);
	
		for(String[] bid : exchange.getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation liquid = Utility.getPOJO("https://api.liquid.com/products/"+tickerName+"/price_levels", Quotation.class);
		
		quotes.add(new Quote()
				.setAsks(liquid.getAsks())
				.setBids(liquid.getBids())
				.setExchange(exchange)
				.setTicker(ticker));
	}
	

}
