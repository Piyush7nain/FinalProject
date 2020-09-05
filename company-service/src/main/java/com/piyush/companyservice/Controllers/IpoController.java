package com.piyush.companyservice.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/ipo")
public class IpoController {

    @Autowired
    IpoService ipoService;

    @GetMapping("/all")
    public ResponseEntity<List<Ipo>> getAllIpo() throws IpoNotFoundException {
        List<Ipo> allIpo = ipoService.getAllIpo();
        if (allIpo.size() == 0) {
            throw new IpoNotFoundException("No Ipos listed anywhere");
        }
        return ResponseEntity.status(HttpStatus.OK).body(allIpo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ipo> getIpo(@PathVariable Integer id) throws IpoNotFoundException {
        Ipo ipo = ipoService.getIpo(id);
        if (ipo == null) {
            throw new IpoNotFoundException("No Ipo found with Id " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(ipo);
    }

    @GetMapping("/company/{name}/all")
    public ResponseEntity<List<Ipo>> getIpoByName(@PathVariable String name)
            throws IpoNotFoundException, CompanyNotFoundException, RegistrationError {
        List<Ipo> allIpoByCompany = ipoService.getAllIpoByCompany(name);
        if (allIpoByCompany.size() == 0) {
            throw new IpoNotFoundException("No Ipo found for Company " + name);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allIpoByCompany);
    }

    
    @GetMapping("/company/{name}/stockEx/{stockCode}")
    public ResponseEntity<List<Ipo>> getAllIpo(@PathVariable(value = "name") String name,
            @PathVariable(value = "stockCode") String stockCode) throws CompanyNotFoundException, IpoNotFoundException,
            RegistrationError {
        
                List<Ipo> ipoByCompanyStockEx = ipoService.getIpoByCompanyStockEx(name, stockCode);
                if(ipoByCompanyStockEx.size() == 0){throw new IpoNotFoundException("No Ipos found for the company " + name);}
                return ResponseEntity.status(HttpStatus.OK).body(ipoByCompanyStockEx);
    }

    @PostMapping("/company/{name}/range")
    public ResponseEntity<List<Ipo>> getIpoByRange(@RequestBody Dates dates, @PathVariable String name) throws CompanyNotFoundException,IpoNotFoundException,
            RegistrationError {
        List<Ipo> ipoByRange = ipoService.getIpoByRange(dates, name);
        if(ipoByRange.size() == 0){ throw new IpoNotFoundException("No Ipo found for the company "+name + " in the given range.");}
        return ResponseEntity.status(HttpStatus.OK).body(ipoByRange);
    }

    @PostMapping("/add/{name}")
    public ResponseEntity<Map<String, String>> addIpo(@RequestBody Ipo ipo, @PathVariable String name){
        String addIpo = ipoService.addIpo(ipo, name);
        Map<String, String> map = new HashMap<>();
        map.put("status", addIpo);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<Map<String, String>> removeIpo(@PathVariable Integer id) throws IpoNotFoundException{
        Map<String, String> map = new HashMap<>();
        String removeIpo = ipoService.removeIpo(id);
        map.put("status", removeIpo);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }    
}