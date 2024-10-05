package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/entreprises")
public interface EntrepriseApi {

    @PostMapping("")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping("/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping("/")
    List<EntrepriseDto> findAll();

    @DeleteMapping("/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
