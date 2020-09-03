package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyStockCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "stock_code")
    private String stockCode;
    
    @Column(name = "company_code")
    private String companyCode;

    public String getcompanyName() {
        return companyName;
    }

    public void setcompanyName(String companyId) {
        this.companyName = companyId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public CompanyStockCodes() {
    }

    public CompanyStockCodes(String companyName,String stockCode, String companyCode) {
        this.companyName= companyName;
        this.stockCode = stockCode;
        this.companyCode = companyCode;
    }

    
}