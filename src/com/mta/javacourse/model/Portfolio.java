package com.mta.javacourse.model;


import  java.util.*;
/**
 * The class contains data on stock software, adding listed in the array.
 * @author Ronny
 *@since 4.12.14
 */
public class Portfolio {

private static enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
private final static int MAX_PORTFILO_SIZE=5;
private String title;
private Stock[] stocks;
private StockStatus[] stockStatus;
private int portfolioSize;
public int i=0;
private float balance;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public float getBalance() {
	return balance;
}

public void setBalance(float balance) {
	this.balance = balance;
}

public void updateBalance(float amount)
{
	this.balance=balance+amount ;
}

public Portfolio()
{
	stocks= new Stock[MAX_PORTFILO_SIZE];
	stockStatus=new StockStatus[MAX_PORTFILO_SIZE];
	balance=0;
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
	if(portfolioSize<MAX_PORTFILO_SIZE)
	{
		stocks[portfolioSize]=stock;
		stockStatus[portfolioSize]=new StockStatus(stock.getSymbol(),stock.getBid(),stock.getAsk(),new Date(stock.getDate().getTime()),ALGO_RECOMMENDATION.DO_NOTHING,0);
		portfolioSize++;
	}
	else
	{
		System.out.println("can't add new stock, portfolio can have only" +MAX_PORTFILO_SIZE +"stocks");
	}
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
public String getHtmlString(){
	
	String getHtmlString="<br><h1>"+this.getTitle()+"</h1></br>";
	getHtmlString+="<br>"+"Total Portfolio Value:"+" "+this.getTotalValue()+"$"+"</br>"+"<br>"+"Total Stocks value:"+" "+this.getStocksValue()+"$"+"</br>"+"<br>"+"Balance:"+" "+this.getBalance()+"$"+"</br>";
	getHtmlString+="<h3>"+"Stocks:"+"</h3>";
		for (i=0;i<portfolioSize;i++)
		{
			getHtmlString += stocks[i].getHtmlDescription()+"<b> Quantity:</b> " + this.stockStatus[i].stockQuantity+ "<br>";
		}
		
	return getHtmlString;
	}
/**
 * method that remove the stock
 * @param symbol
 * @return true- if she managed to remove stock, false- if she didnt.
 */
public boolean removeStock(String symbol)
{
	for (int i=0;i<portfolioSize;i++)
	{
		if(this.stocks[i].getSymbol()==symbol)
		{
			this.sellStock(symbol, -1);
			this.stocks[i]=this.stocks[portfolioSize-1];
			this.stockStatus[i]=this.stockStatus[portfolioSize-1];
			this.stocks[portfolioSize-1]=null;
			this.stockStatus[portfolioSize-1]=null;
			portfolioSize--;
			return true;
		}
	}
	System.out.println("There is no stock");
	return false;
}
/**
 * method that sell the stock
 * @param symbol
 * @param quantity
 * @return true- if she managed to sell the stock, false- if she didnt.
 */
public boolean sellStock (String symbol, int quantity)
{
	for(int i=0;i<portfolioSize;i++)
	{
		if(this.stocks[i].getSymbol()==symbol&&quantity==-1)
		{
			this.updateBalance(this.stockStatus[i].stockQuantity*this.stockStatus[i].getCurrnetBid());
			this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.SELL);
			this.stockStatus[i].setStockQuantity(0);
			return true;
		}
		else if(this.stocks[i].getSymbol()==symbol&&this.stockStatus[i].stockQuantity>quantity)
		{
			
			this.updateBalance(this.stockStatus[i].stockQuantity*this.stockStatus[i].getCurrnetBid());
			//this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.SELL);
			this.stockStatus[i].stockQuantity=this.stockStatus[i].stockQuantity-quantity;
			return true;
				
		}
		else if (this.stocks[i].getSymbol()==symbol&&this.stockStatus[i].stockQuantity<quantity)
		{
			System.out.println("Not enough stock to sell");
			return false;
			
		}
		
	}
	System.out.println("There is no stock");
	return false;
}
/**
 * method that buy the stock
 * @param symbol
 * @param quantity
 * @return true- if she managed to buy the stock, false- if she didnt.
 */
public boolean buyStock (String symbol, int quantity)
{
	
	for (int i=0;i<portfolioSize;i++)
	{
		if(this.stocks[i].getSymbol()==symbol)
		{
			if (quantity==-1)
			{
				this.stockStatus[i].stockQuantity=(int)(this.balance/this.stockStatus[i].currnetAsk);
				//this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.BUY);
				this.updateBalance(0);
				return true;
			}
			else if(this.balance>=this.stockStatus[i].getCurrnetAsk()*quantity)
			{
				this.stockStatus[i].stockQuantity=quantity;
				this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.BUY);
				this.updateBalance(-1*(this.stockStatus[i].currnetAsk*quantity));
				return true;
			}
			else
			{
				System.out.println("Not enough money to buy");
				return false;
			}
				
		}
	
	}
	System.out.println("There is no stock");
	return false;
	
}

public float getStocksValue()
{
	float sum=0;
	
	for (int i=0;i<portfolioSize;i++)
	{
		sum=this.stockStatus[i].getCurrnetBid()*this.stockStatus[i].stockQuantity+sum;
	}
	return sum;
}
public float getTotalValue()
{
	return this.getBalance()+this.getStocksValue();
}

/**
 * The class contains data on regarding the advisability of investing.
 * @author Ronny
 * @since 4.12.2014
 */

	public class StockStatus {
	
	
		public String Symbol;
		public float currnetBid;
		public float currnetAsk;
		public Date date;
		public ALGO_RECOMMENDATION recommendion;
		public int stockQuantity;
		
		public StockStatus()
		{
			Symbol="unknown";
			currnetBid=0;
			currnetAsk=0;
			date=null;
			stockQuantity=0;
		}
		
		public StockStatus(String symbol1,float currnetBid1,float currnetAsk1,Date date1,ALGO_RECOMMENDATION recommendion1,int stockQuantity1)
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
		
		public ALGO_RECOMMENDATION getRecommendion() {
			return recommendion;
		}

		public void setRecommendion(ALGO_RECOMMENDATION recommendion) {
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
 