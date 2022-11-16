package com.example.tpnotee.services.fournisseur;

import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.Igeneric;

public interface InterfaceFournisseur extends Igeneric<Fournisseur,Long> {
    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) ;
}
