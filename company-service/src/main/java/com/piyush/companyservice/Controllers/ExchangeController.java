package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Services.ExchangeService;

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
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/addExchange")
    public ResponseEntity<StockExchange> addExchange(@RequestBody StockExchange ex){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.addExchange(ex));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockExchange>> getAllExchanges(){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.getExchange());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockExchange> getExchangeById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.getExchangeById(id));
    }

    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompanyToExchange(@RequestBody CompanyStockCodes csc){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.addCompanyToExchange(csc));
    }

    @GetMapping("/{id}/companies")
    public ResponseEntity<List<Company>> getAllCompanies(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(exchangeService.getAllCompanies(id));
    }
    @GetMapping("/{id}/stocks")
    public ResponseEntity<List<StockPrices>> getAllStockPrices(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(exchangeService.getAllStocks(id));
    }
    @GetMapping("/{id}/ipos")
    public ResponseEntity<List<Ipo>> getAllIpos(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(exchangeService.getAllIpos(id));
    }

    
}