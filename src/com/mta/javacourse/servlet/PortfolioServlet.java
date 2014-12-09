package com.mta.javacourse.servlet;

import java.io.IOException;

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
		


			resp.getWriter().println(portfolio.getHtmlString());
			resp.getWriter().println(portfolio2.getHtmlString());
		}
	}



