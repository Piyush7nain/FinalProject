package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.StockPrices;
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
    public List<StockPrices> getAllStockPricesByName(String name) {
        String id = companyRepository.findByCompanyName(name).getid();
        List<String> codes = codesRepository.findByCompanyId(id);
        List<StockPrices> stocks = stockPriceRepository.findByCompanyCodeInOrderByDate(codes);
        return stocks;
    }

    @Override
    public List<StockPrices> getStockPriceByCompanyStockEx(String name, String stockCode) {
        String id = companyRepository.findByCompanyName(name).getid();
        String code = codesRepository.findCompanyCodeByCompanyIdAndStockCode(id, stockCode).getCompanyCode();
        return stockPriceRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<StockPrices> getStockPricesByRange(Dates dates, String name) {

        String id = companyRepository.findByCompanyName(name).getid();
        List<String> codes = codesRepository.findByCompanyId(id);
        return stockPriceRepository.findStockInRange(codes, dates.getStartDate(), dates.getEndDate());
    }

    @Override
    public StockPrices addStock(StockPrices sp) {
        return stockPriceRepository.save(sp);
    }
}