package com.example.tpnotee.services.stock;

import com.example.tpnotee.Repositories.StockRepository;
import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service

public class ImpServiceStock implements InterfaceStock {
    @Autowired
    StockRepository repo;
    @Autowired
    GenericRepo<Produit,Long> prodrepo;

    public boolean produitexists=false;


    @Override
    public List<Stock> retrieveAllStocks() {
        try {
            return (List<Stock>) repo.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue : "+err);
        }
        return null;
    }

    @Override
    public Stock addStock(Stock s) {
        try {
            return repo.save(s);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Stock updateStock(Stock s) {
        try {
            return repo.save(s);
        } catch (Exception err1) {
            System.out.println("Une erreur survenue"+err1);
        }
        return s;
    }

    @Override
    public Stock retrieveStock(Long id) {
        Stock res=repo.findById(id).orElse(null);
        try {
            return res;
        } catch (Exception err) {
            System.out.println("Un erreur survenue"+ err);
        }
        return null;
    }

    @Override
    public void removeStock(Long id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }



    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = prodrepo.findById(idProduit).orElse(null);
        Stock stock = repo.findById(idStock).orElse(null);
        if (produit != null && stock != null) {
            if (!repo.findStockByProduits(idProduit).equals(produit)){
                stock.setProduits(Collections.singleton(produit));
                repo.save(stock);
            }else{
                produitexists=true;
            }

        } else {
            System.out.println("NULL FOUND");
        }
    }
}
