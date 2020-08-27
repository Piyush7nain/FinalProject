package com.piyush.companyservice.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class StockPrices {

    @Id
    private Integer id;

    @ManyToOne(cascade =CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stockPrices")
    @JsonIgnore
    private Company company;

    private Integer StockCode;

    private Double currentPrice;

    @Column(name = "at_time")
    @DateTimeFormat(iso = ISO.DATE)
    private Date date;

	public StockPrices() {
	}

	public StockPrices(Integer id, Company company, Integer stockCode, Double pricePerShare, Date date) {
		this.id = id;
		this.company = company;
		this.StockCode = stockCode;
		this.currentPrice = pricePerShare;
		this.date = date;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
    
    

    
}