package com.example.tpnotee.controllers.Fournisseur;


import com.example.tpnotee.entities.Fournisseur;
import com.example.tpnotee.entities.Operateur;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Operateur.ImpServiceOperateur;
import com.example.tpnotee.services.fournisseur.ImpServiceFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fournisseur")
public class FournisseurController extends ControllerGeneric<Operateur,Long> {
    @Autowired
    private ImpServiceFournisseur service;
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateFournisseur(@RequestBody Fournisseur f, @PathVariable Long id) {
        try {
            Fournisseur updatefournisseur= service.retrieve(id);
            if (updatefournisseur==null){
                return "Fournisseur not found with id :";
            }
            updatefournisseur.setCategorieFournisseur(f.getCategorieFournisseur());
            updatefournisseur.setFacture(f.getFacture());
            updatefournisseur.setCodeFournisseur(f.getCodeFournisseur());
            updatefournisseur.setDetailFournisseur(f.getDetailFournisseur());
            updatefournisseur.setLibelleFournisseur(f.getLibelleFournisseur());
            updatefournisseur.setSecteurActivite(f.getSecteurActivite());
            service.update(updatefournisseur);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Fournisseur modifié ";
    }

}
