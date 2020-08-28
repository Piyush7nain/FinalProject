package com.piyush.uploadservice.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class StockPrices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private String companyCode;

    private String stockCode;

    private Double currentPrice;

    @Column(name = "Date_")
    @DateTimeFormat(iso = ISO.DATE)
	private Date date;
	
	@Column(name = "time_")
	private String time;

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

	public StockPrices(String companyCode, String stockCode, Double currentPrice, Date date, String time) {
		this.companyCode = companyCode;
		this.stockCode = stockCode;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrices [companyCode=" + companyCode + ", currentPrice=" + currentPrice + ", date=" + date + ", id="
				+ id + ", stockCode=" + stockCode + ", time=" + time + "]";
	}
	
       
}