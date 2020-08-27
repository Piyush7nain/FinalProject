package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Services.CompanyService;

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
    

    //add methods
    @PostMapping("/company/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }

}