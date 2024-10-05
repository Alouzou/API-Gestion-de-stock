package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import com.example.gestiondestock.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(  "/")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @PostMapping( "/update/password")
    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping( "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping( "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping( "/")
    List<UtilisateurDto> findAll();

    @DeleteMapping(  "/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
