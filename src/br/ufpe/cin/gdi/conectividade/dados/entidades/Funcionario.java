package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Funcionario extends Pessoa {
	
	private String login;
	private String senha;
	private double salario;
	private Imagem foto;
	
	public Funcionario(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String login,
			String senha, double salario, Imagem foto) {
		super(cadastro, nome, email, endereco, telefones);
		this.login = login;
		this.senha = senha;
		this.salario = salario;
		this.foto = foto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}
	
}
