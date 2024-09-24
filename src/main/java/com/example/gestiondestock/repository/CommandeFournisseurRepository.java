package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.CommandeClient;
import com.example.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
    List<CommandeClient> findAllByFournisseurId(Integer id);

}
