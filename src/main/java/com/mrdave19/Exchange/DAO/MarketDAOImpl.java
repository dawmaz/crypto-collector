package com.mrdave19.Exchange.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrdave19.Exchange.Quote;
import com.mrdave19.Exchange.Entity.Exchange;
import com.mrdave19.Exchange.Entity.Market;
import com.mrdave19.Exchange.Entity.Ticker;
import com.mrdave19.Exchange.Entity.Timestamp;

@Repository
public class MarketDAOImpl implements MarketDAO {

	@Autowired
	private  EntityManager entityManagerFactory;
	
	@Override
	@Transactional
	public void save(Market market) {
		Session currentSession = entityManagerFactory.unwrap(Session.class);
		currentSession.saveOrUpdate(market);
		
	}

	@Override
	@Transactional
	public void save(Ticker ticker) {
		Session currentSession = entityManagerFactory.unwrap(Session.class);
		currentSession.saveOrUpdate(ticker);
		
	}

	@Override
	@Transactional
	public List<Exchange> getExchanges() {
		Session currentSession = entityManagerFactory.unwrap(Session.class);
		return currentSession.createQuery("Select a from Exchange a", Exchange.class).getResultList();
	}

	@Override
	@Transactional
	public List<Ticker> getTickers() {
		Session currentSession = entityManagerFactory.unwrap(Session.class);
		return currentSession.createQuery("Select a from Ticker a", Ticker.class).getResultList();
	}
	
	@Override
	@Transactional
	public void tryThis(Timestamp tstmp, int limit,List<Quote> quotes) {
		Session currentSession = entityManagerFactory.unwrap(Session.class);
		int count=0;
		System.out.println("Elements: " +quotes.size());
		Quote theQuote = new Quote();
		
		
		
		try {
		for(Quote quote:quotes) {
			theQuote=quote;
			Exchange exchange = currentSession.get(Exchange.class, quote.getExchange().getId());
			Ticker ticker = currentSession.get(Ticker.class,quote.getTicker().getId());
				for(byte i=0;i<limit;i++) {
					Market mark = new Market();
					mark.setBest(i);
					mark.setAmount(Double.parseDouble(quote.getAsks()[i][1]));
					mark.setPrice(Double.parseDouble(quote.getAsks()[i][0]));
					mark.setTicker(ticker);
					mark.setTimestamp(tstmp);
					mark.setType("ASK");
					mark.setExchange(exchange);
					currentSession.saveOrUpdate(mark);
					
				}
				for(byte i=0;i<limit;i++) {
					Market mark = new Market();
					mark.setBest(i);
					mark.setAmount(Double.parseDouble(quote.getBids()[i][1]));
					mark.setPrice(Double.parseDouble(quote.getBids()[i][0]));
					mark.setExchange(exchange);
					mark.setTicker(ticker);
					mark.setTimestamp(tstmp);
					mark.setType("BID");
					currentSession.saveOrUpdate(mark);
					}
		
				}
	}catch(Exception ex) {
		System.out.println(theQuote.getExchange().getName());
		System.out.println(theQuote.getTicker().getName());
		ex.printStackTrace();
	}
		
	}
	

}
