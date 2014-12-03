package com.mta.javacourse.model;
import  com.mta.javacourse.Stock;
import com.mta.javacourse.Stockdetails;
import  java.util.*;
public class Portfolio {
	
private final static int MAX_PORTFILO_SIZE=5;
private String title;
private Stock[] stocks;
private StockStatus[] stockStatus;
private int portfolioSize;
public int i=0;
public Portfolio()
{
	stocks= new Stock[MAX_PORTFILO_SIZE];
	stockStatus=new StockStatus[MAX_PORTFILO_SIZE];
}

public void addStock(Stock stock){
	stocks[portfolioSize]=stock;
	portfolioSize++;
}

public Stock[] getStocks(){
	
	return stocks;
}

public String getHtmlString(){
		String getHtmlString ="<h1>Portfolio</h1>" ;
		for (i=0;i<portfolioSize;i++)
		{
	 getHtmlString += stocks[i].getHtmlDescription() + "<br>";
		}
		
	return getHtmlString;
	}
	public class StockStatus {
	
		public final static int DO_NOTHING=0;
		public final static int BUY=1;
		public final static int SELL=2;
		public String Symbol;
		public float currnetBid;
		public float currnetAsk;
		public Date date;
		public int recommendion;
		public int stockQuantity;
		
	}
	

}
 