package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Produto {
	
	private String codigo;
	private String tempo_garantia;
	private double valor;
	private Vector<Promocao> lista_promocoes;
	
	public Produto(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes) {
		super();
		this.codigo = codigo;
		this.tempo_garantia = tempo_garantia;
		this.valor = valor;
		this.lista_promocoes = lista_promocoes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTempo_garantia() {
		return tempo_garantia;
	}

	public void setTempo_garantia(String tempo_garantia) {
		this.tempo_garantia = tempo_garantia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Vector<Promocao> getLista_promocoes() {
		return lista_promocoes;
	}

	public void setLista_promocoes(Vector<Promocao> lista_promocoes) {
		this.lista_promocoes = lista_promocoes;
	}
	
}
