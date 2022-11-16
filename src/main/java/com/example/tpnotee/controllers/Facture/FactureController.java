package com.example.tpnotee.controllers.Facture;


import com.example.tpnotee.entities.Facture;
import com.example.tpnotee.generic.ControllerGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/facture")
public class FactureController extends ControllerGeneric<Facture,Long> {


}
