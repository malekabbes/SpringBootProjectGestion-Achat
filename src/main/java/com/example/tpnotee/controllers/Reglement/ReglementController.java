package com.example.tpnotee.controllers.Reglement;


import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import com.example.tpnotee.services.stock.ImpServiceStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reglement")
public class ReglementController extends ControllerGeneric<Reglement,Long> {
    @Autowired
    private ImpServiceReglement service;
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateReglement(@RequestBody Reglement r, @PathVariable Long id) {
        try {
            Reglement updateReglement= service.retrieve(id);
            if (updateReglement==null){
                return "Reglement not found with id :";
            }
            updateReglement.setDate(r.getDate());
            updateReglement.setMontantRestant(r.getMontantRestant());
            updateReglement.setMontantPaye(r.getMontantPaye());
            updateReglement.setFacture(r.getFacture());
            updateReglement.setPayee(r.isPayee());
            service.update(updateReglement);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Reglement modifié ";
    }

}
