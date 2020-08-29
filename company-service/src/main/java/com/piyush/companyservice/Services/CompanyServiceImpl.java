package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getCompanyByLikeName(String name) {
        return companyRepository.findByCompanyNameContaining(name);
    }

    //Add services
    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
    
}