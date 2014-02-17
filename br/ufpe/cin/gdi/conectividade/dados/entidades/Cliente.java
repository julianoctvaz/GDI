package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Cliente extends Pessoa {

	private String cad_patrocinador;
		
	public Cliente(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String patrocinador) {
		super(cadastro, nome, email, endereco, telefones);
		this.cad_patrocinador = patrocinador;
	}

	public String getPatrocinador() {
		return cad_patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.cad_patrocinador = patrocinador;
	}
	
}
