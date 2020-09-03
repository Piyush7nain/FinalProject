package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Services.CompanyService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/company")
public class CompanyController {

    CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompany() throws CompanyNotFoundException{
        List<Company> allCompany = companyService.getAllCompany();
        if(allCompany.size() ==0){throw new CompanyNotFoundException("No Company added to DataBase") ;} 
        return ResponseEntity.status(HttpStatus.OK).body(allCompany);
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<List<Company>> getCompanyByName(@PathVariable String name) throws CompanyNotFoundException{
        List<Company> companyByLikeName = companyService.getCompanyByLikeName(name);
        if(companyByLikeName.size() ==0){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        return ResponseEntity.status(HttpStatus.OK).body(companyByLikeName);
    }
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //add methods
    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        logger.info("ADD COMPANY -> {}", company);
        return ResponseEntity.status(HttpStatus.OK).body(companyService.addCompany(company));
    }
    @PostMapping("/updateCompany")
    public ResponseEntity<String> updateCompany(@RequestBody Company company){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompany(company));
    }

    @GetMapping("/remove/{name}")
    public ResponseEntity<String> removeCompanyByName(@PathVariable String name) throws CompanyNotFoundException{
        String removeCompany = companyService.removeCompany(name);
        if(removeCompany ==null){throw new CompanyNotFoundException("No company found with name "+ name) ;}
        return ResponseEntity.status(HttpStatus.OK).body(removeCompany);
    }

}