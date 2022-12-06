package com.example.tpnotee.services.stock;

import com.example.tpnotee.entities.Stock;


import java.util.List;

public interface InterfaceStock {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock s);

    Stock retrieveStock(Long id);

    void removeStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);
    void retrieveStatusStockJPQL() throws Exception;
}
