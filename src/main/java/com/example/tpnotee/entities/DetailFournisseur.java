package com.example.tpnotee.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDetailFournisseur;
    @Temporal(TemporalType.DATE)
    public Date dateDebutCollaboration;
    public String adresse;
    public String matricule;
    @OneToOne
    public Fournisseur fournisseur;

}
