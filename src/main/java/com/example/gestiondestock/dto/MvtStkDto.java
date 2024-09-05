package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;
    private Instant dateMvt;

    private BigDecimal quantite;


    private ArticleDto article;

    private TypeMvtStk typeMvt;
}
