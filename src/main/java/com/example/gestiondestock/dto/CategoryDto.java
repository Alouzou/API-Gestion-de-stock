package com.example.gestiondestock.dto;

import com.example.gestiondestock.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;


    private String designantion;


    private List<Article> articles;
}
