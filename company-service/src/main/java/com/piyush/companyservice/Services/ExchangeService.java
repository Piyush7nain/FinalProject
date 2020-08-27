package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;

public interface ExchangeService {

	StockExchange addExchange(StockExchange ex);

	List<StockExchange> getExchange();

	StockExchange getExchangeById(Integer id);

	String addCompanyToExchange(CompanyStockCodes csc);

	List<Company> getAllCompanies(Integer id);

	List<StockPrices> getAllStocks(Integer id);

	List<Ipo> getAllIpos(Integer id);

}
