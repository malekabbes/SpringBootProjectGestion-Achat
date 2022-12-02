package com.example.tpnotee.controllers.CategorieProduit;


import com.example.tpnotee.entities.CategorieFournisseur;
import com.example.tpnotee.entities.CategorieProduit;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catProduit")
public class CategorieProduitController extends ControllerGeneric<CategorieProduit,Long> {


}
