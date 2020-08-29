package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.CompanyStockCodes;
import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Entities.StockExchange;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.IpoNotFoundException;
import com.piyush.companyservice.Exceptions.StockExchangeNotFoundException;
import com.piyush.companyservice.Exceptions.StockNotFoundException;
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

    @PostMapping("/addUpdateExchange")
    public ResponseEntity<String> addExchange(@RequestBody StockExchange ex){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.addExchange(ex));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockExchange>> getAllExchanges() throws StockExchangeNotFoundException{
        List<StockExchange> exchange = exchangeService.getExchange();
        if(exchange ==null){ throw new StockExchangeNotFoundException("No Stock Exchange Listed in the DataBase");}
        return ResponseEntity.status(HttpStatus.CREATED).body(exchange);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockExchange> getExchangeById(@PathVariable String id) throws StockExchangeNotFoundException{
        
        StockExchange exchangeById = exchangeService.getExchangeById(id);
        if(exchangeById ==null){ throw new StockExchangeNotFoundException("No Stock Exchange found with id "+ id);}
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeById);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompanyToExchange(@RequestBody CompanyStockCodes csc){
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.addCompanyToExchange(csc));
    }

    @GetMapping("/{id}/companies")
    public ResponseEntity<List<Company>> getAllCompanies(@PathVariable String id) throws CompanyNotFoundException{
        List<Company> allCompanies = exchangeService.getAllCompanies(id);
        if(allCompanies ==null){ throw new CompanyNotFoundException("No Companies listed in the StockExchange with id "+ id);}
        return ResponseEntity.status(HttpStatus.FOUND).body(allCompanies);
    }
    @GetMapping("/{id}/stocks")
    public ResponseEntity<List<StockPrices>> getAllStockPrices(@PathVariable String id) throws StockNotFoundException{
        List<StockPrices> allStocks = exchangeService.getAllStocks(id);
        if(allStocks == null){ throw new StockNotFoundException("No Stocks present in the StockExchange with id "+id);}
        return ResponseEntity.status(HttpStatus.FOUND).body(allStocks);
    }
    @GetMapping("/{id}/ipos")
    public ResponseEntity<List<Ipo>> getAllIpos(@PathVariable String id) throws IpoNotFoundException{
        List<Ipo> allIpos = exchangeService.getAllIpos(id);
        if(allIpos == null){ throw new IpoNotFoundException("No Ipo's present in the StockExchange with id "+id);}
        return ResponseEntity.status(HttpStatus.FOUND).body(allIpos);
    }

    
}