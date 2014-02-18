package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Vendedor extends Funcionario {
	
	String cad_supervisor;

	public Vendedor(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String login,
			String senha, double salario, Imagem foto, String cad_supervisor) {
		super(cadastro, nome, email, endereco, telefones, login, senha,
				salario, foto);
		this.cad_supervisor = cad_supervisor;
	}

	public String getCad_supervisor() {
		return cad_supervisor;
	}

	public void setCad_supervisor(String cad_supervisor) {
		this.cad_supervisor = cad_supervisor;
	}
	
}
