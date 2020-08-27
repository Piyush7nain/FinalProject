package com.piyush.companyservice.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class StockPrices {

    @Id
    private Integer id;

    
    private Integer companyCode;

    private Integer StockCode;

    private Double currentPrice;

    @Column(name = "at_time")
    @DateTimeFormat(iso = ISO.DATE)
    private Date date;

	public StockPrices() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getStockCode() {
		return StockCode;
	}

	public void setStockCode(Integer stockCode) {
		StockCode = stockCode;
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



	public StockPrices(Integer id, Integer companyCode, Integer stockCode, Double currentPrice, Date date) {
		this.id = id;
		this.companyCode = companyCode;
		StockCode = stockCode;
		this.currentPrice = currentPrice;
		this.date = date;
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
       
}