package com.paulohonorato.pontotel.colaborators.repositories;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    
}
