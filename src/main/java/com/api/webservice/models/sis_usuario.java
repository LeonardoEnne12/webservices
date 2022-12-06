package com.api.webservice.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "sis_usuario")
public class sis_usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @Column(length = 50)
    private String usuario;
    
    @Column(length = 100)
    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 100)
    private String senha;

    @Temporal(TemporalType.DATE)
    private Date datacriacao;

    @Temporal(TemporalType.DATE)
    private Date dataalteracao;

    @OneToMany(targetEntity = sis_grupo.class, cascade = CascadeType.ALL)
    private List<sis_grupo> grupos;

}
