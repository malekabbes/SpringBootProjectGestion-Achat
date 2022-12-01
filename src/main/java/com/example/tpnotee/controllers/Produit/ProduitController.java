package com.example.tpnotee.controllers.Produit;


import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Produit.ImpServiceProduit;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import com.example.tpnotee.services.stock.ImpServiceStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produit")
public class ProduitController extends ControllerGeneric<Produit,Long> {
    @Autowired
    private ImpServiceProduit service;
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateProduit(@RequestBody Produit p, @PathVariable Long id) {
        try {
            Produit updateProduit= service.retrieve(id);
            if (updateProduit==null){
                return "Produit not found with id :";
            }
            updateProduit.setCategorieProduit(p.getCategorieProduit());
            updateProduit.setCodeProduit(p.getCodeProduit());
            updateProduit.setLibelleProduit(p.getLibelleProduit());
            updateProduit.setPrix(p.getPrix());
            updateProduit.setDetailFacture(p.getDetailFacture());
            updateProduit.setStock(p.getStock());
            updateProduit.setDateCreation(p.getDateCreation());
            updateProduit.setDateDerniereModification(p.getDateDerniereModification());
            service.update(updateProduit);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Produit modifié";
    }

    @GetMapping("/{idProduit}/{idStock}")
    public Produit addProduitToStock(@PathVariable(value = "idProduit") long idProduit, @PathVariable(value = "idStock") long idStock) throws Exception{
        service.assignProduitToStock(idProduit, idStock);
        return service.retrieve(idProduit);
    }

}
