package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Company;
import com.piyush.companyservice.Entities.Sector;

public interface SectorService {

	String addSector(Sector sector);

	List<Sector> getAllsectors();

	Sector getsector(Integer id);

	List<Company> getAllCompanies(Integer id);

}
