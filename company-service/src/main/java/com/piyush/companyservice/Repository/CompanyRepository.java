package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

    List<Company> findByCompanyNameIgnoreCaseContaining(String name);

    Company findByCompanyNameIgnoreCase(String name);
    
    List<Company> findByCompanyNameIgnoreCaseIn(List<String> names);

	List<Company> findBySectorNameIgnoreCase(String id); 
    
}