package com.mta.javacourse.model;
import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
import java.util.Date;
/**
 * The class contains data on regarding the advisability of investing,this class extends data from class stock. 
 * @author Ronny
 *@since 29.12.14
 */
public class StockStatus extends Stock {
	
	private ALGO_RECOMMENDATION recommendion;
	private int stockQuantity;
	
	public StockStatus(String symbol1,float Bid1,float Ask1,Date date1,ALGO_RECOMMENDATION recommendion1,int stockQuantity1){
		super (Ask1,Bid1,symbol1,date1);
		stockQuantity=stockQuantity1;
		recommendion=recommendion1;
	}
	public StockStatus (StockStatus stockstatus)
	{
		this.ask = stockstatus.getAsk();
		this.bid = stockstatus.getBid();
		this.symbol = stockstatus.getSymbol();
		this.date = new Date(stockstatus.getDate().getTime());
		this.recommendion = stockstatus.getRecommendion();
		this.stockQuantity = stockstatus.getStockQuantity();
	}
	public StockStatus(Stock stock) {
		super(stock);
		stockQuantity = 0;
		recommendion = ALGO_RECOMMENDATION.DO_NOTHING;
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
