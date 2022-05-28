package com.mrdave19.Exchange;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrdave19.Exchange.Binance.SymbolBinance;
import com.mrdave19.Exchange.BitFinex.SymbolBitfinex;
import com.mrdave19.Exchange.Bitbank.SymbolBitbank;
import com.mrdave19.Exchange.Bitstamp.SymbolBitstamp;
import com.mrdave19.Exchange.Bittrex.SymbolBittrex;
import com.mrdave19.Exchange.Gemini.SymbolGemini;
import com.mrdave19.Exchange.Huobi.SymbolHuobi;
import com.mrdave19.Exchange.Kraken.SymbolKraken;
import com.mrdave19.Exchange.Liquid.SymbolLiquid;

public class Utility {

	public static <T> T getPOJO(String url, Class<T> classType) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			return mapper.readValue(new URL(url), classType);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static <E extends Enum<E>> void enumValues(Class<E> enumData, Set<String> set) {

		for (Enum<E> enumVal : enumData.getEnumConstants()) {
			set.add(((Tickerable) enumVal).getTicker());
		}
	}
	
	
	public static Set<String> getAllAvailableTickers() {
		Set<String> tickers = new HashSet<String>();

		// enumValues(SymbolBitbay.class,tickers);
		enumValues(SymbolBinance.class, tickers);
		enumValues(SymbolBitbank.class, tickers);
		enumValues(SymbolBitfinex.class, tickers);
		enumValues(SymbolBitstamp.class, tickers);
		enumValues(SymbolBittrex.class, tickers);
		enumValues(SymbolGemini.class, tickers);
		enumValues(SymbolHuobi.class, tickers);
		enumValues(SymbolKraken.class, tickers);
		enumValues(SymbolLiquid.class, tickers);

		return tickers;
	}
	
	public static <E extends Enum<E>&Tickerable> List<E> getTickers(Class<E> enumData) {
		List<E> list = new ArrayList<>();
		for (Enum<E> enumVal : enumData.getEnumConstants()) {
			list.add((E)enumVal);
		}
		return list;
	}
	
}
