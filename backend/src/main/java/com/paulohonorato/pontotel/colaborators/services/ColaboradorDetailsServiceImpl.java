package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.pontotel.colaborators.security.ColaboradorSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ColaboradorRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Colaborador colaborador = repository.findByEmail(email);
        if(colaborador == null) {
            throw new UsernameNotFoundException(email);
        }
        return new ColaboradorSS(colaborador.getId(), colaborador.getEmail(), colaborador.getSenha());
    }
    
}
