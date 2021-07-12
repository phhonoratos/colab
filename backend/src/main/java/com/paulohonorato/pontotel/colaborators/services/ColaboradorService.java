package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public List<Colaborador> findAll() {
        return repository.findAll();
    }
    
}
