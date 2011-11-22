package br.com.cristiano.resource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.cristiano.DAO.CartaoDAO;
import br.com.cristiano.model.Cartao;
import br.com.cristiano.model.Resposta;

@Path("/requisicao")
public class RequisicaoResource {

	Resposta resposta = new Resposta();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Resposta novaRequisicao(@FormParam("numerocartao") long numeroCartao,
			@FormParam("dataexpiracao") String dataExpiracao,
			@FormParam("valor") double valor) throws ParseException,
			IOException {
		Cartao cartao = CartaoDAO.getCartaoDAO().getCartao(numeroCartao);
		if (valor <= cartao.getLimite()) {
			cartao.setLimite(cartao.getLimite() - valor);
			resposta.setCodigoRetorno(0);
		} else {
			resposta.setCodigoRetorno(1);
		}
		return resposta;
	}

}
