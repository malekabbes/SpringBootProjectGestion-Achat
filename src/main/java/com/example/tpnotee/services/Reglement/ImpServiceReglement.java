package com.example.tpnotee.services.Reglement;

import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpServiceReglement extends ImplementationGeneric<Reglement,Long> implements InterfaceReglement {
    @Autowired
    GenericRepo<Reglement,Long> repo;

}
