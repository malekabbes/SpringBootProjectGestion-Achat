package com.example.tpnotee.services.Operateur;

import com.example.tpnotee.entities.*;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import com.example.tpnotee.services.facture.ImpServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ImpServiceOperateur extends ImplementationGeneric<Operateur,Long> implements InterfaceOperateur {
    @Autowired
    GenericRepo<Operateur,Long> repo;

    ImpServiceFacture factureServiceImp;
    @Override
    @Transactional
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) throws Exception {
        Operateur operateur = this.retrieve(idOperateur);
        Facture facture = factureServiceImp.retrieve(idFacture);
        Set<Facture> factures = new HashSet<>();
        factures.add(facture);
        operateur.setFacture(factures);
        operateur.getFacture().add(facture);
    }
}
