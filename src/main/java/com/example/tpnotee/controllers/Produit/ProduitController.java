package com.example.tpnotee.controllers.Produit;


import com.example.tpnotee.entities.Produit;
import com.example.tpnotee.entities.Stock;
import com.example.tpnotee.generic.ControllerGeneric;
import com.example.tpnotee.services.stock.ImpServiceStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produit")
public class ProduitController extends ControllerGeneric<Produit,Long> {


}
