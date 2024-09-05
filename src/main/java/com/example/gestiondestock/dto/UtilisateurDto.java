package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Adresse;
import com.example.gestiondestock.model.Entreprise;
import com.example.gestiondestock.model.Roles;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;
    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;
}
