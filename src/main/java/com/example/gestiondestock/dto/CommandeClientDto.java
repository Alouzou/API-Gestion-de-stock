package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Client;
import com.example.gestiondestock.model.LigneCommandeClient;
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
public class CommandeClientDto {

    private Integer id;
    private String code;


    private Instant dateCommande;


    private Client client;

    private List<LigneCommandeClient> commandeClients;

}
