package br.com.cristiano.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.cristiano.enumeration.Mensagem;

@XmlRootElement
@XmlType(propOrder={"codigoRetorno", "mensagem"})
public class Resposta {

	private int codigoRetorno;
	private Mensagem mensagem;
	
	@XmlElement(name = "codigoRetorno")
	public int getCodigoRetorno() {
		return codigoRetorno;
	}
	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	
	@XmlElement(name = "mensagem")
	public Mensagem getMensagem() {
		if(codigoRetorno == 0){
			mensagem = Mensagem.TRANSACAO_APROVADA;
		} else {
			mensagem = Mensagem.TRANSACAO_NAO_APROVADA;
		}
		return mensagem;
	}
	@Override
	public String toString() {
		return "Resposta [codigoRetorno=" + codigoRetorno + ", mensagem="
				+ mensagem + "]";
	}
	
	
	
}
