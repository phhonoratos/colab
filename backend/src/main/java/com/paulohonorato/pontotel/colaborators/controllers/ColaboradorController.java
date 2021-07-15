package com.paulohonorato.pontotel.colaborators.controllers;

import java.util.List;
import java.util.Optional;

import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.ErroDeAutenticacao;
import com.paulohonorato.pontotel.colaborators.services.ColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/colaborators")
public class ColaboradorController {

    @Autowired
    private BCryptPasswordEncoder encrypt;
    
    @Autowired
    private ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll() {
        List<ColaboradorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity buscaPorId(@PathVariable("id") Long idColaborador) {
        Optional<Colaborador> colaborador = service.buscarPorId(idColaborador);
        return ResponseEntity.ok(colaborador);
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody ColaboradorDTO dto) {
        try {
            Colaborador colaboradorAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
            return ResponseEntity.ok(colaboradorAutenticado);
        } catch (ErroDeAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ColaboradorDTO dto) {
        Colaborador colaborador = converterToEntity(dto);

        try {
            Colaborador colaboradorSalvo = service.cadastrar(colaborador);
            return new ResponseEntity(colaboradorSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ColaboradorDTO dto) {
        return service.buscarPorId(id).map(entity -> {
            try {
                Colaborador colaborador = converterToEntity(dto);
                colaborador.setId(entity.getId());
                service.atualizar(colaborador);
                return ResponseEntity.ok(colaborador);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }).orElseGet(() -> new ResponseEntity("Colaborador não encontrado na base de dados.", HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(entity -> {
            service.deletar(entity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity("Colaborador não encontrado na base de dados.", HttpStatus.BAD_REQUEST));
    }

    public Colaborador converterToEntity(ColaboradorDTO dto) {
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
        colaborador.setSenha(encrypt.encode(dto.getSenha()));

        return colaborador;
    }
    
}