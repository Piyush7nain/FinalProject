package com.piyush.companyservice.Repository;

import java.util.Date;
import java.util.List;

import com.piyush.companyservice.Entities.Ipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Integer> {


    List<Ipo> findByCompanyCodeInOrderByDate(List<Integer> codes);

    List<Ipo> findByCompanyCodeOrderByDate(Integer code);

    @Query(value = "SELECT * FROM ipo as a WHERE a.company_code IN ?1 AND a.open_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Ipo> findStockInRange(List<Integer> codes, Date startDate, Date endDate);

	List<Ipo> findByStockCode(Integer id);   
    
    
}