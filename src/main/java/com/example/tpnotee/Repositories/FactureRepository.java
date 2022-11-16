package com.example.tpnotee.Repositories;

import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.generic.GenericRepo;

import java.util.List;

public interface FactureRepository extends GenericRepo<Facture, Long> {
    List<Facture> findFactureByFournisseur(Long id);
}