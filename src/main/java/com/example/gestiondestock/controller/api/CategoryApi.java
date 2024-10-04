package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ArticleDto;
import com.example.gestiondestock.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistrer une catégorie", description = "Cette méthode permet d'enregistrer ou modifier une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet catégorie est crée / modifié", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
            @ApiResponse(responseCode = "400", description = "L'objet catégorie n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);


    @GetMapping(value = "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une categorie par ID", description = "Cette methode permet de chercher une categorie par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été trouvé dans la BDD", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
            @ApiResponse(responseCode = "404", description = "Aucune catégorie n'existe dans la BDD avec l'ID fourni")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer id);


    @GetMapping(value = APP_ROOT + "/categories/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une categorie par CODE", description = "Cette methode permet de chercher une categorie par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'article a ete trouve dans la BDD", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class))),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String code);


    @GetMapping(APP_ROOT + "/categories")
    @Operation(summary = "Renvoi la liste des categories", description = "Cette methode permet de chercher et renvoyer la liste des categories qui existent")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "La liste des catégories / Une liste vide", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryDto.class)))
    )
    List<CategoryDto> findAll();


    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @Operation(summary = "Supprimer un article", description = "Cette méthode permet de supprimer une categorie par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La categorie a été supprimée")
    })
    void delete(@PathVariable("idCategory") Integer id);

}
