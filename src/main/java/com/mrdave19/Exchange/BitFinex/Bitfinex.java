package com.mrdave19.Exchange.BitFinex;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Bitfinex implements Quoatable {
	
	private Exchange exchange;
	
	
	
	public Bitfinex(Exchange exchange) {
		this.exchange = exchange;
	}
	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}
	public static void showSymbols() throws MalformedURLException {
		Object[][] exchange = Utility.getPOJO("https://api-pub.bitfinex.com/v2/tickers?symbols=ALL", Object[][].class);
		
		for(Object[] obj : exchange) {
			System.out.println(obj[0]+",");
		}
	}
	
	public static void showQuotes() throws MalformedURLException {
		Double[][] exchange = Utility.getPOJO("https://api-pub.bitfinex.com/v2/book/tBTCUSD/P0", Double[][].class);
	
		System.out.println(exchange.length);
		
		List<Double[]> bids = new ArrayList<>();
		List<Double[]> asks= new ArrayList<>();
		
		
		for(Double[] obj : exchange) {
			if(obj[2]>0){
				bids.add(new Double[] {obj[0],obj[2]});
			} else {
				asks.add(new Double[] {obj[0],obj[2]});
			}
		}
		
		for(Double[] obj:asks) {
			System.out.println("Price: " + obj[0]+ " Quantity: " + obj[1]);
		}
		
		
		
	}
	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		
		Double[][] bitfinex = Utility.getPOJO("https://api-pub.bitfinex.com/v2/book/"+tickerName+"/P0", Double[][].class);
		final int len = bitfinex.length/2;
		int count =0;
		
		String[][]bids= new String[5][];
		String[][]asks= new String[5][];
		for(int i=0;i<5;i++) {
			bids[i]= new String[] {bitfinex[i][0].toString(),bitfinex[i][2].toString()};
		}
		for(int i=len;i<len+5;i++) {
			asks[count++]= new String[] {bitfinex[i][0].toString(),((Double)(-1*bitfinex[i][2])).toString()};
		}
		

		
		quotes.add(new Quote()
				.setAsks(asks)
				.setBids(bids)
				.setExchange(exchange)
				.setTicker(ticker));
	}
	

}
