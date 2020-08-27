package com.piyush.companyservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sector {
    
    @Id
    @Column(name = "Sector_id")
    private Integer id;

    @Column(name = "Sector_name")
    private String sectorName;

    @Column(name ="Sector_info")
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Sector() {
    }

    public Sector(Integer id, String sectorName, String info) {
        this.id = id;
        this.sectorName = sectorName;
        this.info = info;
    }

    
}