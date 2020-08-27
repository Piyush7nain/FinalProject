package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.StockPrices;
import com.piyush.companyservice.Services.CompanyService;
import com.piyush.models.Dates;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    
   /*  @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getCompanyById(id));
    } */

    @GetMapping("/company/all")
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllCompany());
    }
    
    @GetMapping("/company/{name}")
    public ResponseEntity<List<Company>> getCompanyByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getCompanyByLikeName(name));
    }
    
    @PostMapping("/company/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }
    
    @GetMapping("/company/{name}/stockPricing/all")
    public ResponseEntity<List<StockPrices>> getStockPricesByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllStockPricesByName(name));
    }
    
    @GetMapping("/company/{name}/stockPricing/stockEx/{stockCode}")
    public ResponseEntity<List<StockPrices>> getAllStockPrices(@PathVariable(value = "name") String name, @PathVariable(value = "stockCode") Integer stockCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getStockPriceByCompanyStockEx(name, stockCode));
    }

    @PostMapping("/company/{name}/stockPricing/range")
    public ResponseEntity<List<StockPrices>> getStockPricesByRange(@RequestBody Dates dates, @PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getStockPricesByRange(dates, name));
    }


    /*
    @GetMapping("/company/{name}/ipo")
    public ResponseEntity<List<Ipo>> getIpoByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getIpoByCompany(name));
    }

    @GetMapping("/ipo/all")
    public ResponseEntity<List<Ipo>> getAllIpo(){
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllIpo());
    } */
    


}