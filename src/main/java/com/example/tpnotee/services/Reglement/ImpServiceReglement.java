package com.example.tpnotee.services.Reglement;

import com.example.tpnotee.Repositories.ReglementRepository;
import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import com.example.tpnotee.services.facture.ImpServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class ImpServiceReglement extends ImplementationGeneric<Reglement,Long> implements InterfaceReglement {
    @Autowired
    ReglementRepository repo;

    ImpServiceFacture factureServiceImp;

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) throws Exception {
        Facture facture = factureServiceImp.retrieve(idFacture);
        return repo.getReglementByFacture(facture);
    }
    @Override
    public Reglement addReglement(Reglement r, Long idFacture) throws Exception{
        List<Reglement> reglements = new ArrayList<>();
        reglements = this.retrieveReglementByFacture(idFacture);
        Facture facture = factureServiceImp.retrieve(idFacture);
        float somme = 0f;
        float rest = 0f;
        float Mfacture = facture.getMontantFacture();
        for (Reglement reglement : reglements) {
            somme += reglement.getMontantRestant();

        }
        rest = Mfacture - somme;
        if (r.getMontantRestant() <= rest) {
            r.setFacture(facture);
            this.save(r);
            return r;
        } else
            return null;

    }
    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) throws Exception {
        List<Reglement> reglements = this.findAll();
        float chiffreAffaire = 0;

        for (Reglement reglement : reglements) {
            try {
                if (reglement.getDate().after(startDate) && reglement.getDate().before(endDate) && !reglement.getFacture().isArchivee()) {
                    chiffreAffaire += reglement.getMontantRestant();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return chiffreAffaire;
    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) throws Exception{
        List<Facture> factures = factureServiceImp.findAll();
        float totalReg = 0f;
        float totalFac = 0f;
        float percentage = 0f;
        for (Facture facture : factures) {
            if (facture.getDateCreationFacture().after(startDate) && facture.getDateCreationFacture().before(endDate) && !facture.isArchivee()) {
                totalFac += facture.getMontantFacture();
                Set<Reglement> r = facture.getReglements();
                for (Reglement reg : r) {
                    totalReg += reg.getMontantRestant();
                }
            }
        }
        percentage = (totalReg / totalFac) * 100;
        return percentage;
    }
}


