package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

    List<Company> findByCompanyNameContaining(String name);

    Company findByCompanyName(String name);
    
    List<Company> findByCompanyNameIn(List<String> names);

	List<Company> findBySectorName(String id);
    
}