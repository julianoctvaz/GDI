package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class Promocao {

	private double desconto;
	private String periodo_validade;
	
	public Promocao(double desconto, String periodo_validade) {
		super();
		this.desconto = desconto;
		this.periodo_validade = periodo_validade;
	}

	public double getDesconto() {
		return desconto;
	}
	
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public String getPeriodo_validade() {
		return periodo_validade;
	}
	
	public void setPeriodo_validade(String periodo_validade) {
		this.periodo_validade = periodo_validade;
	}
	
}
