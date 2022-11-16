package com.example.tpnotee.controllers.Reglement;


import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.ControllerGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produit")
public class ReglementController extends ControllerGeneric<Reglement,Long> {


}
