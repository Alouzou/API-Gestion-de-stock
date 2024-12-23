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

    @PatchMapping("/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande,
                                                         @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping( "/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
                                                             @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                             @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping( "/update/client/{idCommande}/{idClient}")
    ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Integer idCommande,
                                                   @PathVariable("idClient") Integer idClient);

    @PatchMapping( "/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                    @PathVariable("idArticle") Integer idArticle);

    @DeleteMapping("/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(  "/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping( "/filter/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(  "/")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @GetMapping("/lignesCommande/{idCommande}")
    ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(@PathVariable("idCommande") Integer idCommande);

    @DeleteMapping(  "/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
