package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;

public interface CompanyService {

	List<Company> getAllCompany();

	List<Company> getCompanyByLikeName(String name);

	String addCompany(Company company);

	String updateCompany(Company company);

	String removeCompany(String name) throws CompanyNotFoundException;
    
}