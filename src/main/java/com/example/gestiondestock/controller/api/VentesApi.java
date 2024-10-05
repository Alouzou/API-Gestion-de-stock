package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.VentesDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/ventes")
public interface VentesApi {
    @PostMapping( "/")
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping( "/{idVente}")
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping( "/{codeVente}")
    VentesDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(  "/")
    List<VentesDto> findAll();

    @DeleteMapping("/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
