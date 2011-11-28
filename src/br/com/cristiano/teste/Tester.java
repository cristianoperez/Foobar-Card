package br.com.cristiano.teste;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.cristiano.model.Cartao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class Tester {
	public static void main(String[] args) throws ParseException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		Cartao cartao = new Cartao(1234567890987L, 20.0, df.parse("14/10"));
		
		Form form = new Form();
		form.add("numerocartao", "112233445566");
		form.add("limite", "100.0");
		form.add("dataexpiracao", "10/12");
		
		//Adiciona um cartao a lista pelo formulario
		ClientResponse response = service.path("rest").path("cartao").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		
		//Resposta do formulario
		System.out.println(response.getEntity(String.class));
		
		//Lista todos os cartões cadastrados
		System.out.println(service.path("rest").path("cartao").accept(MediaType.APPLICATION_XML).get(String.class));
		
		//Mostra as informações do cartão 112233445566
		System.out.println(service.path("rest").path("cartao/112233445566").accept(MediaType.APPLICATION_XML).get(String.class));
		
		form = new Form();
		form.add("numerocartao", "112233445566");
		form.add("dataexpiracao", "10/12");
		form.add("valor", "100.00");
		//Adiciona um cartao a lista pelo formulario
		response = service.path("rest").path("requisicao").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		
		//Resposta do formulario
		System.out.println(response.getEntity(String.class));
	}
	
	public static URI getBaseURI(){
		return UriBuilder.fromPath("http://localhost:8080/autorizacao").build();
	}
}
