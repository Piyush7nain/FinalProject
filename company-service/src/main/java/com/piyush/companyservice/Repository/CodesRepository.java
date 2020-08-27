package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.CompanyStockCodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CodesRepository extends JpaRepository<CompanyStockCodes, Integer>{

    @Query(value = "Select company_code FROM Company_Stock_Codes AS a WHERE a.company_id =?1 ", nativeQuery = true)
	List<Integer> findByCompanyId(Integer id);

	CompanyStockCodes findCompanyCodeByCompanyIdAndStockCode(Integer id, Integer stockCode); 

    
}