package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;
import com.paulohonorato.pontotel.colaborators.dtos.ColaboradorDTO;
import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.ErroDeAutenticacao;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private BCryptPasswordEncoder encrypt;

    public List<ColaboradorDTO> findAll() {
        List<Colaborador> result = repository.findAll();
        return result.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
    }

    public Colaborador autenticar(String email, String senha) {
        Colaborador colaborador = repository.findByEmail(email);

        if(colaborador == null) {
            throw new ErroDeAutenticacao("Usuário não encontrado para o email informado.");
        }
        if(!encrypt.matches(senha, colaborador.getSenha())) {
            throw new ErroDeAutenticacao("Senha inválida");
            
        }

        return colaborador;
    }

    public Colaborador cadastrar(Colaborador colaborador) {
        validarCadastro(colaborador);
        return repository.save(colaborador);
    }

    public Colaborador atualizar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        ValidarAtualizacao(colaborador);
        return repository.save(colaborador);
    }

    public void deletar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        repository.delete(colaborador);
    }
    
    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void validarCadastro(Colaborador colaborador) {
        if(repository.existsByEmail(colaborador.getEmail())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email.");
        }
        if(repository.existsByCpf(colaborador.getCpf())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este cpf.");
        }
        if(repository.existsByPis(colaborador.getPis())) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este pis.");
        }
    }

    public void ValidarAtualizacao(Colaborador colaborador) {
        if(colaborador.getNome() == null || colaborador.getNome().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um NOME com pelo menos 4 letras.");
        }
        if(colaborador.getCep() == null || colaborador.getCep().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um CEP válido.");
        }
        if(colaborador.getNumero() == null || colaborador.getNumero().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um NÚMERO de endereço válido.");
        }
        if(colaborador.getCpf() == null || colaborador.getCpf().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um CPF válido.");
        }
        if(colaborador.getPis() == null || colaborador.getPis().trim().equals("")) {
            throw new RegraDeNegocioException("Informe um PIS válido.");
        }
        if(colaborador.getSenha() == null || colaborador.getSenha().trim().equals("")) {
            throw new RegraDeNegocioException("Informe uma SENHA.");
        }
    }

}
