package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private Integer id;
    private String roleName;

    private UtilisateurDto utilisateur;
}
