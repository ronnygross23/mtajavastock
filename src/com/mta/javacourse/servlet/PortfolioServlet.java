package com.mta.javacourse.servlet;

import java.io.IOException;
import java.util.Date;

import com.mta.javacourse.exceptions.BalanceException;
import com.mta.javacourse.exceptions.NotEnoughStock;
import com.mta.javacourse.exceptions.PortfolioFullException;
import com.mta.javacourse.exceptions.StockAlreadyExistsException;
import com.mta.javacourse.exceptions.StockNotExistException;
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
		Portfolio portfolio;
		try {
			portfolio = portfolioService.getPortfolio();
			Stock[] stocks = portfolio.getStocks();
			resp.getWriter().println(portfolio.getHtmlString());
		} catch (StockNotExistException e) {
			resp.getWriter().println("There is no stock");
		} catch (StockAlreadyExistsException e1) {
			resp.getWriter().println("Stock already exists");
		} catch (NotEnoughStock e2) {
			resp.getWriter().println("there not enough stock to sell");
		} catch (BalanceException e3) {
			resp.getWriter().println("you dont have enough balance to buy the stock");
		} catch (PortfolioFullException e4) {
			resp.getWriter().println("Your stock portfolio reached maximum size");
		}  
		
		}
	}



