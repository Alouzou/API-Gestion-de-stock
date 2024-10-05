package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ArticleDto;
import com.example.gestiondestock.dto.LigneCommandeClientDto;
import com.example.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.example.gestiondestock.dto.LigneVenteDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/articles")
public interface ArticleApi {





    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistrer un article", description = "Cette méthode permet d'enregistrer ou modifier un article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet article est crée / modifié", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "400", description = "L'objet article n'est pas valide")
    })

    ArticleDto save(@RequestBody ArticleDto dto);


    @Operation(summary = "Rechercher un article par ID", description = "Cette méthode permet de chercher un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a été trouvé dans la BDD", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(value =  "/{idArticle}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);


    @Operation(summary = "Rechercher un article par CODE", description = "Cette méthode permet de chercher un article par son code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a été trouvé dans la BDD", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    @GetMapping(value =  "/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @Operation(summary = "Renvoi la liste des articles", description = "Cette methode permet de chercher et renvoyer la liste des articles qui existent "
            + "dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des article / Une liste vide", content = @Content(mediaType = "application/json"))
    })
    @GetMapping(value =  "/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    @Operation(summary = "Supprimer un article", description = "Cette méthode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a été supprimé")
    })
    @DeleteMapping(value = "/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}
