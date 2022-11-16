package com.example.tpnotee.services.facture;

import com.example.tpnotee.Repositories.FactureRepository;
import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.GenericRepo;
import com.example.tpnotee.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpServiceFacture extends ImplementationGeneric<Facture,Long> implements InterfaceFacture {
    @Autowired
    FactureRepository repo;

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
}
