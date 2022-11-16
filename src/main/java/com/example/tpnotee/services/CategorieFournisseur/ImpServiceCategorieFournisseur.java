package com.example.tpnotee.services.CategorieFournisseur;

import com.example.tpnotee.entities.CategorieFournisseur;
import com.example.tpnotee.entities.CategorieProduit;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class ImpServiceCategorieFournisseur extends ImplementationGeneric<CategorieFournisseur,Long> implements InterfaceCategorieFournisseur {
    @Autowired
    GenericRepo<CategorieFournisseur,Long> repo;

}
