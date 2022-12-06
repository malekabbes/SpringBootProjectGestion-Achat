package com.example.tpnotee.controllers.Facture;


import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import com.example.tpnotee.services.facture.ImpServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/facture")
public class FactureController extends ControllerGeneric<Facture,Long> {
    @Autowired
    private ImpServiceFacture service;
    @PostMapping("/addAndAssign/{idFournisseur}")
    public Facture addFacture(@RequestBody Facture facture, @PathVariable(value = "idFournisseur") long idFournisseur) throws Exception{

        return service.addFacture(facture, idFournisseur);
    }

    @RequestMapping(value = "/facturebyfournisseur/{idFournisseur}", method = RequestMethod.GET)
    public List<Facture> findFactureByFournisseur(@PathVariable(value = "idFournisseur") Long idFournisseur) {
        try {
            return service.getFacturesByFournisseur(idFournisseur);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




}
