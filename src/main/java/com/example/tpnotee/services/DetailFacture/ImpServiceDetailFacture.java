package com.example.tpnotee.services.DetailFacture;

import com.example.tpnotee.entities.DetailFacture;
import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service


public class ImpServiceDetailFacture extends ImplementationGeneric<DetailFacture,Long> implements InterfaceDetailFacture {
    @Autowired
    GenericRepo<DetailFacture,Long> repo;

}
