package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/fournisseurs")
public interface FournisseurApi {

    @PostMapping("/")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping("/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping("/")
    List<FournisseurDto> findAll();

    @DeleteMapping("/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);

}
