package br.com.cristiano.resource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.cristiano.DAO.CartaoDAO;
import br.com.cristiano.model.Cartao;

@Path("/cartao")
public class CartaoResource {


	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Cartao> listCartoes() throws ParseException {
		return CartaoDAO.getCartaoDAO().getCartoes();
	}

	@Path("{numeroCartao}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Cartao getCartao(@PathParam("numeroCartao") Long numeroCartao, @Context HttpServletResponse servletResponse)
			throws ParseException, IOException {
		Cartao cartao = CartaoDAO.getCartaoDAO().getCartao(numeroCartao);
		if(cartao == null){
			throw new RuntimeException("Cartão não encontrado");
		}
		return cartao;
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Cartao> adicionarCartao(@FormParam("numerocartao") long numeroCartao,
			@FormParam("dataexpiracao") String dataExpiracao,
			@FormParam("limite") double limite) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		Cartao cartao = new Cartao(numeroCartao, limite, df.parse(dataExpiracao));
		CartaoDAO.getCartaoDAO().adicionarCartao(cartao);
		return CartaoDAO.getCartaoDAO().getCartoes();
	}
}
