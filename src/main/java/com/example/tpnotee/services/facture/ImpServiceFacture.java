package com.example.tpnotee.services.facture;

import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpServiceFacture extends ImplementationGeneric<Facture,Long> implements InterfaceFacture {
    @Autowired
    GenericRepo<Facture,Long> repo;

}
