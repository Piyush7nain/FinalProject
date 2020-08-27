package com.piyush.companyservice.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.StockPriceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    StockPriceRepository stockPriceRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public CompanyServiceImpl(CompanyRepository companyRepository, StockPriceRepository stockPriceRepository) {
        this.companyRepository = companyRepository;
        this.stockPriceRepository = stockPriceRepository;
    }

    @Override
    public List<Company> getCompanyByLikeName(String name) {
        List<Company> company = companyRepository.findByCompanyNameIgnoreCaseContaining(name);
        //logger.info("Company by id -> {}", company);
        return company;
    }

    @Override
    public Company getCompanyById(Integer id) {
        Company company = companyRepository.findById(id).get();
        logger.info("Company by id -> {}", company);
        return company;
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> company = companyRepository.findAll();
        logger.info("Company by id -> {}", company);
        return company;
    }

    @Override
    @Transactional
    public List<StockPrices> getStockPrice(String name) {
        Integer code = companyRepository.findCompanyByCompanyName(name).getId();
        logger.info("Company code -> {}", code );
        return stockPriceRepository.findByCompany(code) ;
    }

    @Override
    public List<StockPrices> getAllStockPrice() {
        return stockPriceRepository.findAllByOrderByDate();
    }

    
}