package com.piyush.companyservice.Repository;

import java.util.Date;
import java.util.List;


import com.piyush.companyservice.Entities.StockPrices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPricesRepository extends JpaRepository<StockPrices, Integer> {

	@Query(value = "SELECT * FROM stock_prices as a where UPPER(a.company_code) IN ?1 ORDER BY a.date_ ,a.time_ ", nativeQuery = true)
	List<StockPrices> findByCompanyCodeIgnoreCaseInOrderByDateTime(List<String> codes);

	@Query(value = "SELECT * FROM stock_prices as a where UPPER(a.company_code) = ?1 ORDER BY a.date_, a.time_ ", nativeQuery = true)
	List<StockPrices> findByCompanyCodeIgnoreCaseOrderByDate(String code);

	@Query(value = "SELECT * FROM stock_prices as a WHERE UPPER(a.company_code) IN ?1 AND a.date_ BETWEEN ?2 AND ?3 ORDER BY a.date_ ,a.time_ ", nativeQuery = true)
	List<StockPrices> findStockInRange(List<String> companyCodes, Date date, Date date2);
	
	@Query(value = "SELECT * FROM stock_prices as a WHERE UPPER(a.stock_code) = UPPER(?1) ORDER BY a.date_ ,a.time_", nativeQuery = true)
	List<StockPrices> findByStockCodeIgnoreCase(String stockCode);
}