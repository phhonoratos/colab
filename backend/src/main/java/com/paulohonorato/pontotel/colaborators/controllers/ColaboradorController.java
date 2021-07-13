package com.paulohonorato.pontotel.colaborators.controllers;

import java.util.List;

import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.services.ColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/colaborators")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll() {
        List<ColaboradorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ColaboradorDTO dto) {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome(dto.getNome());
        colaborador.setEmail(dto.getEmail());
        colaborador.setPais(dto.getPais());
        colaborador.setEstado(dto.getEstado());
        colaborador.setMunicipio(dto.getMunicipio());
        colaborador.setCep(dto.getCep());
        colaborador.setRua(dto.getRua());
        colaborador.setNumero(dto.getNumero());
        colaborador.setComplemento(dto.getComplemento());
        colaborador.setCpf(dto.getCpf());
        colaborador.setPis(dto.getPis());
        colaborador.setSenha(dto.getSenha());

        try {
            Colaborador colaboradorSalvo = service.cadastrar(colaborador);
            return new ResponseEntity(colaboradorSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}