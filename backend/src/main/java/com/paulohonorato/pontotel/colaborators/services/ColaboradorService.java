package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public List<ColaboradorDTO> findAll() {
        List<Colaborador> result = repository.findAll();
        return result.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
    }

    public Colaborador cadastrar(Colaborador colaborador) {
        validarEmail(colaborador.getEmail());
        validarCpf(colaborador.getCpf());
        validarPis(colaborador.getPis());
        return repository.save(colaborador);
    }

    public Colaborador atualizar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        return repository.save(colaborador);
    }
    
    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email.");
        }
    }

    public void validarCpf(String cpf) {
        boolean existe = repository.existsByCpf(cpf);
        if(existe) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este cpf.");
        }
    }

    public void validarPis(String pis) {
        boolean existe = repository.existsByPis(pis);
        if(existe) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este pis.");
        }
    }

}
