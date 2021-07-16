package com.paulohonorato.pontotel.colaborators.repositories;

import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    boolean existsByEmail(String email);
    
    boolean existsByCpf(String cpf);

    boolean existsByPis(String pis);

    ColaboradorDTO findByEmail(String email);
    
}
