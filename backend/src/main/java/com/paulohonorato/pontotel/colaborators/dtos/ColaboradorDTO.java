package com.paulohonorato.pontotel.colaborators.dtos;

import java.io.Serializable;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

public class ColaboradorDTO implements Serializable {
    private static final long serialVerionUID = 1L;

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
    private String senha;

    public ColaboradorDTO() {
    }

    public ColaboradorDTO(Long id, String nome, String email, String rua, String numero, String complemento, String cep,
            String municipio, String estado, String pais, String cpf, String pis, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
        this.cpf = cpf;
        this.pis = pis;
        this.senha = senha;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ColaboradorDTO other = (ColaboradorDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ColaboradorDTO [id=" + id + "]";
    }

    
    
}
