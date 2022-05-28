package com.mrdave19.Exchange.DAO;

import java.util.List;

import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Market;
import com.mrdave19.Exchange.Entity.Ticker;
import com.mrdave19.Exchange.Entity.Timestamp;

public interface MarketDAO {
	
	public void save(Market market);
	public void save(Ticker ticker);
	public List<Exchange> getExchanges();
	public List<Ticker> getTickers();
	public void tryThis(Timestamp tstmp, int limit,List<Quote> quotes);

}
