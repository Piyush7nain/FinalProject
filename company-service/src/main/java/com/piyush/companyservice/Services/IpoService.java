package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Exceptions.CompanyNotFoundException;
import com.piyush.companyservice.Exceptions.RegistrationError;
import com.piyush.companyservice.models.Dates;

public interface IpoService {

    Ipo addIpo(Ipo ipo);

    List<Ipo> getAllIpoByCompany(String name) throws CompanyNotFoundException, RegistrationError;

	List<Ipo> getIpoByCompanyStockEx(String name, String stockCode) throws CompanyNotFoundException, RegistrationError;

	List<Ipo> getIpoByRange(Dates dates, String name) throws CompanyNotFoundException, RegistrationError;

	List<Ipo> getAllIpo();

	Ipo getIpo(Integer id);


}
