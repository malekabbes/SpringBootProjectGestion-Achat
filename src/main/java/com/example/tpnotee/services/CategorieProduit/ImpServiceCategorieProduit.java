package com.example.tpnotee.services.CategorieProduit;

import com.example.tpnotee.entities.CategorieProduit;
import com.example.tpnotee.entities.DetailFacture;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class ImpServiceCategorieProduit extends ImplementationGeneric<CategorieProduit,Long> implements InterfaceCategorieProduit {
    @Autowired
    GenericRepo<CategorieProduit,Long> repo;

}
