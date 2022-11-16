package com.example.tpnotee.services.fournisseur;

import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class ImpServiceFournisseur extends ImplementationGeneric<Fournisseur,Long> implements InterfaceFournisseur {
    @Autowired
    GenericRepo<Fournisseur,Long> repo;
    @Autowired
    GenericRepo<SecteurActivite,Long> secteurrepo;

    @Override
    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
        try{
            Fournisseur fournisseur=repo.findById(fournisseurId).orElse(null);
            SecteurActivite secteurActivite=secteurrepo.findById(secteurActiviteId).orElse(null);
            if(fournisseur!=null && secteurActivite!=null){
                fournisseur.setSecteurActivite(Collections.singleton(secteurActivite));
                repo.save(fournisseur);
            }
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
    }
}
