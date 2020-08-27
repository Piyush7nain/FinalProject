package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;

public interface CompanyService {

	List<Company> getAllCompany();

	List<Company> getCompanyByLikeName(String name);

	Company addCompany(Company company);
    
}