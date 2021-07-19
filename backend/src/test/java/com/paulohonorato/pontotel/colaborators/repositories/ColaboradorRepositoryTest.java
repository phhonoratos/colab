package com.paulohonorato.pontotel.colaborators.repositories;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ColaboradorRepositoryTest {

    @Autowired
    ColaboradorRepository repository;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {
        repository.deleteAll();
        Colaborador colaborador = Colaborador.builder().email("paulo@email.com").build();
        repository.save(colaborador);
        boolean result = repository.existsByEmail("paulo@email.com");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmailInformado() {
        boolean result = repository.existsByEmail("paulo@email.com");
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void deveVerificarAExistenciaDeUmCpf() {
        Colaborador colaborador = Colaborador.builder().cpf("32088949020").build();
        repository.save(colaborador);
        boolean result = repository.existsByCpf("32088949020");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComCpfInformado() {
        repository.deleteAll();
        boolean result = repository.existsByCpf("32088949020");
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void deveVerificarAExistenciaDeUmPis() {
        Colaborador colaborador = Colaborador.builder().pis("00709867409").build();
        repository.save(colaborador);
        boolean result = repository.existsByPis("00709867409");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComPisInformado() {
        repository.deleteAll();
        boolean result = repository.existsByPis("00709867409");
        Assertions.assertThat(result).isFalse();
    }
}
