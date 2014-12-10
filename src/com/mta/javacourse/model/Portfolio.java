package com.mta.javacourse.model;


import  java.util.*;
/**
 * The class contains data on stock software, adding listed in the array.
 * @author Ronny
 *@since 4.12.14
 */
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

public Portfolio(Portfolio Portfolio2)
{
	this.stocks=new Stock[Portfolio2.getStocks().length];
	for(int i=0;i<stocks.length;i++)
	{
		this.stocks[i]=Portfolio2.getStocks()[i];
	}
	
	
}

/**
 * A method that adds stock in stock array
 * @param stock
 */
public void addStock(Stock stock){
	stocks[portfolioSize]=stock;
	portfolioSize++;
}
/**
 * A method that return the stock array
 * @stocks array
 */
public Stock[] getStocks(){
	
	return stocks;
}
/**
 * a method that return the string
 * @return string with all the stock in the array.
 */
public String getHtmlString(String getHtmlString){
	
		for (i=0;i<portfolioSize;i++)
		{
	 getHtmlString += stocks[i].getHtmlDescription() + "<br>";
		}
		
	return getHtmlString;
	}
/**
 * 
 * a method that "remove" stock3
 * @return string without stock3
 */
public String removeStock(String getHtmlString){
	
	for (i=1;i<portfolioSize;i++)
	{
 getHtmlString += stocks[i].getHtmlDescription() + "<br>";
	}
	
return getHtmlString;
}
/**
 * The class contains data on regarding the advisability of investing.
 * @author Ronny
 * @since 4.12.2014
 */
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
		
		public StockStatus()
		{
			Symbol="unknown";
			currnetBid=0;
			currnetAsk=0;
			date=null;
			recommendion=0;
			stockQuantity=0;
		}
		
		public StockStatus(String symbol1,float currnetBid1,float currnetAsk1,Date date1,int recommendion1,int stockQuantity1)
		{
			Symbol=symbol1;
			currnetBid=currnetBid1;
			currnetAsk=currnetAsk1;
			date=date1;
			recommendion=recommendion1;
			stockQuantity=stockQuantity1;
			
		}
		public StockStatus(StockStatus StockStatus1)
		{
			this.Symbol=StockStatus1.getSymbol();
			this.currnetBid=StockStatus1.getCurrnetBid();
			this.currnetAsk=StockStatus1.getCurrnetAsk();
			this.date=StockStatus1.getDate();
			this.recommendion=StockStatus1.getRecommendion();
			this.stockQuantity=StockStatus1.getStockQuantity();
		}
		
		public String getSymbol() {
			return Symbol;
		}
		
		public void setSymbol(String symbol) {
			Symbol = symbol;
		}
		
		public float getCurrnetBid() {
			return currnetBid;
		}
		
		public void setCurrnetBid(float currnetBid) {
			this.currnetBid = currnetBid;
		}
		
		public float getCurrnetAsk() {
			return currnetAsk;
		}
		public void setCurrnetAsk(float currnetAsk) {
			this.currnetAsk = currnetAsk;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public int getRecommendion() {
			return recommendion;
		}
		
		public void setRecommendion(int recommendion) {
			this.recommendion = recommendion;
		}
		
		public int getStockQuantity() {
			return stockQuantity;
		}
		
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	
		
	}
	

}
 