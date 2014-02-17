package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class ClienteFisico extends Cliente{
	
	private String CPF;
	private String data_nascimento;
	private char sexo;
	private String RG;
	
	public ClienteFisico(String cadastro, String nome, String email,
			Endereco endereco, Vector<String> telefones, String patrocinador,
			String CPF, String data_nascimento, char sexo, String RG) {
		super(cadastro, nome, email, endereco, telefones, patrocinador);
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.RG = RG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}
	
}
