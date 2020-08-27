package com.piyush.companyservice.Repository;

import com.piyush.companyservice.Entities.StockExchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<StockExchange, Integer> {

}
