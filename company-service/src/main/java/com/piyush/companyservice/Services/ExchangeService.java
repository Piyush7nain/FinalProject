package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.StockNotFoundException;

public interface ExchangeService {

	String addExchange(StockExchange ex);

	List<StockExchange> getExchange();

	StockExchange getExchangeById(String id);

	String addCompanyToExchange(CompanyStockCodes csc);

	List<CompanyStockCodes> getAllCompanies(String id);

	List<StockPrices> getAllStocks(String id);

	List<Ipo> getAllIpos(String id);

	String removeEx(String code) throws StockNotFoundException;

}
