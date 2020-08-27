package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockExchange {

    @Id
    @Column(name = "Stock_Ex_Code")
    private String code;

    @Column(name = "Stock_Exchange")
    private String stockExName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Info")
    private String info;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStockExName() {
        return stockExName;
    }

    public void setStockExName(String stockExName) {
        this.stockExName = stockExName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public StockExchange() {
    }

    public StockExchange(String code, String stockExName, String address, String info) {
        this.code = code;
        this.stockExName = stockExName;
        this.address = address;
        this.info = info;
    }
    
}