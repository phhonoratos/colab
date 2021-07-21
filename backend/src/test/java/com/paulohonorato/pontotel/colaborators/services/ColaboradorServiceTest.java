package com.paulohonorato.pontotel.colaborators.services;

import com.paulohonorato.pontotel.colaborators.entities.Colaborador;
import com.paulohonorato.pontotel.colaborators.exceptions.RegraDeNegocioException;
import com.paulohonorato.pontotel.colaborators.repositories.ColaboradorRepository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ColaboradorServiceTest {
	
	@SpyBean
	ColaboradorService service;

	@MockBean
	ColaboradorRepository repository;

	public static Colaborador criarColaborador() {
		Colaborador colaborador = Colaborador.builder()
										.nome("Teste")
										.email("teste@email.com")
										.rua("Rua Teste")
										.numero("10")
										.complemento("Apto x")
										.cep("11122233")
										.municipio("São Paulo")
										.estado("São Paulo")
										.pais("Brasil")
										.cpf("14725836985")
										.pis("36925814725")
										.senha("senhasenha")
										.build();
		return colaborador;
	}

	@Test(expected = Test.None.class)
	public void devePersistirColaboradorNaBaseDeDados() {
		Colaborador colaborador = criarColaborador();
		Mockito.doNothing().when(service).cadastrar(Mockito.any());
		Mockito.when(repository.save(Mockito.any(Colaborador.class))).thenReturn(colaborador);
		Colaborador colab = service.cadastrar(new Colaborador());
		Assertions.assertThat(colab).isNotNull();
	}

	// @Test(expected = RegraDeNegocioException.class)
	// public void deveLancarErroENaoPersistirColaboradorNaBaseDeDados() {
	// 	Colaborador colaborador = criarColaborador();		
	// 	service.cadastrar(colaborador);
	// 	Colaborador colaborador2 = Colaborador.builder().email(colaborador.getEmail()).build();
	// 	service.cadastrar(colaborador2);
	// }

	// @Test(expected = Test.None.class)
	// public void deveAtualizarOColaboradorNaBaseDeDados() {
	// 	Colaborador colaborador = criarColaborador();
	// 	repository.save(colaborador);
	// 	colaborador.setNome("Teste Atualizacao");
	// 	service.atualizar(colaborador);
	// }

	// @Test(expected = RegraDeNegocioException.class)
	// public void deveLancarErroENaoAtualizarOColaboradorNaBaseDeDados() {
	// 	Colaborador colaborador = criarColaborador();
	// 	repository.save(colaborador);
	// 	colaborador.setNome("");
	// 	service.atualizar(colaborador);
	// }

	// @Test(expected = Test.None.class)
	// public void deveDeletarOColaboradorDaBaseDeDados() {
	// 	Colaborador colaborador = criarColaborador();
	// 	repository.save(colaborador);
	// 	service.deletar(colaborador);
	// }

	// @Test(expected = Test.None.class)
	// public void deveBuscarUmColaboradorPorID() {
	// 	Colaborador colaborador = criarColaborador();
	// 	repository.save(colaborador);
	// 	service.buscarPorId(colaborador.getId());
	// }

}
