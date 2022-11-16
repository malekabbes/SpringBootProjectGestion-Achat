package com.example.tpnotee.services.DetailFournisseur;

import com.example.tpnotee.entities.DetailFournisseur;
import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ImpServiceDetailfournisseur extends ImplementationGeneric<DetailFournisseur,Long> implements InterfaceDetailFournisseur {
    @Autowired
    GenericRepo<DetailFournisseur,Long> repo;

}
