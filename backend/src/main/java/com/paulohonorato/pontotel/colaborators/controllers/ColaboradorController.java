package com.paulohonorato.pontotel.colaborators.controllers;

import java.util.List;

import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.services.ColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
