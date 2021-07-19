package com.paulohonorato.pontotel.colaborators.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO implements Serializable {
    private static final long serialVerionUID = 1L;

    private Long id;    

    @NotBlank(message = "O campo NOME é obrigatório")
    @Size(min = 4, max = 200, message = "Mínimo 4 caracteres")
    private String nome;

    @NotBlank(message = "O campo EMAIL é obrigatório")
    @Column(unique = true)
    private String email;
    private String rua;
    
    @NotBlank(message = "O campo NÚMERO é obrigatório")
    private String numero;
    private String complemento;
    
    @NotBlank(message = "O campo CEP é obrigatório")
    private String cep;
    private String municipio;
    private String estado;
    private String pais;
    
    @NotBlank(message = "O campo CPF é obrigatório")
    @Column(unique = true)
    private String cpf;
    
    @NotBlank(message = "O campo PIS é obrigatório")
    @Column(unique = true)
    private String pis;

    @NotBlank(message = "O campo SENHA é obrigatório")
    private String senha;

    public ColaboradorDTO(Colaborador entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.rua = entity.getRua();
        this.numero = entity.getNumero();
        this.complemento = entity.getComplemento();
        this.cep = entity.getCep();
        this.municipio = entity.getMunicipio();
        this.estado = entity.getEstado();
        this.pais = entity.getPais();
        this.cpf = entity.getCpf();
        this.pis = entity.getPis();
        this.senha = entity.getSenha();
    }

    public static long getSerialverionuid() {
        return serialVerionUID;
    }

}
