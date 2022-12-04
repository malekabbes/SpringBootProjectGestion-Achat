package com.example.tpnotee.controllers.Operateur;


import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Operateur.ImpServiceOperateur;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/operateur")
public class OperateurController extends ControllerGeneric<Operateur,Long> {
    @Autowired
    private ImpServiceOperateur service;


}
