package com.piyush.companyservice.Services;

import java.util.List;
import java.util.Optional;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.IpoNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.Repository.CodesRepository;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.IpoRepository;
import com.piyush.companyservice.models.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpoServiceImpl implements IpoService {


    @Autowired
    IpoRepository ipoRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CodesRepository codesRepository;

    @Override
    public String addIpo(Ipo ipo, String name) {
        CompanyStockCodes codes = codesRepository.findCompanyCodeByCompanyNameIgnoreCaseAndStockCodeIgnoreCase(
                            companyRepository.findByCompanyNameIgnoreCase(name).getCompanyName(), ipo.getStockCode());
       
        if(codes==null){
            codesRepository.save(new CompanyStockCodes(name, ipo.getStockCode(),ipo.getCompanyCode()));
        }  
        ipoRepository.save(ipo);      
        return "successful";
    }

    @Override
    public List<Ipo> getAllIpoByCompany(String name) throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyNameIgnoreCase(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        List<String> codes = codesRepository.findByCompanyNameIgnoreCase(company.getCompanyName());
        if(codes.size() == 0){throw new RegistrationError("Company might not be registered with any StockExchages");}
        List<Ipo> ipos = ipoRepository.findByCompanyCodeIgnoreCaseInOrderByDate(codes);
        return ipos;
    }

    @Override
    public List<Ipo> getIpoByCompanyStockEx(String name, String stockCode) throws CompanyNotFoundException,
            RegistrationError {
        Company company = companyRepository.findByCompanyNameIgnoreCase(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        String code = codesRepository.findCompanyCodeByCompanyNameIgnoreCaseAndStockCodeIgnoreCase(company.getCompanyName(), stockCode).getCompanyCode();
        if(code == null){throw new RegistrationError("Either "+ stockCode +" is not registered or "+name+" is not registered with "+stockCode);}
        return ipoRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<Ipo> getIpoByRange(Dates dates, String name) throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyNameIgnoreCase(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        List<String> codes = codesRepository.findByCompanyNameIgnoreCase(company.getCompanyName());
        if(codes.size() == 0){throw new RegistrationError("Company might not be registered with any StockExchages");}
        return ipoRepository.findIpoInRange(codes, dates.getStartDate(), dates.getEndDate());
    }

    @Override
    public List<Ipo> getAllIpo() {
        return ipoRepository.findAllByOrderByDate();
    }

    
    @Override
    public Ipo getIpo(Integer id) {
        return ipoRepository.findById(id).get();
    }

    @Override
    public String removeIpo(Integer id) throws IpoNotFoundException {
        Optional<Ipo> ipo = ipoRepository.findById(id);
        ipo.orElseThrow(() -> new IpoNotFoundException("No Ipo found with id "+ id));
        ipoRepository.delete(ipo.get());
        return "Removed Ipo with id " +id;
    }

}
