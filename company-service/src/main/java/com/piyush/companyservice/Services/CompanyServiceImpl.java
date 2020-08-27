package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Repository.CodesRepository;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.StockPricesRepository;
import com.piyush.models.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    private CodesRepository codesRepository;
    @Autowired
    private StockPricesRepository stockPriceRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getCompanyByLikeName(String name) {
        return companyRepository.findByCompanyNameContaining(name);
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<StockPrices> getAllStockPricesByName(String name) {
        Integer id = companyRepository.findByCompanyName(name).getid();
        List<Integer> codes = codesRepository.findByCompanyId(id);
        List<StockPrices> stocks = stockPriceRepository.findByCompanyCodeInOrderByDate(codes);
        return stocks;
    }

    @Override
    public List<StockPrices> getStockPriceByCompanyStockEx(String name, Integer stockCode) {
        Integer id = companyRepository.findByCompanyName(name).getid();
        Integer code = codesRepository.findCompanyCodeByCompanyIdAndStockCode(id, stockCode).getCompanyCode();
        return stockPriceRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<StockPrices> getStockPricesByRange(Dates dates, String name) {

        Integer id = companyRepository.findByCompanyName(name).getid();
        List<Integer> codes = codesRepository.findByCompanyId(id);
        return stockPriceRepository.findStockInRange(codes,dates.getStartDate(), dates.getEndDate());
    }
    
}