package com.example.tpnotee.Repositories;

import com.example.tpnotee.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByProduits(Long id);
    @Query(value = "SELECT s FROM Stock s WHERE s.qte>s.qteMin")
    List<Stock> findstockbyqt();
}