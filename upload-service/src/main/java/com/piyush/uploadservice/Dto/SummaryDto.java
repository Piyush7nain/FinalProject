package com.piyush.uploadservice.Dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SummaryDto {

    private String companyCode;

    private String StockExCode;

    private int numOfRecords;

    @DateTimeFormat(iso = ISO.DATE)
    private Date startDate;

    @DateTimeFormat(iso = ISO.DATE)
    private Date endDate;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStockExCode() {
        return StockExCode;
    }

    public void setStockExCode(String stockExCode) {
        StockExCode = stockExCode;
    }

    public int getNumOfRecords() {
        return numOfRecords;
    }

    public void setNumOfRecords(int numOfRecords) {
        this.numOfRecords = numOfRecords;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SummaryDto() {
    }

    public SummaryDto(String companyCode, String stockExCode, int numOfRecords, Date startDate, Date endDate) {
        this.companyCode = companyCode;
        StockExCode = stockExCode;
        this.numOfRecords = numOfRecords;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
}