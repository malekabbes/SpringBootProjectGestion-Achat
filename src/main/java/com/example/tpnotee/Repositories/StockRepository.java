package com.example.tpnotee.Repositories;

import com.example.tpnotee.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByProduits(Long id);
}