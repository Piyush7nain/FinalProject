package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
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
    

    @GetMapping("/company/all")
    public ResponseEntity<List<Company>> getAllCompany() throws CompanyNotFoundException{
        List<Company> allCompany = companyService.getAllCompany();
        if(allCompany ==null){throw new CompanyNotFoundException("No Company added to DataBase") ;} 
        return ResponseEntity.status(HttpStatus.FOUND).body(allCompany);
    }
    
    @GetMapping("/company/{name}")
    public ResponseEntity<List<Company>> getCompanyByName(@PathVariable String name) throws CompanyNotFoundException{
        List<Company> companyByLikeName = companyService.getCompanyByLikeName(name);
        if(companyByLikeName ==null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        return ResponseEntity.status(HttpStatus.FOUND).body(companyByLikeName);
    }
    

    //add methods
    @PostMapping("/company/addCompany")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }
    @PostMapping("/company/updateCompany")
    public ResponseEntity<String> updateCompany(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.updateCompany(company));
    }

}