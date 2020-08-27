package com.piyush.companyservice.Services;

import java.util.List;

import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.models.Dates;

public interface IpoService {

    Ipo addIpo(Ipo ipo);

    List<Ipo> getAllIpoByCompany(String name);

	List<Ipo> getIpoByCompanyStockEx(String name, String stockCode);

	List<Ipo> getIpoByRange(Dates dates, String name);

	List<Ipo> getAllIpo();

	Ipo getIpo(Integer id);


}
