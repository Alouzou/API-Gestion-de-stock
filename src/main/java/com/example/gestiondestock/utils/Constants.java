package com.example.gestiondestock.utils;

public interface Constants {
    String APP_ROOT = "gestiondestock/v1";

    String COMMANDE_FOURNISSEUR_ENDPOINT =  "/";
    String CREATE_COMMANDE_FOURNISSEUR_ENDPOINT = "/";
    String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT =  "/{idCommandeFournisseur}";
    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT =  "/filter/{codeCommandeFournisseur}";
    String FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT =  "/";
    String DELETE_COMMANDE_FOURNISSEUR_ENDPOINT =  "/{idCommandeFournisseur}";
}
