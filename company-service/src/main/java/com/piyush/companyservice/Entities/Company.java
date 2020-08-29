package com.piyush.companyservice.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name ="company_name", nullable = false)
    private String companyName;

    @Column(name = "company_turnover")
    private double turnover;

    @Column(name ="company_details")
    private String companyDetails;

    @Column(name = "sector_name")
    private String sectorName;


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

    public Company(String id, String companyName, double turnover, String companyDetails, String sectorId) {
        this.sectorName = sectorId;
        this.id = id;
        this.companyName = companyName;
        this.turnover = turnover;
        this.companyDetails = companyDetails;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", companyDetails=" + companyDetails + ", companyName=" + companyName
                + ", turnover=" + turnover + "]";
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    
    
}