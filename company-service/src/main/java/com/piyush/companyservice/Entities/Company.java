package com.piyush.companyservice.Entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {

    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name ="company_name", nullable = false)
    private String companyName;

    @Column(name = "company_turnover")
    private double turnover;

    @Column(name ="company_details")
    private String companyDetails;

    @JsonIgnore
    @Transient
    private List<StockPrices> stockPrices;

    @JsonIgnore
    @Transient
    private List<Ipo> ipos;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public Company() {
    }

    public Company(Integer id, String companyName, double turnover, String companyDetails) {
        this.id = id;
        this.companyName = companyName;
        this.turnover = turnover;
        this.companyDetails = companyDetails;
    }

    public List<StockPrices> getStockPrices() {
        return stockPrices;
    }

    public void addStockPrices(StockPrices stockPrices) {
        this.stockPrices.add( stockPrices);
    }

    


    @Override
    public String toString() {
        return "Company [id=" + id + ", companyDetails=" + companyDetails + ", companyName=" + companyName
                + ", turnover=" + turnover + "]";
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public void setStockPrices(List<StockPrices> stockPrices) {
        this.stockPrices = stockPrices;
    }

    public List<Ipo> getIpos() {
        return ipos;
    }

    public void setIpos(List<Ipo> ipos) {
        this.ipos = ipos;
    }

    
    
}