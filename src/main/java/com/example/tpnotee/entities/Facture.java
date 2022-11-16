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
    public Long idFacture;
    public float montantRemise;
    public float montantFacture;
    @Temporal(TemporalType.DATE)
    public Date dateCreationFacture ;
    @Temporal(TemporalType.DATE)
    public Date dateDerniereModification;
    public boolean archivee;
    @OneToMany(mappedBy = "facture")
    public Set<Reglement> reglements;
    @OneToMany(mappedBy = "facture")
    public Set<DetailFacture> detailfacture;
    @ManyToOne(cascade =CascadeType.PERSIST)
    @JsonIgnore
    public Fournisseur fournisseur;

}
