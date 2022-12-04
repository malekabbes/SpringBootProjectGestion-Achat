package com.example.tpnotee.Repositories;

import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.GenericRepo;

import java.util.List;

public interface FactureRepository extends GenericRepo<Facture, Long> {
    List<Facture> findFactureByFournisseur(Fournisseur fournisseur);
    //Number countFactureByReglements(Reglement reglement);
    List<Reglement> getFactureByReglements(Reglement reglement);

}