package com.example.tpnotee.Repositories;

import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.GenericRepo;

import java.util.List;

public interface ReglementRepository extends GenericRepo<Reglement, Long> {
    List<Reglement> getReglementByFacture(Facture facture);
}