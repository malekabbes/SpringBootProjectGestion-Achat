package com.example.tpnotee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDetailFacture;
    public int qteCommandee;
    public float prixTotalDetail;
    public int pourcentageRemise;
    public float montantRemise;
    @ManyToOne(cascade =CascadeType.PERSIST)
    public Facture facture;
    @ManyToOne
    public Produit produit;
}
