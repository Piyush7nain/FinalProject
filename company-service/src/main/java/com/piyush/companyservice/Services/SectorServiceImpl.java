package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.Sector;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.SectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    SectorRepository sectorRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public String addSector(Sector sector) {
        sectorRepository.save(sector);
        return "Added Sector " + sector.getSectorName() + " to the Database";
    }

    @Override
    public List<Sector> getAllsectors() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector getsector(String id) {
        return sectorRepository.findById(id).get();
    }

    @Override
    public List<Company> getAllCompanies(String name) {
        
        return companyRepository.findBySectorName(name);
    }
    
}