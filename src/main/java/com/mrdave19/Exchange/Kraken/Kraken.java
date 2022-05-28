package com.mrdave19.Exchange.Kraken;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Kraken implements Quoatable{

	private Exchange exchange;
	
	
	public Kraken(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}

	public static void showSymbols()  {
		ExchangeKraken exchange = Utility.getPOJO("https://api.kraken.com/0/public/AssetPairs", ExchangeKraken.class);
		
		exchange.getResult().forEach((k, v) -> System.out.println(v.getSymbol() + ","));

	}

	public static void showQuotes()  {
		Quotation exchange = Utility.getPOJO("https://api.kraken.com/0/public/Depth?pair=BATEUR", Quotation.class);

		for(Object[] obj :exchange.getResult().get("BATEUR").getAsks()){
			System.out.println("Price: " + obj[0] + " Quantity: " + obj[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation kraken = Utility.getPOJO("https://api.kraken.com/0/public/Depth?pair="+tickerName, Quotation.class);
		
		String[][] bids = new String[5][2];
		String[][] asks = new String[5][2];
		
		Offer offer = kraken.getResult().entrySet().iterator().next().getValue();
		
		for(int i=0;i<5;i++) {
			bids[i][0]=(String)offer.getBids()[i][0];
			bids[i][1]=(String)offer.getBids()[i][1];
			asks[i][0]=(String)offer.getAsks()[i][0];
			asks[i][1]=(String)offer.getAsks()[i][1];
		}
		
		
		quotes.add(new Quote()
				.setAsks(asks)
				.setBids(bids)
				.setExchange(exchange)
				.setTicker(ticker));
		
	}

}
