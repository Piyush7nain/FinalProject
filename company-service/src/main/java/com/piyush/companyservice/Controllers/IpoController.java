package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.IpoNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.Services.IpoService;
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
@RequestMapping("/api/ipo")
public class IpoController {

    @Autowired
    IpoService ipoService;

    @GetMapping("/all")
    public ResponseEntity<List<Ipo>> getAllIpo() throws IpoNotFoundException {
        List<Ipo> allIpo = ipoService.getAllIpo();
        if (allIpo == null) {
            throw new IpoNotFoundException("No Ipos listed anywhere");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(allIpo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ipo> getIpo(@PathVariable Integer id) throws IpoNotFoundException {
        Ipo ipo = ipoService.getIpo(id);
        if (ipo == null) {
            throw new IpoNotFoundException("No Ipo found with Id " + id);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(ipo);
    }

    @GetMapping("/company/{name}/all")
    public ResponseEntity<List<Ipo>> getIpoByName(@PathVariable String name)
            throws IpoNotFoundException, CompanyNotFoundException, RegistrationError {
        List<Ipo> allIpoByCompany = ipoService.getAllIpoByCompany(name);
        if (allIpoByCompany == null) {
            throw new IpoNotFoundException("No Ipo found for Company " + name);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(allIpoByCompany);
    }

    @GetMapping("/company/{name}/stockEx/{stockCode}")
    public ResponseEntity<List<Ipo>> getAllIpo(@PathVariable(value = "name") String name,
            @PathVariable(value = "stockCode") String stockCode) throws CompanyNotFoundException, IpoNotFoundException,
            RegistrationError {
        
                List<Ipo> ipoByCompanyStockEx = ipoService.getIpoByCompanyStockEx(name, stockCode);
                if(ipoByCompanyStockEx == null){throw new IpoNotFoundException("No Ipos found for the company " + name);}
                return ResponseEntity.status(HttpStatus.FOUND).body(ipoByCompanyStockEx);
    }

    @PostMapping("/company/{name}/range")
    public ResponseEntity<List<Ipo>> getIpoByRange(@RequestBody Dates dates, @PathVariable String name) throws CompanyNotFoundException,IpoNotFoundException,
            RegistrationError {
        List<Ipo> ipoByRange = ipoService.getIpoByRange(dates, name);
        if(ipoByRange == null){ throw new IpoNotFoundException("No Ipo found for the company "+name + " in the given range.");}
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoByRange);
    }
    
}