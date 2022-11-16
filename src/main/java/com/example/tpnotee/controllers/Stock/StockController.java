package com.example.tpnotee.controllers.Stock;


import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.services.stock.ImpServiceStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    private ImpServiceStock service;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Stock save(@RequestBody Stock s) throws Exception {
        Stock StockResponse = (Stock) service.addStock(s);
        return StockResponse;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Stock> RetrieveAll() {
        try {
            return service.retrieveAllStocks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStock(@PathVariable Long id) {
        try {
            service.removeStock(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Stock supprimé";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateStock(@RequestBody Stock s,@PathVariable Long id) {
        try {
            Stock updateStock= service.retrieveStock(id);
            if (updateStock==null){
                return "Stock not found with id :";
            }
            updateStock.setQte(s.getQte());
            updateStock.setQteMin(s.getQteMin());
            updateStock.setLibelleStock(s.getLibelleStock());
            updateStock.setProduits(s.getProduits());
            service.updateStock(updateStock);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Stock modifié ";
    }
    @RequestMapping(value = "/assignproduittostock/{id}/{idstock}", method = RequestMethod.PUT)
    public String assignProduitToStock(@PathVariable Long id,@PathVariable Long idstock){
        try{
            service.assignProduitToStock(id,idstock);
            if (service.produitexists){
                return "Produit already exists in this stock";
            }
        }catch(Exception err){
            throw new RuntimeException(err);
        }
        return "Produit assigned to stock";
    }

}
