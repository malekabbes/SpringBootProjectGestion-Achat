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
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idFournisseur;
    public String codeFournisseur;
    public String libelleFournisseur;
    @Enumerated(EnumType.ORDINAL)
    public CategorieFournisseur categorieFournisseur;
    @OneToMany(mappedBy = "fournisseur")
    public Set<Facture> facture;
    @ManyToMany(mappedBy = "fournisseurs")
    public Set<SecteurActivite> secteurActivite;
    @OneToOne(mappedBy = "fournisseur")
    public DetailFournisseur detailFournisseur;
}
