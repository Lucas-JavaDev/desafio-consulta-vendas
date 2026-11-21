package com.devsuperior.dsmeta.repositories;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {



    @Query("SELECT s FROM Sale s " +
            "INNER JOIN Seller sl ON s.seller.id = sl.id " +
            "WHERE s.date BETWEEN :dateOne AND :dateTwo AND LOWER(sl.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Sale> findByDate(LocalDate dateOne, LocalDate dateTwo, String name, Pageable pageable);



}
