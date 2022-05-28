package com.mrdave19.Exchange.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exchange")
public class Exchange {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="exchange",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Market> markets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Market> getMarkets() {
		return markets;
	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}
	
	
	public void add(Market tempMarket) {
		
		if (markets == null) {
			markets = new ArrayList<>();
		}
		
		markets.add(tempMarket);
		
		tempMarket.setExchange(this);
	}

}
