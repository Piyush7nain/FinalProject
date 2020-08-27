package com.piyush.companyservice.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Column(name = "sector_id")
    private Integer sectorId;


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

    public Company(Integer id, String companyName, double turnover, String companyDetails, Integer sectorId) {
        this.sectorId = sectorId;
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

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    
    
}