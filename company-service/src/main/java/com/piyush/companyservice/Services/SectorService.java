package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.Sector;

public interface SectorService {

	String addSector(Sector sector);

	List<Sector> getAllsectors();

	Sector getsector(String id);

	List<Company> getAllCompanies(String name);

}
