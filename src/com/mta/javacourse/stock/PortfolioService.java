package com.mta.javacourse.stock;

import java.util.Date;
import com.mta.javacourse.Stock;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.Stockdetails;
public class PortfolioService {
	public Portfolio getPortfolio(){
		
		Portfolio myPortfolio=new Portfolio();
		
		Stock Stock1 = new Stock();
		Stock Stock2 = new Stock();
		Stock Stock3 = new Stock();
		
		Date date = new java.util.Date();
		date.setDate(15);
		date.setMonth(11);
		date.setYear(2014);
		
		Stock1.setSympol("PIH");
		Stock1.setAsk((float) 12.4);
		Stock1.setBid((float) 13.1);
		Stock1.setDate(date);
		myPortfolio.addStock(Stock1);
		
		Stock2.setSympol("AAL");
		Stock2.setAsk((float) 5.5);
		Stock2.setBid((float) 5.78);
		Stock2.setDate(date);
		myPortfolio.addStock(Stock2);
		
		Stock3.setSympol("CAAS");
		Stock3.setAsk((float) 31.5);
		Stock3.setBid((float) 31.2);
		Stock3.setDate(date);
		myPortfolio.addStock(Stock3);
		
		return myPortfolio;
	}
	
	
	
}
