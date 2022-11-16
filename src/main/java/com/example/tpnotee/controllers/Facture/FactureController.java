package com.example.tpnotee.controllers.Facture;


import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import com.example.tpnotee.services.facture.ImpServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/facture")
public class FactureController extends ControllerGeneric<Facture,Long> {
    @Autowired
    private ImpServiceFacture service;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateFacture(@RequestBody Facture f, @PathVariable Long id) {
        try {
            Facture updatefacture= service.retrieve(id);
            if (updatefacture==null){
                return "Facture not found with id :";
            }
            updatefacture.setMontantFacture(f.getMontantFacture());
            updatefacture.setArchivee(f.isArchivee());
            updatefacture.setMontantRemise(f.getMontantRemise());
            updatefacture.setDateCreationFacture(f.getDateCreationFacture());
            updatefacture.setDateDerniereModification(f.getDateDerniereModification());
            updatefacture.setReglements(f.getReglements());
            updatefacture.setDetailfacture(f.getDetailfacture());
            updatefacture.setFournisseur(f.getFournisseur());
            service.update(updatefacture);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Facture modifié ";
    }
}
