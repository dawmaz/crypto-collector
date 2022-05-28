package com.mrdave19.Exchange.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "timestamp")
public class Timestamp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private long date;
	
	@OneToMany(mappedBy="timestamp",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Market> markets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public Timestamp setDate(long date) {
		this.date = date;
		return this;
	}

	public List<Market> getMarkets() {
		return markets;
	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}


	
	

}
