package com.piyush.companyservice.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.StockNotFoundException;
import com.piyush.companyservice.Repository.CodesRepository;
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
    private CodesRepository codesRepository;

    @Autowired
    private StockPricesRepository stocksRepository;

    @Autowired
    private IpoRepository ipoRepository;

    @Override
    @Transactional
    public String addExchange(StockExchange ex) {
       Optional<StockExchange> data = exchangeRepository.findByCodeIgnoreCase(ex.getCode());
        if(data.isEmpty()){ 
            exchangeRepository.save(ex);
            return "successful";
        }else{
            data.get().setAddress(ex.getAddress());
            data.get().setCode(ex.getCode());
            data.get().setInfo(ex.getInfo());
            data.get().setStockExName(ex.getStockExName());
            //exchangeRepository.save(data);
            return "successful";
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
        List<CompanyStockCodes> codes = codesRepository.findByCompanyCodeIgnoreCaseAndCompanyNameIgnoreCaseAndStockCodeIgnoreCase(
                                csc.getCompanyCode(),
                                csc.getcompanyName(),
                                csc.getStockCode());

        if(codes.size() == 0){
            codesRepository.save(csc);
            return "successful";
        }else{
            return "failed";
        }
    }

    @Override
    public List<CompanyStockCodes> getAllCompanies(String id) {
        List<CompanyStockCodes> companyIds = codesRepository.findByStockCodeIgnoreCase(id);
        return companyIds;
    }

    @Override
    public List<StockPrices> getAllStocks(String id) {
        return stocksRepository.findByStockCodeIgnoreCase(id);
    }

    @Override
    public List<Ipo> getAllIpos(String id) {
        return ipoRepository.findByStockCodeIgnoreCaseOrderByDate(id);
    }

    @Override
    public String removeEx(String code) throws StockNotFoundException {
        Optional<StockExchange> ex = exchangeRepository.findByCodeIgnoreCase(code);
        ex.orElseThrow(() -> new StockNotFoundException("No StockExchange found with code " + code));
        exchangeRepository.delete(ex.get());
        return "Removed " + ex.get().getStockExName() + " from DataBase";
    }

    @Override
    public String removeCompany(CompanyStockCodes csc) {
        List<CompanyStockCodes> codes = codesRepository.findByCompanyCodeIgnoreCaseAndCompanyNameIgnoreCaseAndStockCodeIgnoreCase(
                                csc.getCompanyCode(),
                                csc.getcompanyName(),
                                csc.getStockCode());
        codesRepository.deleteAll(codes);
        return "successful";
    }
    
}