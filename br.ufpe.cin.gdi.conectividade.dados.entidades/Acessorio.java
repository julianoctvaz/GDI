package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Acessorio extends Produto {
	
	private String nome;

	public Acessorio(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes, String nome) {
		super(codigo, tempo_garantia, valor, lista_promocoes);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
