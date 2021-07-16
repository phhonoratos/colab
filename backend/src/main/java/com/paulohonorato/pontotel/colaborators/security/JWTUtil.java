package com.paulohonorato.pontotel.colaborators.security;

import java.util.Date;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
    
    @Autowired
    private ColaboradorRepository repository;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String generateToken(String username) {        
        Colaborador colab = repository.findByEmail(username);
        return Jwts.builder().setId(colab.getId().toString())
        .setSubject(username) // setSubject(args) é para setar o usuário
        // .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(SignatureAlgorithm.HS512, secret.getBytes())
        .compact();
    }
    
}
