package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Ipo;
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
    public ResponseEntity<List<Ipo>> getAllIpo(){
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getAllIpo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ipo> getIpo(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getIpo(id));
    }

    @GetMapping("/compant/{name}/all")
    public ResponseEntity<List<Ipo>> getIpoByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getAllIpoByCompany(name));
    }
    @GetMapping("/company/{name}/stockEx/{stockCode}")
    public ResponseEntity<List<Ipo>> getAllIpo(@PathVariable(value = "name") String name, @PathVariable(value = "stockCode")String stockCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getIpoByCompanyStockEx(name, stockCode));
    }

    @PostMapping("/company/{name}//range")
    public ResponseEntity<List<Ipo>> getIpoByRange(@RequestBody Dates dates, @PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(ipoService.getIpoByRange(dates, name));
    }
    
}