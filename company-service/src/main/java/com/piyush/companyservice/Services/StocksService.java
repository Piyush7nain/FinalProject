package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.models.Dates;

public interface StocksService {

    List<StockPrices> getAllStockPricesByName(String name);

	List<StockPrices> getStockPriceByCompanyStockEx(String name, String stockCode);

	List<StockPrices> getStockPricesByRange(Dates dates, String name);
	
	StockPrices addStock(StockPrices sp);
    

}
