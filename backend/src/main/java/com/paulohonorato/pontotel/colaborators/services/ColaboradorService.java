package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import java.util.List;
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
    
}
