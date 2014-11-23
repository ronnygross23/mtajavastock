package com.mta.javacourse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stockdetails  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		{
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
			resp.getWriter().println(Stock1.getHtmlDescription()+"<br>");
			
			Stock2.setSympol("AAL");
			Stock2.setAsk((float) 5.5);
			Stock2.setBid((float) 5.78);
			Stock2.setDate(date);
			resp.getWriter().println(Stock2.getHtmlDescription()+"<br>");
			
			Stock3.setSympol("CAAS");
			Stock3.setAsk((float) 31.5);
			Stock3.setBid((float) 31.2);
			Stock3.setDate(date);
			resp.getWriter().println(Stock3.getHtmlDescription()+"<br>");
			
		}

}
}
