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
    public String addExchange(StockExchange ex) {
        StockExchange data = exchangeRepository.findById(ex.getCode()).get();
        if(data == null){ 
            exchangeRepository.save(ex);
            return "Added " + ex.getStockExName() + " to the DataBase";
        }else{
            data.setAddress(ex.getAddress());
            data.setCode(ex.getCode());
            data.setInfo(ex.getInfo());
            data.setStockExName(ex.getStockExName());
            exchangeRepository.save(data);
            return "Updated " + ex.getStockExName();
        }        
        
    }

    @Override
    public List<StockExchange> getExchange() {
        return exchangeRepository.findAll();
    }

    @Override
    public StockExchange getExchangeById(String id) {
        Optional<StockExchange> ex = exchangeRepository.findByCodeIgnoreCase(id);
        return ex.get();
    }

    @Override
    public String addCompanyToExchange(CompanyStockCodes csc) {
        codesRepository.save(csc);
        String s = "";
        s.concat(companyRepository.findById(csc.getCompanyCode()).get().getCompanyName()
                + exchangeRepository.findById(csc.getStockCode()).get().getStockExName());
        return s;
    }

    @Override
    public List<Company> getAllCompanies(String id) {
        List<String> companyIds = codesRepository.findCompanyNameByStockCode(id);
        List<Company> companies = companyRepository.findByCompanyNameIgnoreCaseIn(companyIds);
        return companies;
    }

    @Override
    public List<StockPrices> getAllStocks(String id) {
        return stocksRepository.findByStockCodeIgnoreCase(id);
    }

    @Override
    public List<Ipo> getAllIpos(String id) {
        return ipoRepository.findByStockCodeIgnoreCaseOrderByDate(id);
    }
    
}