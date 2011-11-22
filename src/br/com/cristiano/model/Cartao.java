package br.com.cristiano.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "requisicao")
@XmlType(propOrder = { "numeroCartao", "dataExpiracao", "valor", "limite" })
public class Cartao {

	private long numeroCartao;
	private Double limite;
	private Date dataExpiracao;
	private Double valor;
	
	public Cartao(){
	}
	
	public Cartao(long numeroCartao, Double limite, Date dataExpiracao){
		this.numeroCartao = numeroCartao;
		this.dataExpiracao = dataExpiracao;
		this.limite = limite;
	}
	
	@XmlElement(name = "numeroCartao")
	public long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	@XmlElement(name = "limite")
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	@XmlElement(name = "dataExpiracao")
	public String getDataExpiracao() {
		SimpleDateFormat df = new SimpleDateFormat("MM/yy");
		return df.format(dataExpiracao.getTime());
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	@XmlElement(name = "valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
