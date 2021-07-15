package com.paulohonorato.pontotel.colaborators.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_colaborators")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador implements Serializable {
    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    private String nome;
    private String email;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String municipio;
    private String estado;
    private String pais;
    private String cpf;
    private String pis;

    @JsonIgnore
    private String senha;

    public static long getSerialverionuid() {
        return serialVerionUID;
    }

}
