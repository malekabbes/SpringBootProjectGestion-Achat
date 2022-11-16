package com.example.tpnotee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategorieProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idCategorieProduit;
    public String codeProduit;
    public String libelleCategorieProduit;
    @OneToMany(mappedBy = "categorieProduit")
    public Set<Produit> produits;
}
