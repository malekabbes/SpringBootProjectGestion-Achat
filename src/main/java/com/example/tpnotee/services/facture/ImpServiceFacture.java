package com.example.tpnotee.services.facture;

import com.example.tpnotee.Repositories.FactureRepository;
import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImpServiceFacture extends ImplementationGeneric<Facture,Long> implements InterfaceFacture {
    @Autowired
    FactureRepository repo;
    @Autowired
    ImpServiceFournisseur fournisseurServiceImp;

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        try{
           List<Facture> list=new ArrayList<Facture>();
            list=repo.findFactureByFournisseur(idFournisseur);
            return list;
        } catch(Exception err){
            throw new RuntimeException(err);
        }

    }

    @Override
    @Transactional
    public Facture addFacture(Facture f, Long idFournisseur) throws Exception {
        Fournisseur fournisseur = fournisseurServiceImp.retrieve(idFournisseur);
        f.setFournisseur(fournisseur);
        this.save(f);
        return f;
    }
}
