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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/produit")
public class ProduitController extends ControllerGeneric<Produit,Long> {
    @Autowired
    private ImpServiceProduit service;


    @GetMapping("/{idProduit}/{idStock}")
    public Produit addProduitToStock(@PathVariable(value = "idProduit") long idProduit, @PathVariable(value = "idStock") long idStock) throws Exception{
        service.assignProduitToStock(idProduit, idStock);
        return service.retrieve(idProduit);
    }

    @GetMapping("/retrieve/{id}")
    public Produit getProduit(@PathVariable(value = "id") long id) throws Exception {
        return service.retrieve(id);
    }

}
