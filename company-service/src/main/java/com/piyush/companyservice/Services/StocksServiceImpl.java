package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.Repository.CodesRepository;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.StockPricesRepository;
import com.piyush.companyservice.models.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksServiceImpl implements StocksService {

    @Autowired
    StockPricesRepository stockPriceRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CodesRepository codesRepository;

    @Override
    public List<StockPrices> getAllStockPricesByName(String name) throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name);}
        List<String> codes = codesRepository.findByCompanyName(company.getCompanyName());
        if(codes == null){throw new RegistrationError("Company might not be registered with any StockExchages");}
        List<StockPrices> stocks = stockPriceRepository.findByCompanyCodeInOrderByDate(codes);
        return stocks;
    }

    @Override
    public List<StockPrices> getStockPriceByCompanyStockEx(String name, String stockCode)
            throws CompanyNotFoundException, RegistrationError {
        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name);}
        String code = codesRepository.findCompanyCodeByCompanyNameAndStockCode(company.getCompanyName(), stockCode).getCompanyCode();
        if(code == null){throw new RegistrationError("Either "+ stockCode +" is not registered or "+name+" is not registered with "+stockCode);}
        return stockPriceRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<StockPrices> getStockPricesByRange(Dates dates, String name) throws CompanyNotFoundException,
            RegistrationError {

        Company company = companyRepository.findByCompanyName(name);
        if(company == null){throw new CompanyNotFoundException("No company found with name "+ name);}
        List<String> codes = codesRepository.findByCompanyName(company.getCompanyName());
        if(codes == null){throw new RegistrationError("Company might not be registered with any StockExchages");}
        return stockPriceRepository.findStockInRange(codes, dates.getStartDate(), dates.getEndDate());
    }

    @Override
    public String addStock(StockPrices sp) {
        stockPriceRepository.save(sp); 
        return "Added new Stock for "+ sp.getCompanyCode() + " in StockExchange "+ sp.getStockCode();
    }

    @Override
    public List<StockPrices> getAllStocks() {
        return stockPriceRepository.findAll();
    }

    @Override
    public StockPrices getStockPrices(Integer id) {
        return stockPriceRepository.findById(id).get();
    }
}