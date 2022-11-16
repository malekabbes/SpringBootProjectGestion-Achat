package com.example.tpnotee.services.fournisseur;

import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpServiceFournisseur extends ImplementationGeneric<Fournisseur,Long> implements InterfaceFournisseur {
    @Autowired
    GenericRepo<Fournisseur,Long> repo;

}
