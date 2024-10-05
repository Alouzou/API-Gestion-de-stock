package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.CommandeClientDto;
import com.example.gestiondestock.dto.LigneCommandeClientDto;
import com.example.gestiondestock.model.EtatCommande;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(value = APP_ROOT + "/commandesclients")
public interface CommandeClientApi {

    @PostMapping( "")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    ResponseEntity<CommandeClientDto> updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

    ResponseEntity<CommandeClientDto> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

    ResponseEntity<CommandeClientDto> updateClient(Integer idCommande, Integer idClient);

    ResponseEntity<CommandeClientDto> updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);

    // Delete article ==> delete LigneCommandeClient
    ResponseEntity<CommandeClientDto> deleteArticle(Integer idCommande, Integer idLigneCommande);

    @GetMapping(  "/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping( "/filter/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(  "/")
    ResponseEntity<List<CommandeClientDto>> findAll();

    ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);
    @DeleteMapping(  "/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
