package com.piyush.companyservice.Controllers;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.Sector;
import com.piyush.companyservice.Services.SectorService;

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
@RequestMapping("/api/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping("/addSector")
    public ResponseEntity<String> addSector(@RequestBody Sector sector){
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.addSector(sector));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sector>> getAllSector(){
        return ResponseEntity.status(HttpStatus.FOUND).body(sectorService.getAllsectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSector(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(sectorService.getsector(id));
    }

    @GetMapping("/{id}/companies")
    public ResponseEntity<List<Company>> getAllCompanies(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.FOUND).body(sectorService.getAllCompanies(id));
    }
    
}