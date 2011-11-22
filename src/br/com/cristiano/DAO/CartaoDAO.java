package br.com.cristiano.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.cristiano.model.Cartao;

public class CartaoDAO {

	SimpleDateFormat df = new SimpleDateFormat("MM/yy");
	List<Cartao> cartoes = new ArrayList<Cartao>();

	private static final CartaoDAO cartaoDAO = new CartaoDAO();

	public static CartaoDAO getCartaoDAO() {
		return cartaoDAO;
	}

	private CartaoDAO() {
		try {
			Cartao cartao = new Cartao(12345678909876L, 30.00,
					df.parse("08/12"));
			cartoes.add(cartao);
			cartao = new Cartao(1234567890987L, 50.00, df.parse("12/14"));
			cartoes.add(cartao);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void adicionarCartao(Cartao cartao) {
		cartoes.add(cartao);
	}

	public Cartao getCartao(Long numeroCartao) {
		for (Cartao c : cartoes) {
			if (numeroCartao == c.getNumeroCartao()) {
				return c;
			}
		}
		return null;
	}

}
