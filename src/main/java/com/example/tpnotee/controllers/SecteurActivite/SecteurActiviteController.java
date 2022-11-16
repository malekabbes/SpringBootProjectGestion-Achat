package com.example.tpnotee.controllers.SecteurActivite;


import com.example.tpnotee.entities.Reglement;
import com.example.tpnotee.entities.SecteurActivite;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.Reglement.ImpServiceReglement;
import com.example.tpnotee.services.SecteurActivite.ImpServiceSecteurActivite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/secteuractivite")
public class SecteurActiviteController extends ControllerGeneric<Reglement,Long> {
    @Autowired
    private ImpServiceSecteurActivite service;
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateSecteurActivite(@RequestBody SecteurActivite sa, @PathVariable Long id) {
        try {
            SecteurActivite updateSecteuractivite= service.retrieve(id);
            if (updateSecteuractivite==null){
                return "Secteur d'activite not found with id :";
            }
            updateSecteuractivite.setCodeSecteurActivite(sa.getCodeSecteurActivite());
            updateSecteuractivite.setLibelleSecteurActivite(sa.getLibelleSecteurActivite());
            updateSecteuractivite.setFournisseurs(sa.getFournisseurs());
            service.update(updateSecteuractivite);

        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Secteur d'activite modifié ";
    }

}
