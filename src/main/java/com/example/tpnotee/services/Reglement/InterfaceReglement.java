package com.example.tpnotee.services.Reglement;

import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.Igeneric;

import java.util.Date;
import java.util.List;

public interface InterfaceReglement extends Igeneric<Reglement,Long> {
    public List<Reglement> retrieveReglementByFacture(Long idFacture) throws Exception;
    Reglement addReglement(Reglement r, Long idFacture) throws Exception;
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) throws Exception;

    float pourcentageRecouvrement(Date startDate, Date endDate) throws Exception;

}
