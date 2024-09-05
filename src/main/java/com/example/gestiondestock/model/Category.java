package com.example.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name ="category")
public class Category extends AbstractEntity{

    @Column(name = "category")
    private String code;

    @Column(name = "designation")
    private String designantion;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;


}
