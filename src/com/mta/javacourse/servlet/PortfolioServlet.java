package com.mta.javacourse.servlet;

import java.io.IOException;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * this class print the stocks
 * @author Ronny
 *
 */
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PortfolioService portfolioService = new PortfolioService();  
		Portfolio portfolio = portfolioService.getPortfolio();  
		Stock[] stocks = portfolio.getStocks();
		Portfolio portfolio2=portfolioService.getPortfolio();
		String getHtmlString="<h1>Portfolio</h1>"+"<h2> Stock Portfolio </h2>";
		String getHtmlString2="<h1>Portfolio</h1>"+"<h2> Portfolio#2 </h2>";
			resp.getWriter().println(portfolio.getHtmlString(getHtmlString));
			resp.getWriter().println(portfolio2.getHtmlString(getHtmlString2));
			//remove stock1 from portfolio1
			resp.getWriter().println(portfolio.getHtmlString2(getHtmlString));
			resp.getWriter().println(portfolio2.getHtmlString2(getHtmlString2));	
		float bid1=(float) 55.55;//change the value of bid
		portfolio2.getStocks()[2].setBid(bid1);
		resp.getWriter().println(portfolio.getHtmlString2(getHtmlString));
		resp.getWriter().println(portfolio2.getHtmlString2(getHtmlString2));
		
		
		}
	}



