package com.mrdave19.Exchange.Bitbay;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Ticker;

public class Bitbay implements Quoatable {

	private Exchange exchange;
	
	
	
	public Bitbay(Exchange exchange) {
		this.exchange = exchange;
	}

	public static void main(String[] args) throws MalformedURLException {
		showQuotes();
	}

	public static void showSymbols() {
		ObjectMapper mapper = new ObjectMapper();
		Quotation exchange = null;
		List<SymbolBitbay> list = new ArrayList<>();
		try {
			for (SymbolBitbay symbol : SymbolBitbay.values()) {
				exchange = mapper.readValue(new URL("https://bitbay.net/API/Public/" + symbol + "/orderbook.json"),
						Quotation.class);
				if(exchange.getAsks()!=null) {
					list.add(symbol);
				}

			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		list.forEach(i->System.out.println(i+","));

	}

	public static void showQuotes() throws MalformedURLException {
		Quotation exchange = Utility.getPOJO("https://bitbay.net/API/Public/" + SymbolBitbay.ETHBTC +"/orderbook.json", Quotation.class);

		for (Double[] bid : exchange.getBids()) {
			System.out.println("Price: " + bid[0] + " Quantity: " + bid[1]);
		}
	}

	@Override
	public void addQuote(Ticker ticker, String tickerName, List<Quote> quotes) {
		Quotation bitbay = Utility.getPOJO("https://bitbay.net/API/Public/" + tickerName +"/orderbook.json", Quotation.class);
		
		String[][]bids= new String[5][2];
		String[][]asks= new String[5][2];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<bitbay.getBids()[i].length;j++) {
				bids[i][j]=bitbay.getBids()[i][j].toString();
				asks[i][j]=bitbay.getAsks()[i][j].toString();
			}
			
		}
		
		quotes.add(new Quote()
				.setAsks(asks)
				.setBids(bids)
				.setExchange(exchange)
				.setTicker(ticker));
		
	}

}
