package com.example.tpnotee.services.stock;

import com.example.tpnotee.Repositories.StockRepository;
import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
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

    //    ┌───────────── second (0-59)
// │ ┌───────────── minute (0 - 59)
//│ │ ┌───────────── hour (0 - 23)
//│ │ │ ┌───────────── day of the month (1 - 31)
// │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
//            │ │ │ │ │ ┌───────────── day of the week (0 - 7)
// │ │ │ │ │ │          (or MON-SUN -- 0 or 7 is Sunday)     │ │ │ │ │ │
// * * * * * *
    @Scheduled(cron = "0 0 22 * * *", zone = "UTC+1")
    public void retrieveStatusStock() throws Exception {
        List<Stock> list=repo.findAll();
        List<String> liststockexpire=new ArrayList<>();
        String Stockdata = "" ;
        String stocktoreview = "";

        for (Stock s:list) {
            Stockdata = "\n Stock [ " + "\n"
                    + " idStock :" + s.getIdStock() +
                    " \n" +
                    " libelleStock : " + s.getLibelleStock() +
                    " \n" + " qte : " + s.getQte() + " " +
                    " \n qteMin " + s.getQteMin() + " \n] ";
            try {

                if (s.getQte() < s.getQteMin()) {
                    liststockexpire.add(Stockdata);
                    stocktoreview = stocktoreview.concat("List de Stock expirés" + liststockexpire.toString());

                }
            } catch (NullPointerException e) {
                e.getCause();

            }
        }
        Thread.sleep(2000);
        System.out.println(stocktoreview);
    }
}

