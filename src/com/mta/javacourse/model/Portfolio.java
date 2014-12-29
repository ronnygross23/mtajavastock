package com.mta.javacourse.model;


import  java.util.*;
import com.mta.javacourse.model.StockStatus;
/**
 * The class contains data on stock software, adding listed in the array.
 * @author Ronny
 *@since 4.12.14
 */
public class Portfolio {

public static enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
private final static int MAX_PORTFILO_SIZE=5;
private String title;
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
	//stocks= new Stock[MAX_PORTFILO_SIZE];
	stockStatus=new StockStatus[MAX_PORTFILO_SIZE];
	balance=0;
}

public Portfolio(Portfolio Portfolio2)
{
	this.stockStatus=new StockStatus[Portfolio2.getStocks().length];
	for(int i=0;i<stockStatus.length;i++)
	{
		this.stockStatus[i]=Portfolio2.getStocks()[i];
	}
}

/**
 * A method that adds stock in stock array
 * @param stock
 */
public void addStock(Stock stock){
	if(portfolioSize<MAX_PORTFILO_SIZE)
	{
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
public StockStatus[] getStocks(){
	
	return stockStatus;
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
			getHtmlString += stockStatus[i].getHtmlDescription()+"<b> Quantity:</b> " + this.stockStatus[i].getStockQuantity()+ "<br>";
		}
		
	return getHtmlString;
	}
/**
 * method that remove the stock
 * @param symbol
 * @return true- if she managed to remove stock, false- if she didn't.
 */
public boolean removeStock(String symbol)
{
	for (int i=0;i<portfolioSize;i++)
	{
		if(this.stockStatus[i].getSymbol()==symbol)
		{
			this.sellStock(symbol, -1);
			this.stockStatus[i]=this.stockStatus[portfolioSize-1];
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
		if(this.stockStatus[i].getSymbol()==symbol&&quantity==-1)
		{
			this.updateBalance(this.stockStatus[i].getStockQuantity()*this.stockStatus[i].getBid());
			this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.SELL);
			this.stockStatus[i].setStockQuantity(0);
			return true;
		}
		else if(this.stockStatus[i].getSymbol()==symbol&&this.stockStatus[i].getStockQuantity()>quantity)
		{
			
			this.updateBalance(this.stockStatus[i].getStockQuantity()*this.stockStatus[i].getBid());
			this.stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()-quantity);
			return true;
				
		}
		else if (this.stockStatus[i].getSymbol()==symbol&&this.stockStatus[i].getStockQuantity()<quantity)
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
 * @return true- if she managed to buy the stock, false- if she didn't.
 */
public boolean buyStock (String symbol, int quantity)
{
	
	for (int i=0;i<portfolioSize;i++)
	{
		if(this.stockStatus[i].getSymbol()==symbol)
		{
			if (quantity==-1)
			{
				this.stockStatus[i].setStockQuantity((int)(this.balance/this.stockStatus[i].ask));
				this.updateBalance(0);
				return true;
			}
			else if(this.balance>=this.stockStatus[i].getAsk()*quantity)
			{
				this.stockStatus[i].setStockQuantity(quantity);
				this.stockStatus[i].setRecommendion(ALGO_RECOMMENDATION.BUY);
				this.updateBalance(-1*(this.stockStatus[i].ask*quantity));
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
		sum=this.stockStatus[i].getBid()*this.stockStatus[i].getStockQuantity()+sum;
	}
	return sum;
}
public float getTotalValue()
{
	return this.getBalance()+this.getStocksValue();
}

}
