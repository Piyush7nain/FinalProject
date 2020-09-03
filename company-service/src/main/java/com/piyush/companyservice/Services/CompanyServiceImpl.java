package com.piyush.companyservice.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany()  {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getCompanyByLikeName(String name) {
        return companyRepository.findByCompanyNameIgnoreCaseContaining(name);
    }

    //Add services
    @Override
    public String addCompany(Company company) {
        
        if(companyRepository.findByCompanyNameIgnoreCase(company.getCompanyName()) == null){
            companyRepository.save(company);
            return "Added company " + company.getCompanyName() + " to DataBase";
        }
        else{
            return "Company already exist, use update request to update data";
        }
    }

    @Override
    @Transactional
    public String updateCompany(Company company) {
        Company data = companyRepository.findByCompanyNameIgnoreCase(company.getCompanyName());
        if(data ==null){
            companyRepository.save(company);
            return "No existing record of the company found, added new company" + company.getCompanyName()+ " to DataBase";
        }else{
            data.setCompanyDetails(company.getCompanyDetails());
            data.setSectorName(company.getSectorName());
            data.setCompanyName(company.getCompanyName());
            data.setTurnover(company.getTurnover());      
            //companyRepository.saveAndFlush(data);
            return "Udpated company "+ data.getCompanyName();
        }
        
    }

    @Override
    @Transactional
    public String removeCompany(String name) throws CompanyNotFoundException{
        Company company = companyRepository.findByCompanyNameIgnoreCase(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        companyRepository.delete(company);
        return "Removed " + company.getCompanyName() + " from Database.";
    }
    
}