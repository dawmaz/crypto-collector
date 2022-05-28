package com.mrdave19.Exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.mrdave19.Exchange.DAO.MarketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrdave19.Exchange.Exchanges;
import com.mrdave19.Exchange.Quoatable;
import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Tickerable;
import com.mrdave19.Exchange.Utility;
import com.mrdave19.Exchange.Binance.Binance;
import com.mrdave19.Exchange.Binance.SymbolBinance;
import com.mrdave19.Exchange.BitFinex.Bitfinex;
import com.mrdave19.Exchange.BitFinex.SymbolBitfinex;
import com.mrdave19.Exchange.Bitbank.Bitbank;
import com.mrdave19.Exchange.Bitbank.SymbolBitbank;
import com.mrdave19.Exchange.Bitbay.Bitbay;
import com.mrdave19.Exchange.Bitbay.SymbolBitbay;
import com.mrdave19.Exchange.Bitstamp.Bitstamp;
import com.mrdave19.Exchange.Bitstamp.SymbolBitstamp;
import com.mrdave19.Exchange.Bittrex.Bittrex;
import com.mrdave19.Exchange.Bittrex.SymbolBittrex;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Market;
import com.mrdave19.Exchange.Entity.Ticker;
import com.mrdave19.Exchange.Entity.Timestamp;
import com.mrdave19.Exchange.Gemini.Gemini;
import com.mrdave19.Exchange.Gemini.SymbolGemini;
import com.mrdave19.Exchange.Huobi.Huobi;
import com.mrdave19.Exchange.Huobi.SymbolHuobi;
import com.mrdave19.Exchange.Kraken.Kraken;
import com.mrdave19.Exchange.Kraken.SymbolKraken;
import com.mrdave19.Exchange.Liquid.Liquid;
import com.mrdave19.Exchange.Liquid.SymbolLiquid;

@Service
public class QuickTest {
	private static final int QUOTELIMIT = 5;
	private static final int TIMEOUT = 20;

	private MarketDAO market;

	private List<Exchange> exchanges;
	private List<Ticker> tickers;

	Map<String, Ticker> tickerMap = new HashMap<>();
	Map<String, Exchange> exchangeMap = new HashMap<>();
	List<Quote> quotes = Collections.synchronizedList(new ArrayList<Quote>());

	private List<SymbolBinance> binanceTickers = Utility.getTickers(SymbolBinance.class);
	private List<SymbolBitbank> bitbankTickers = Utility.getTickers(SymbolBitbank.class);
	private List<SymbolBitbay> bitbayTickers = Utility.getTickers(SymbolBitbay.class);
	private List<SymbolBitfinex> bitfinexTickers = Utility.getTickers(SymbolBitfinex.class);
	private List<SymbolBitstamp> bitstampTickers = Utility.getTickers(SymbolBitstamp.class);
	private List<SymbolBittrex> bittrexTickers = Utility.getTickers(SymbolBittrex.class);
	private List<SymbolGemini> geminiTickers = Utility.getTickers(SymbolGemini.class);
	private List<SymbolHuobi> huobiTickers = Utility.getTickers(SymbolHuobi.class);
	private List<SymbolKraken> krakenTickers = Utility.getTickers(SymbolKraken.class);
	private List<SymbolLiquid> liquidTickers = Utility.getTickers(SymbolLiquid.class);

	@Autowired
	public QuickTest(MarketDAO market) {
		this.market = market;
		exchanges = market.getExchanges();
		tickers = market.getTickers();
	}

	public void createOne() {

		Set<String> tickers = Utility.getAllAvailableTickers();

		for (String ticker : tickers) {
			Ticker theTicker = new Ticker();
			theTicker.setName(ticker);
			market.save(theTicker);
		}

	}

	@PostConstruct
	public void test2() throws InterruptedException {
		prep();
		int count=0;
		long timm = System.currentTimeMillis();
		while(true) {
		System.out.println("Starting " + count++ );
		Timestamp tstmp = new Timestamp();
		tstmp.setDate(System.currentTimeMillis());
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(() -> addQuotes(binanceTickers, new Binance(exchangeMap.get(Exchanges.BINANCE.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(bitbankTickers, new Bitbank(exchangeMap.get(Exchanges.BITBANK.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(bitbayTickers, new Bitbay(exchangeMap.get(Exchanges.BITBAY.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(bitfinexTickers, new Bitfinex(exchangeMap.get(Exchanges.BITFINEX.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(bitstampTickers, new Bitstamp(exchangeMap.get(Exchanges.BITSTAMP.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(bittrexTickers, new Bittrex(exchangeMap.get(Exchanges.BITTREX.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(geminiTickers, new Gemini(exchangeMap.get(Exchanges.GEMINI.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(huobiTickers, new Huobi(exchangeMap.get(Exchanges.HUOBI.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(krakenTickers, new Kraken(exchangeMap.get(Exchanges.KRAKEN.name())), tickerMap, exchangeMap,quotes));
		executor.submit(() -> addQuotes(liquidTickers, new Liquid(exchangeMap.get(Exchanges.LIQUID.name())), tickerMap, exchangeMap,quotes));
		executor.shutdown();
		executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
		long start = System.currentTimeMillis();
		saveMarkets(new Timestamp().setDate(System.currentTimeMillis()),QUOTELIMIT);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println("Total time: " + (System.currentTimeMillis()-timm)/1000+" secs");
		quotes.clear();
		if((System.currentTimeMillis()-timm)/1000>18000) break;
		}
	}

	public void saveMarkets(Timestamp tstmp, int limit) {
		market.tryThis(tstmp, limit, quotes);
	}

	public void addQuotes(List<? extends Tickerable> list, Quoatable quoat, Map<String, Ticker> tickerMap,
			Map<String, Exchange> exchangeMap, List<Quote> quotes) {

		ExecutorService executor = Executors.newFixedThreadPool(list.size());

		for (Tickerable str : list) {
			executor.submit(() -> quoat.addQuote(tickerMap.get(str.getTicker()), str.getSymbol(), quotes));
		}

		executor.shutdown();

		try {
			executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void prep() {

		for (Ticker ticker : tickers) {
			tickerMap.put(ticker.getName(), ticker);
		}

		for (Exchange exchange : exchanges) {
			exchangeMap.put(exchange.getName(), exchange);
		}
	}
}
