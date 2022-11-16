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
public class SecteurActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idSecteurActivite;
    public String codeSecteurActivite;
    public String libelleSecteurActivite;
    @ManyToMany
    public Set<Fournisseur> fournisseurs;
}
