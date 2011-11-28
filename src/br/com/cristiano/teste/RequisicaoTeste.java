package br.com.cristiano.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.cristiano.model.Cartao;
import br.com.cristiano.model.Resposta;

public class RequisicaoTeste {

	Resposta resposta = new Resposta();

	@Test
	public void deveSacarSeHouverLimite() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		Cartao cartao = new Cartao(1234567890987L, 20.0, df.parse("14/10"));
		cartao.setValor(15.0);
		if (cartao.getValor() <= cartao.getLimite()) {
			resposta.setCodigoRetorno(0);
		} else {
			resposta.setCodigoRetorno(1);
		}
		int esperado = 0;
		Assert.assertEquals(resposta.getCodigoRetorno(), esperado);
	}

	@Test
	public void naoDeveSacar() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		Cartao cartao = new Cartao(1234567890987L, 20.0, df.parse("14/10"));
		cartao.setValor(25.0);
		if (cartao.getValor() <= cartao.getLimite()) {
			resposta.setCodigoRetorno(0);
		} else {
			resposta.setCodigoRetorno(1);
		}
		int esperado = 1;
		Assert.assertEquals(resposta.getCodigoRetorno(), esperado);
	}

	@Test
	public void deveReduzirLimiteAoSacar() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		Cartao cartao = new Cartao(1234567890987L, 30.0, df.parse("05/12"));
		List<Double> valores = new ArrayList<Double>();
		valores.add(10.00);
		valores.add(15.00);
		valores.add(10.00);
		for (Double v : valores) {
			if (v <= cartao.getLimite()) {
				cartao.setLimite(cartao.getLimite() - v);
				resposta.setCodigoRetorno(0);
			} else {
				resposta.setCodigoRetorno(1);
			}
		}
		Assert.assertEquals(resposta.getCodigoRetorno(), 1);
	}
}
