package com.example.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name ="lignevente")
public class LigneVente extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente;

    @Column(name="quantite")
    private BigDecimal quantite;

    @Column(name="prixunitaire")
    private BigDecimal prixUnitaire;
}
