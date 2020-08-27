package com.piyush.companyservice.Services;

import java.util.List;
import java.util.Optional;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Repository.CodesRepository;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.ExchangeRepository;
import com.piyush.companyservice.Repository.IpoRepository;
import com.piyush.companyservice.Repository.StockPricesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CodesRepository codesRepository;

    @Autowired
    private StockPricesRepository stocksRepository;

    @Autowired
    private IpoRepository ipoRepository;

    @Override
    public StockExchange addExchange(StockExchange ex) {
        return exchangeRepository.save(ex);
    }

    @Override
    public List<StockExchange> getExchange() {
        return exchangeRepository.findAll();
    }

    @Override
    public StockExchange getExchangeById(String id) {
        Optional<StockExchange> ex = exchangeRepository.findById(id);
        return ex.get();
    }

    @Override
    public String addCompanyToExchange(CompanyStockCodes csc) {
        codesRepository.save(csc);
        String s = "";
        s.concat(companyRepository.findById(csc.getCompanyId()).get().getCompanyName()
                + exchangeRepository.findById(csc.getStockCode()).get().getStockExName());
        return s;
    }

    @Override
    public List<Company> getAllCompanies(String id) {
        List<Integer> companyIds = codesRepository.findCompanyIdByStockCode(id);
        List<Company> companies = companyRepository.findByIdIn(companyIds);
        return companies;
    }

    @Override
    public List<StockPrices> getAllStocks(String id) {
        return stocksRepository.findByStockCode(id);
    }

    @Override
    public List<Ipo> getAllIpos(String id) {
        return ipoRepository.findByStockCodeOrderByDate(id);
    }
    
}