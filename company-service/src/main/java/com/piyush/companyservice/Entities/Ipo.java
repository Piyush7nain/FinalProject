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
public class Ipo {

    @Id
    private Integer id;

    @ManyToOne(cascade =CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("ipos")
    @JsonIgnore
    private Company company;

    private Integer stockCode;

    private Double pricePerShare;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "open_date")
    private Date date;

    private String remarks;

    public Ipo(Integer id, Integer stockCode, Double pricePerShare, Date date, String remarks) {
        this.id = id;
        this.stockCode = stockCode;
        this.pricePerShare = pricePerShare;
        this.date = date;
        this.remarks = remarks;
    }

    public Ipo() {
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
        return stockCode;
    }

    public void setStockCode(Integer stockCode) {
        this.stockCode = stockCode;
    }

    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
      
}