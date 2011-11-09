package br.com.cristiano.resource;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cristiano.model.Requisicao;
import br.com.cristiano.model.Resposta;

@Path("/requisicao")
public class RequisicaoResource {
	
	Requisicao requisicao = new Requisicao();
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Resposta novaRequisicao(
			@FormParam("numerocartao") long numeroCartao,
			@FormParam("dataexpiracao") Calendar dataExpiracao,
			@FormParam("valor") Double valor
	){
		Resposta resposta = new Resposta();
		if(valor<=requisicao.getLimite()){
			resposta.setCodigoRetorno(0);
		} else {
			resposta.setCodigoRetorno(1);
		}
		return resposta;
	}
}
