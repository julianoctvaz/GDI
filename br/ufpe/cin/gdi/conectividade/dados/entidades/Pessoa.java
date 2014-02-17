package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Pessoa {
	private String cadastro;
	private String nome;
	private String email;
	Endereco endereco;
	private Vector<String> telefones;
	
	public Pessoa(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones) {
		super();
		this.cadastro = cadastro;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Vector<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Vector<String> telefones) {
		this.telefones = telefones;
	}
	
}
