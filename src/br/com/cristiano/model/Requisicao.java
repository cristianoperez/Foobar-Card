package br.com.cristiano.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "numeroCartao", "dataExpiracao", "valor" })
public class Requisicao {

	private long numeroCartao;
	private Double limite = 30.00;
	private Date dataExpiracao;
	private Double valor;
	
	public Requisicao(){
	}
	
	public Requisicao(long numeroCartao, Date dataExpiracao, Double valor){
		this.numeroCartao = numeroCartao;
		this.dataExpiracao = dataExpiracao;
		this.valor = valor;
	}

	@XmlElement(name = "numeroCartao")
	public long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	@XmlTransient
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

	@Override
	public String toString() {
		return "Requisicao [numeroCartao=" + numeroCartao + ", limite="
				+ limite + ", dataExpiracao=" + getDataExpiracao() + ", valor="
				+ valor + "]";
	}
	
	

}
