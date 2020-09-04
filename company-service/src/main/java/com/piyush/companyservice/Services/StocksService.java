package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.Exceptions.StockNotFoundException;
import com.piyush.companyservice.models.Dates;

public interface StocksService {

    List<StockPrices> getAllStockPricesByName(String name) throws CompanyNotFoundException, RegistrationError;

	List<StockPrices> getStockPriceByCompanyStockEx(String name, String stockCode) throws CompanyNotFoundException, RegistrationError;

	List<StockPrices> getStockPricesByRange(Dates dates, String name) throws CompanyNotFoundException, RegistrationError;
	
	String addStock(StockPrices sp);

	List<StockPrices> getAllStocks();

	StockPrices getStockPrices(Integer id);

	String removeStock(Integer id) throws StockNotFoundException;

	String removeAll();
    

}
