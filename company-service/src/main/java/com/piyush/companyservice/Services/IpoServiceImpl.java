package com.piyush.companyservice.Services;

import java.util.List;
import java.util.Optional;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
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
    public Ipo addIpo(Ipo ipo) {
        return ipoRepository.save(ipo);
    }

    @Override
    public List<Ipo> getAllIpoByCompany(String name) throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        List<String> codes = codesRepository.findByCompanyName(company.getCompanyName());
        if(codes == null){throw new RegistrationError("Company might not be registered with any StockExchages");}
        List<Ipo> ipos = ipoRepository.findByCompanyCodeInOrderByDate(codes);
        return ipos;
    }

    @Override
    public List<Ipo> getIpoByCompanyStockEx(String name, String stockCode) throws CompanyNotFoundException,
            RegistrationError {
        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        String code = codesRepository.findCompanyCodeByCompanyNameAndStockCode(company.getCompanyName(), stockCode).getCompanyCode();
        if(code == null){throw new RegistrationError("Either "+ stockCode +" is not registered or "+name+" is not registered with "+stockCode);}
        return ipoRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<Ipo> getIpoByRange(Dates dates, String name) throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        List<String> codes = codesRepository.findByCompanyName(company.getCompanyName());
        if(codes == null){throw new RegistrationError("Company might not be registered with any StockExchages");}
        return ipoRepository.findIpoInRange(codes, dates.getStartDate(), dates.getEndDate());
    }

    @Override
    public List<Ipo> getAllIpo() {
        return ipoRepository.findAllByOrderByDate();
    }

    @Override
    public Ipo getIpo(Integer id) {
        Optional<Ipo> ipo = ipoRepository.findById(id);

        return ipo.get();
    }

}
