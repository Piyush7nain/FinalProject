package com.piyush.companyservice.Repository;

import java.util.Date;
import java.util.List;


import com.piyush.companyservice.Entities.StockPrices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPricesRepository extends JpaRepository<StockPrices, Integer> {


	List<StockPrices> findByCompanyCodeInOrderByDate(List<Integer> codes);

	List<StockPrices> findByCompanyCodeOrderByDate(Integer code);

	@Query(value = "SELECT * FROM stock_prices as a WHERE a.company_code IN ?1 AND a.at_time BETWEEN ?2 AND ?3", nativeQuery = true)
	List<StockPrices> findStockInRange(List<Integer> codes, Date date, Date date2);
    
}