package com.example.tpnotee.services.facture;

import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.Igeneric;

import java.util.List;

public interface InterfaceFacture extends Igeneric<Facture,Long> {
    List<Facture> getFacturesByFournisseur(Long idFournisseur);
}
