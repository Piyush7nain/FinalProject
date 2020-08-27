package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.models.Dates;

public interface CompanyService {

	List<Company> getAllCompany();

	List<Company> getCompanyByLikeName(String name);

	Company addCompany(Company company);

	List<StockPrices> getAllStockPricesByName(String name);

	List<StockPrices> getStockPriceByCompanyStockEx(String name, Integer stockCode);

	List<StockPrices> getStockPricesByRange(Dates dates, String name);
    
}