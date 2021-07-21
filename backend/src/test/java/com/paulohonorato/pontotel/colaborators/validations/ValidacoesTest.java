package com.paulohonorato.pontotel.colaborators.validations;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ValidacoesTest {

	Validacoes validar;

    @MockBean
	ColaboradorRepository repository;

    @Before
    public void setUp() {
        validar = new Validacoes(repository);
    }

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
        Colaborador colaborador = criarColaborador();
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
        Mockito.when(repository.existsByCpf(Mockito.anyString())).thenReturn(false);
        Mockito.when(repository.existsByPis(Mockito.anyString())).thenReturn(false);
        validar.cadastro(colaborador);
    }

	@Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeEmailExistenteENaoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
        validar.cadastro(colaborador);
    }

	@Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeCpfExistenteENaoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        Mockito.when(repository.existsByCpf(Mockito.anyString())).thenReturn(true);
        validar.cadastro(colaborador);
    }

	@Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDePisExistenteENaoValidarOCadastro() {
        Colaborador colaborador = criarColaborador();
        Mockito.when(repository.existsByPis(Mockito.anyString())).thenReturn(true);
        validar.cadastro(colaborador);
    }

    @Test(expected = Test.None.class)
    public void deveValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setNome("Teste Atualizar");
        colaborador.setCep("22211133");
        colaborador.setNumero("8");
        colaborador.setCpf("11122233344");
        colaborador.setPis("99988877744");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeNomeInvalidoENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setNome("");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeCepInválidoENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setCep("22211");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeNumeroInvalidoENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setNumero("");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeCpfInvalidoENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setCpf("1112223");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDePisInvalidoENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setPis("99988877");
        colaborador.setSenha("senhasenha");
        validar.atualizacao(colaborador);
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveLancarExcecaoDeSenhaInvalidaENaoValidarAtualizacao() {
        Colaborador colaborador = criarColaborador();
        colaborador.setSenha("senha");
        validar.atualizacao(colaborador);
    }

}