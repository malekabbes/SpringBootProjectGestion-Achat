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
public class Reglement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReglement;
    private float montantPaye;
    private float MontantRestant;
    private boolean payee;
    @Temporal(TemporalType.DATE)
    private Date Date;

    @ManyToOne(cascade =CascadeType.PERSIST)
    private Facture facture;
}
