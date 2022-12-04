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

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/reglement")
public class ReglementController extends ControllerGeneric<Reglement,Long> {
    @Autowired
    private ImpServiceReglement service;
    @Autowired
    ImpServiceReglement reglementServiceImp;

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
        return null;
    }
    @GetMapping("/{idFacture}")
    public List<Reglement> retrieveReglementByFacture(@PathVariable(value = "idFacture") Long idFacture) throws Exception {
        return reglementServiceImp.retrieveReglementByFacture(idFacture);
    }

    @PostMapping("/{idFacture}")
    public Reglement addReglement(@RequestBody Reglement reglement, @PathVariable(value = "idFacture") long idFacture) throws Exception {

        return reglementServiceImp.addReglement(reglement, idFacture);
    }

    @GetMapping("/{sd}/{ed}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable(value = "sd") String startDate, @PathVariable(value = "ed") String endDate) throws Exception {
        Date sd = java.sql.Date.valueOf(startDate);
        Date ed = java.sql.Date.valueOf(endDate);
        return reglementServiceImp.getChiffreAffaireEntreDeuxDate(sd, ed);
    }

    @GetMapping("/precent/{DateDeb}/{DateFin}")
    public float pourcentageRecouvrement(@PathVariable(value = "DateDeb") String DateDeb, @PathVariable(value = "DateFin") String DateFin) throws Exception {
        Date sd = java.sql.Date.valueOf(DateDeb);
        Date ed = java.sql.Date.valueOf(DateFin);
        return reglementServiceImp.pourcentageRecouvrement(sd, ed);
    }






}
