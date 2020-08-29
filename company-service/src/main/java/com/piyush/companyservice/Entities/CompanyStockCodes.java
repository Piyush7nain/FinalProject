package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyStockCodes {

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "stock_code")
    private String stockCode;
    
    @Id
    @Column(name = "company_code")
    private String CompanyCode;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public CompanyStockCodes(String companyId,String stockCode, String companyCode) {
        this.companyId = companyId;
        this.stockCode = stockCode;
        CompanyCode = companyCode;
    }

    
}