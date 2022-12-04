package com.example.tpnotee.controllers.Fournisseur;


import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Operateur.ImpServiceOperateur;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fournisseur")
public class FournisseurController extends ControllerGeneric<Fournisseur,Long> {
    @Autowired
    private ImpServiceFournisseur service;


}
