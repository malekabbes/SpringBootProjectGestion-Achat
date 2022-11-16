package com.example.tpnotee.services.Produit;

import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpServiceProduit extends ImplementationGeneric<Produit,Long> implements InterfaceProduit {
    @Autowired
    GenericRepo<Produit,Long> repo;

}
