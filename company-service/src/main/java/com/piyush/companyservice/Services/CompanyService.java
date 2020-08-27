package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;


public interface CompanyService {

	List<Company> getCompanyByLikeName(String name);

	Company getCompanyById(Integer id);

	List<Company> getAllCompany();

	List<StockPrices> getStockPrice(String name);

	List<StockPrices> getAllStockPrice();
    
}