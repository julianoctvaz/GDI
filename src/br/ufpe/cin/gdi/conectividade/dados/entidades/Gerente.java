package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Gerente extends Funcionario {
	
	private String objetivos;

	public Gerente(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String login,
			String senha, double salario, Imagem foto, String objetivos) {
		super(cadastro, nome, email, endereco, telefones, login, senha,
				salario, foto);
		this.objetivos = objetivos;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	
}
