package com.piyush.companyservice.Entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class StockPrices {

    @Id
    private Integer id;

    
    private Integer companyCode;

    private String stockCode;

    private Double currentPrice;

    @Column(name = "Date_")
    @DateTimeFormat(pattern = "dd/mm/YYYY")
	private Date date;
	
	@Column(name ="time_")
	@DateTimeFormat( pattern = "HH:mm:ss")
	private Time time;

	public StockPrices() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Double getPricePerShare() {
		return currentPrice;
	}

	public void setPricePerShare(Double pricePerShare) {
		this.currentPrice = pricePerShare;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StockPrices(Integer id, Integer companyCode, String stockCode, Double currentPrice, Date date, Time time) {
		this.id = id;
		this.companyCode = companyCode;
		this.stockCode = stockCode;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public Date getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
       
}