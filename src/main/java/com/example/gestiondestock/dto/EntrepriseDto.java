package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Adresse;
import com.example.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;
    private String nom;


    private String description;

    private Adresse adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    private List<Utilisateur> utilisateurs;
}
