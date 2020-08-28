package com.piyush.uploadservice.Repo;

import com.piyush.uploadservice.Entities.StockPrices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockPrices, Integer> {
    
}