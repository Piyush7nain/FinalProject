package com.piyush.companyservice.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.Exceptions.StockNotFoundException;
import com.piyush.companyservice.Services.StocksService;
import com.piyush.companyservice.models.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockPricesController {

    @Autowired
    StocksService stocksService;

    @GetMapping("/all")
    public ResponseEntity<List<StockPrices>> getAllStocks() throws StockNotFoundException {
        List<StockPrices> allStocks = stocksService.getAllStocks();
        if (allStocks.size() == 0) {
            throw new StockNotFoundException("No Stocks listed anywhere");
        }
        return ResponseEntity.status(HttpStatus.OK).body(allStocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockPrices> getStockPrices(@PathVariable Integer id) throws StockNotFoundException {
        StockPrices stocks = stocksService.getStockPrices(id);
        if (stocks == null) {
            throw new StockNotFoundException("No Stocks found with Id " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(stocks);
    }

    @GetMapping("/company/{name}/all")
    public ResponseEntity<List<StockPrices>> getStockPricesByName(@PathVariable String name)
            throws CompanyNotFoundException, StockNotFoundException, RegistrationError {
        List<StockPrices> allStockPricesByName = stocksService.getAllStockPricesByName(name);
        if (allStockPricesByName.size() == 0) {
            throw new StockNotFoundException("No stocks found for " + name);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allStockPricesByName);
    }

    @GetMapping("/company/{name}/stockEx/{stockCode}")
    public ResponseEntity<List<StockPrices>> getAllStockPrices(@PathVariable(value = "name") String name,
            @PathVariable(value = "stockCode") String stockCode)
            throws CompanyNotFoundException, RegistrationError, StockNotFoundException {
        
        List<StockPrices> stockPriceByCompanyStockEx = stocksService.getStockPriceByCompanyStockEx(name, stockCode);
        if(stockPriceByCompanyStockEx.size() == 0){ throw new StockNotFoundException("No stocks found for " + name+ " in StockExchange "+ stockCode);}
        return ResponseEntity.status(HttpStatus.OK).body(stockPriceByCompanyStockEx);
    }

    @PostMapping("/company/{name}/range")
    public ResponseEntity<List<StockPrices>> getStockPricesByRange(@RequestBody Dates dates, @PathVariable String name) throws CompanyNotFoundException, StockNotFoundException,
            RegistrationError {
        List<StockPrices> stockPricesByRange = stocksService.getStockPricesByRange(dates, name);
        if(stockPricesByRange.size() == 0){ throw new StockNotFoundException("No stocks found for " + name +" in the given range");}
        return ResponseEntity.status(HttpStatus.OK).body(stockPricesByRange);
    }

    @PostMapping("/add/{name}")
    public ResponseEntity<Map<String, String>> addStock(@RequestBody StockPrices sp, @PathVariable String name){
        String status = stocksService.addStock(sp, name);
        Map<String, String> map = new HashMap<>();
        map.put("status", status);    
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<String> removeStocks(@PathVariable Integer id) throws StockNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(stocksService.removeStock(id));
    }

    @GetMapping("/remove/all")
    public ResponseEntity<String> removeAll() throws StockNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(stocksService.removeAll());
    }
    
}