package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/clients")
public interface ClientApi {

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistrer un client", description = "Cette méthode permet d'ajouter un client")
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "L'objet client est ajouté/modifié",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))

            )
    )
    ClientDto save(@RequestBody ClientDto clientDto);




    @Operation(
            summary = "Rechercher un client par ID",
            description = "Cette méthode permet de chercher un client par son ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le client a été trouvé dans la BDD", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))),
            @ApiResponse(responseCode = "404", description = "Aucun client n'existe dans la BDD avec l'ID fourni")
    })
    @GetMapping(
            value = "/{idClient}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ClientDto findById(@PathVariable("idClient") Integer id);



    @Operation(summary = "Renvoi la liste des clients", description = "Cette methode permet de chercher et renvoyer la liste des clients qui existent "
            + "dans la BDD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des clients / Une liste vide", content = @Content(mediaType = "application/json"))
    })
    @GetMapping(value =  "/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @Operation(summary = "Supprimer un client", description = "Cette méthode permet de supprimer un client par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le client a été supprimé")
    })
    @DeleteMapping(value = "/{idClient}")
    void delete(@PathVariable("idClient") Integer id);

}
