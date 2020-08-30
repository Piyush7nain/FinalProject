package com.piyush.companyservice.Repository;

import java.util.Date;
import java.util.List;

import com.piyush.companyservice.Entities.Ipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IpoRepository extends JpaRepository<Ipo, Integer> {


    List<Ipo> findByCompanyCodeIgnoreCaseInOrderByDate(List<String> codes);

    List<Ipo> findByCompanyCodeOrderByDate(String code);

    @Query(value = "SELECT * FROM ipo as a WHERE a.company_code IN ?1 AND a.open_date BETWEEN ?2 AND ?3 ORDER BY a.open_date", nativeQuery = true)
	List<Ipo> findIpoInRange(List<String> companyCodes, Date startDate, Date endDate);

    List<Ipo> findByStockCodeIgnoreCaseOrderByDate(String id);
    
    List<Ipo> findAllByOrderByDate();
    
    
}