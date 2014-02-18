package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class Fornecedor {
	
	private String CNPJ;
	private String nome;
	private String tipo;
	
	public Fornecedor(String CNPJ, String nome, String tipo) {
		super();
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
