package com.mta.javacourse.service;

import java.util.Date;

import com.mta.javacourse.exceptions.*;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
import com.mta.javacourse.model.StockStatus;
public class PortfolioService {
	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio() throws StockNotExistException,StockAlreadyExistsException,NotEnoughStock,BalanceException,PortfolioFullException{
		Portfolio myPortfolio=new Portfolio();
		Date date = new java.util.Date();
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		StockStatus Stock1 = new StockStatus("unknown", 0, 0, date, ALGO_RECOMMENDATION.DO_NOTHING, 0);
		StockStatus Stock2 = new StockStatus("unknown", 0, 0, date, ALGO_RECOMMENDATION.DO_NOTHING, 0);
		StockStatus Stock3 = new StockStatus("unknown", 0, 0, date, ALGO_RECOMMENDATION.DO_NOTHING, 0);
		
		
		
		Stock1.setSymbol("PIH");
		Stock1.setAsk((float) 10);
		Stock1.setBid((float) 8.5);
		Stock1.setDate(date);
		myPortfolio.addStock(Stock1);
		
		Stock2.setSymbol("AAL");
		Stock2.setAsk((float) 30);
		Stock2.setBid((float) 25.5);
		Stock2.setDate(date);
		myPortfolio.addStock(Stock2);
		
			
		Stock3.setSymbol("CAAS");
		Stock3.setAsk((float) 20);
		Stock3.setBid((float)15.5);
		Stock3.setDate(date);
		myPortfolio.addStock(Stock3);
		myPortfolio.addStock(Stock3);
		
		myPortfolio.setTitle("Exerisce 7 portfolio");
		myPortfolio.setBalance(10000);
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		
			
		return myPortfolio;
		
	}
	
	
	
}
