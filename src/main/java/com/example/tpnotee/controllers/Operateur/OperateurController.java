package com.example.tpnotee.controllers.Operateur;


import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Operateur.ImpServiceOperateur;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/facture")
public class OperateurController extends ControllerGeneric<Operateur,Long> {
    @Autowired
    private ImpServiceOperateur service;
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateOperateur(@RequestBody Operateur o, @PathVariable Long id) {
        try {
            Operateur updateoperateur= service.retrieve(id);
            if (updateoperateur==null){
                return "Operateur not found with id :";
            }
            updateoperateur.setFacture(o.getFacture());
            updateoperateur.setNom(o.getNom());
            updateoperateur.setPrenom(o.getPrenom());
            updateoperateur.setPassword(o.getPassword());
            service.update(updateoperateur);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Operateur modifié ";
    }

}
