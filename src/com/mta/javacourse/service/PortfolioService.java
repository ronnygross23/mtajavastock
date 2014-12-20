package com.mta.javacourse.service;

import java.util.Date;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
public class PortfolioService {
	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio(){
		Portfolio myPortfolio=new Portfolio();
		
		Stock Stock1 = new Stock();
		Stock Stock2 = new Stock();
		Stock Stock3 = new Stock();
		
		Date date = new java.util.Date();
		date.setDate(15);
		date.setMonth(0);
		date.setYear(2014);
		
		Stock1.setSymbol("PIH");
		Stock1.setAsk((float) 10);
		Stock1.setBid((float) 8.5);
		Stock1.setDate(date);
		myPortfolio.addStock(Stock1, 20);
		
		Stock2.setSymbol("AAL");
		Stock2.setAsk((float) 30);
		Stock2.setBid((float) 25.5);
		Stock2.setDate(date);
		myPortfolio.addStock(Stock2, 30);
		
			
		Stock3.setSymbol("CAAS");
		Stock3.setAsk((float) 20);
		Stock3.setBid((float)15.5);
		Stock3.setDate(date);
		myPortfolio.addStock(Stock3, 40);
		
		myPortfolio.setTitle("Exerisce 7 portfolio");
		myPortfolio.setBalance(10000);
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 20);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		
			
		return myPortfolio;
		
	}
	
	
	
}
