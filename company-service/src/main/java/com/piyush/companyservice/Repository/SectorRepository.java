package com.piyush.companyservice.Repository;

import com.piyush.companyservice.Entities.Sector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findBySectorName(String name);

}
