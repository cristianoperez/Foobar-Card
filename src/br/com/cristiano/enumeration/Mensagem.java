package br.com.cristiano.enumeration;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum Mensagem {
	TRANSACAO_APROVADA("Transacao Aprovada"), TRANSACAO_NAO_APROVADA("Transacao Nao Aprovada");
	
	private Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private final String mensagem;
	
	@Override
	public String toString() {
		return mensagem;
	}

}
