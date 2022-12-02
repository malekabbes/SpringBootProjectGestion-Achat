package com.example.tpnotee.services.Produit;

import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import com.example.tpnotee.services.stock.ImpServiceStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpServiceProduit extends ImplementationGeneric<Produit,Long> implements InterfaceProduit {
    @Autowired
    ImpServiceStock stockServiceImp;

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) throws Exception {
        Produit produit = this.retrieve(idProduit);
        Stock stock = stockServiceImp.retrieveStock(idStock);
        produit.setStock(stock);
        this.update(produit);
    }
}
