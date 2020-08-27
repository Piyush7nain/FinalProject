package com.piyush.companyservice.Entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Company {

    @Id
    @Column(name = "code")
    private Integer code;
    
    @Column(name ="company_name", nullable = false)
    private String companyName;

    @Column(name = "company_turnover")
    private double turnover;

    @Column(name ="company_details")
    private String companyDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("company")
    private List<StockPrices> stockPrices;

    public Integer getId() {
        return code;
    }

    public void setId(Integer id) {
        this.code = id;
    }

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
        this.code = id;
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

    /* @Override
    public String toString() {
        return "Company [code=" + code + ", companyDetails=" + companyDetails + ", companyName=" + companyName
                + ", turnover=" + turnover + "]";
    } */

    
    
}