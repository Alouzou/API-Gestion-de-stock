package com.example.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

//    @CreatedDate
    @Column(name = "creationDate")
    @JsonIgnore
    private Instant creationDate;

//    @LastModifiedDate
    @Column(name = "lastUpdateDate")
    @JsonIgnore
    private Instant lastUpdateDate;

    @PrePersist
    void prePersist() {
        creationDate = Instant.now();
    }

    @PreUpdate
    void preUpdate(){
        lastUpdateDate = Instant.now();
    }

}
