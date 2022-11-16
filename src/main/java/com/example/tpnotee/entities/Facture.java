package com.example.tpnotee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture ;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
    private boolean archivee;
    @OneToMany(mappedBy = "facture")
    private Set<Reglement> reglements;
    @OneToMany(mappedBy = "facture")
    private Set<DetailFacture> detailfacture;
    @ManyToOne(cascade =CascadeType.PERSIST)
    @JsonIgnore
    private Fournisseur fournisseur;

}
