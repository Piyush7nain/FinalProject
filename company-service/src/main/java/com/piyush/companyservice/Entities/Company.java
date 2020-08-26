package com.piyush.companyservice.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
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

    
}