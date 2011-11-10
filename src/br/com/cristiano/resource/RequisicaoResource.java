package br.com.cristiano.resource;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.cristiano.model.Requisicao;
import br.com.cristiano.model.Resposta;

@Path("/requisicao")
public class RequisicaoResource {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Requisicao novaRequisicao(
			@FormParam("numerocartao") long numeroCartao,
			@FormParam("dataexpiracao") String dataExpiracao,
			@FormParam("valor") double valor,
			@Context HttpServletResponse servletResponse
	) throws ParseException{
		Resposta resposta = new Resposta();
			SimpleDateFormat df = new SimpleDateFormat("MM/yy");
			Requisicao requisicao = new Requisicao(numeroCartao, df.parse(dataExpiracao), valor);
			if(valor<=requisicao.getLimite()){
				resposta.setCodigoRetorno(0);
			} else {
				resposta.setCodigoRetorno(1);
			}
			return requisicao;
	}
}
