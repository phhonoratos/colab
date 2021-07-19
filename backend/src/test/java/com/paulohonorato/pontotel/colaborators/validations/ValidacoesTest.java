package com.paulohonorato.pontotel.colaborators.validations;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ValidacoesTest {
	
    @Autowired
	Validacoes validar;

    @Autowired
	ColaboradorRepository repository;

    public static Colaborador criarColaborador() {
        Colaborador colaborador = Colaborador.builder()
                                    .nome("Teste")
                                    .email("teste@email.com")
                                    .rua("Rua Teste")
                                    .numero("10")
                                    .complemento("Casa X")
                                    .cep("11122233")
                                    .municipio("São Paulo")
                                    .estado("São Paulo")
                                    .pais("Brasil")
                                    .cpf("12345678910")
                                    .pis("10123456789")
                                    .senha("senhasenha")
                                    .build();
        return colaborador;
    }

	@Test(expected = Test.None.class)
    public void deveValidarOCadastro() {
        repository.deleteAll();
        Colaborador colaborador = criarColaborador();
        validar.cadastro(colaborador);
    }

	@Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeEmailExistenteAoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        validar.cadastro(Colaborador.builder().email("teste@email.com").build());
    }

	@Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeCpfExistenteAoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        Colaborador colaborador2 = Colaborador.builder()
                                    .cpf("12345678910").build();
        validar.cadastro(colaborador2);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDePisExistenteAoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        Colaborador colaborador2 = Colaborador.builder()
                                    .pis("10123456789").build();
        validar.cadastro(colaborador2);
    }

    @Test(expected = Test.None.class)
    public void deveValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setNome("Teste Atualizar");
        colaborador.setCep("22211133");
        colaborador.setNumero("8");
        colaborador.setCpf("11122233344");
        colaborador.setPis("99988877744");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeNomeInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setNome("");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeCepInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setCep("11122");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeNumeroInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setNumero("");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeCpfInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setCpf("123456789");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDePisInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setPis("123456789");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarErroDeSenhaInvalidoAoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        repository.save(colaborador);
        colaborador.setSenha("123456");
        validar.atualizacao(colaborador);
    }
}