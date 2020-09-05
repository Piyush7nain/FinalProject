package com.piyush.companyservice.Entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String companyCode;

    private String stockCode;

    private Double pricePerShare;

    //@DateTimeFormat(iso = ISO.DATE)
    //@JsonFormat(pattern = "dd/mm/YYYY")
    @Column(name = "open_date")
    private Date date;

    private String remarks;


    
    public Ipo() {
    }

    public Ipo(Integer id, String companyCode, String stockCode, Double pricePerShare, Date date, String remarks) {
        this.id = id;
        this.companyCode = companyCode;
        this.stockCode = stockCode;
        this.pricePerShare = pricePerShare;
        this.date = date;
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
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