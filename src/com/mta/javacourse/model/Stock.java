package com.mta.javacourse.model;

public class Stock {
	

	protected String symbol;
	protected float ask;
	protected float bid;
	protected java.util.Date date; 
	
	public Stock()
	{
		ask=0;
		bid=0;
		symbol="unknown";
		date=null;
	}
	public Stock(float ask1,float bid1,String symbol1,java.util.Date date1 )
	{
		ask=ask1;
		bid=bid1;
		symbol=symbol1;
		date=date1;
	}
	public Stock(Stock Stock1)
	{
		this.ask=Stock1.getAsk();
		this.bid=Stock1.getBid();
		this.date=Stock1.getDate();
		this.symbol=Stock1.getHtmlDescription();
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {

		this.symbol = symbol;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask1) {

		ask = ask1;
	}

	public float getBid() {

		return bid;
	}

	public void setBid(float bid1) {

		bid = bid1;
	}

	public java.util.Date getDate() {

		return date;

	}

	public void setDate(java.util.Date date) {

		this.date = date;

	}

	public String getHtmlDescription() {

		String strdate = date.getMonth()+1+"/"+date.getDate()+"/"+date.getYear();

		String stockHtmlDetailsString= "<b>Stock symbol </b>"+":"+getSymbol()+" "+"<b>ask</b>"+":"+getAsk()+" "+"<b>bit</b>"+":"+getBid()+" "+"<b>date</b>"+":" +strdate;  

		return stockHtmlDetailsString;

	}



}

