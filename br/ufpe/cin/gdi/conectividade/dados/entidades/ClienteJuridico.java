package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class ClienteJuridico extends Cliente {
	
	private String CNPJ;
	private String razaoSocial;
	
	public ClienteJuridico(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String patrocinador,
			String CNPJ, String razaoSocial) {
		super(cadastro, nome, email, endereco, telefones, patrocinador);
		this.CNPJ = CNPJ;
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}
