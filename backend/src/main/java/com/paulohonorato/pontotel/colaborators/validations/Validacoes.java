package com.paulohonorato.pontotel.colaborators.validations;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class Validacoes {

    @Autowired
    ColaboradorRepository repository;
    
    public void cadastro(Colaborador colaborador) {
        if(repository.existsByEmail(colaborador.getEmail())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email.");
        }
        if(repository.existsByCpf(colaborador.getCpf())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este cpf.");
        }
        if(repository.existsByPis(colaborador.getPis())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este pis.");
        }
    }

    public void atualizacao(Colaborador colaborador) {
        if(colaborador.getNome() == null || colaborador.getNome().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um NOME com pelo menos 4 letras.");
        }
        if(colaborador.getCep() == null || colaborador.getCep().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um CEP válido.");
        }
        if(colaborador.getNumero() == null || colaborador.getNumero().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um NÚMERO de endereço válido.");
        }
        if(colaborador.getCpf() == null || colaborador.getCpf().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um CPF válido.");
        }
        if(colaborador.getPis() == null || colaborador.getPis().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um PIS válido.");
        }
        if(colaborador.getSenha() == null || colaborador.getSenha().trim().equals("")) {
            throw new RegraDeNegocioException("Informe uma SENHA.");
        }
    }

}
