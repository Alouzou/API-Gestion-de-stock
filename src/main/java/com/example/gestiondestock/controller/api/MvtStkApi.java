package com.example.gestiondestock.controller.api;

import com.example.gestiondestock.dto.MvtStkDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/mvtstk")
public interface MvtStkApi {

    @GetMapping("/stockreel/{idArticle}")
    BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

    @GetMapping("/filter/article/{idArticle}")
    List<MvtStkDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

    @PostMapping("/entree")
    MvtStkDto entreeStock(@RequestBody MvtStkDto dto);

    @PostMapping("/sortie")
    MvtStkDto sortieStock(@RequestBody MvtStkDto dto);

    @PostMapping("/correctionpos")
    MvtStkDto correctionStockPos(@RequestBody MvtStkDto dto);

    @PostMapping("/correctionneg")
    MvtStkDto correctionStockNeg(@RequestBody MvtStkDto dto);
}
