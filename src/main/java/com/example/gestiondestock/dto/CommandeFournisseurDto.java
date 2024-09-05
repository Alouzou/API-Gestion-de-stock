package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Fournisseur;
import com.example.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;
    private String code;

    private Instant dateCommande;


    private Fournisseur fournisseur;

    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

}
