package com.example.tpnotee.controllers.DetailFacture;


import com.example.tpnotee.entities.CategorieProduit;
import com.example.tpnotee.entities.DetailFacture;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/detailfacture")
public class DetailFactureController extends ControllerGeneric<DetailFacture,Long> {


}
