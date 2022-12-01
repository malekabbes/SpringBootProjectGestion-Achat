package com.example.tpnotee.services.Produit;

import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.Igeneric;

public interface InterfaceProduit extends Igeneric<Produit,Long> {
    void assignProduitToStock(Long idProduit, Long idStock) throws Exception;

}
