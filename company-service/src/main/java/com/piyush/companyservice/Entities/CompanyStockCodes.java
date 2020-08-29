package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyStockCodes {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "stock_code")
    private String stockCode;
    
    @Id
    @Column(name = "company_code")
    private String CompanyCode;

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
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    public CompanyStockCodes() {
    }

    public CompanyStockCodes(String companyName,String stockCode, String companyCode) {
        this.companyName= companyName;
        this.stockCode = stockCode;
        CompanyCode = companyCode;
    }

    
}