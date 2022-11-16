package com.example.tpnotee.services.Operateur;

import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ImpServiceOperateur extends ImplementationGeneric<Operateur,Long> implements InterfaceOperateur {
    @Autowired
    GenericRepo<Operateur,Long> repo;

}
