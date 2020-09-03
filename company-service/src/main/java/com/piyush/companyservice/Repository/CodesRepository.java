package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.CompanyStockCodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CodesRepository extends JpaRepository<CompanyStockCodes, Integer>{

    @Query(value = "SELECT company_code FROM Company_Stock_Codes AS a WHERE UPPER(a.company_name) = UPPER(?1) ", nativeQuery = true)
	List<String> findByCompanyNameIgnoreCase(String name);

	//@Query(value = "SELECT *   FROM Company_Stock_Codes AS a WHERE UPPER(a.Stock_Code) = UPPER(?1)", nativeQuery = true)
	List<CompanyStockCodes> findByStockCodeIgnoreCase(String name);

	CompanyStockCodes findCompanyCodeByCompanyNameIgnoreCaseAndStockCodeIgnoreCase(String name, String stockCode); 
	
	List<CompanyStockCodes> findByCompanyCodeIgnoreCaseAndCompanyNameIgnoreCaseAndStockCodeIgnoreCase(String companycode, String companyName, String stockCode);

    
}