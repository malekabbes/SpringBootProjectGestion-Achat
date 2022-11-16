package com.example.tpnotee.services.SecteurActivite;

import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ImpServiceSecteurActivite extends ImplementationGeneric<SecteurActivite,Long> implements InterfaceSecteurActivite {
    @Autowired
    GenericRepo<SecteurActivite,Long> repo;

}
