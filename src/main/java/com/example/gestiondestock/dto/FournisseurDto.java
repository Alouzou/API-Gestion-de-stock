package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Adresse;
import com.example.gestiondestock.model.CommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;
    private String nom;
    private String prenom;

    private Adresse adresse;


    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeFournisseur> commandeFournisseurs;

}
