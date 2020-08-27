package com.piyush.companyservice.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Dates {

    @DateTimeFormat(iso = ISO.DATE)
    private Date startDate;

    @DateTimeFormat(iso = ISO.DATE)
    private Date endDate;

    public Dates() {
    }

    public Dates(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    
    
}