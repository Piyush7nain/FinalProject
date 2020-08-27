package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyStockCodes {

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "stock_code")
    private Integer stockCode;
    
    @Id
    @Column(name = "company_code")
    private Integer CompanyCode;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStockCode() {
        return stockCode;
    }

    public void setStockCode(Integer stockCode) {
        this.stockCode = stockCode;
    }

    public Integer getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        CompanyCode = companyCode;
    }

    public CompanyStockCodes() {
    }

    public CompanyStockCodes(Integer companyId, Integer stockCode, Integer companyCode) {
        this.companyId = companyId;
        this.stockCode = stockCode;
        CompanyCode = companyCode;
    }

    
}