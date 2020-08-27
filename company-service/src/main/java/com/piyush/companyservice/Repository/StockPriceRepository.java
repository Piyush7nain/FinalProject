package com.piyush.companyservice.Repository;

import java.util.List;

import com.piyush.companyservice.Entities.StockPrices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrices, Integer> {
   List<StockPrices> findAllByOrderByDate();
   
   @Query(value  ="select * from Stock_Prices WHERE Stock_Prices.company_code = ?1 ORDER BY Stock_Prices.at_time", nativeQuery = true)
   List<StockPrices> findByCompany(Integer code);
}