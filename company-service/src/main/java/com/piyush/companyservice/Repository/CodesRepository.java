package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.CompanyStockCodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CodesRepository extends JpaRepository<CompanyStockCodes, Integer>{

    @Query(value = "SELECT company_code FROM Company_Stock_Codes AS a WHERE a.company_name = ?1 ", nativeQuery = true)
	List<String> findByCompanyNameIgnoreCase(String name);

	@Query(value = "SELECT company_name   FROM Company_Stock_Codes AS a WHERE UPPER(a.Stock_Code) = UPPER(?1)", nativeQuery = true)
	List<String> findCompanyNameByStockCode(String name);

	CompanyStockCodes findCompanyCodeByCompanyNameIgnoreCaseAndStockCodeIgnoreCase(String name, String stockCode); 

    
}