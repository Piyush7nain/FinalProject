package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.StockPrices;
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
@RequestMapping("/api/Stocks")
public class StockPricesController {

    @Autowired
    StocksService stocksService;

    @GetMapping("/company/{name}/all")
    public ResponseEntity<List<StockPrices>> getStockPricesByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(stocksService.getAllStockPricesByName(name));
    }
    
    @GetMapping("/company/{name}/stockEx/{stockCode}")
    public ResponseEntity<List<StockPrices>> getAllStockPrices(@PathVariable(value = "name") String name, @PathVariable(value = "stockCode") String stockCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(stocksService.getStockPriceByCompanyStockEx(name, stockCode));
    }

    @PostMapping("/company/{name}/range")
    public ResponseEntity<List<StockPrices>> getStockPricesByRange(@RequestBody Dates dates, @PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(stocksService.getStockPricesByRange(dates, name));
    }

    @PostMapping("/company/addStock")
    public ResponseEntity<StockPrices> addStock(@RequestBody StockPrices sp){
        return ResponseEntity.status(HttpStatus.CREATED).body(stocksService.addStock(sp));
    }
    
}