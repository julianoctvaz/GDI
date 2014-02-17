package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class Fornecer {
	
	private String cod_produto;
	private String cad_gerente;
	private String cnpj_fornecedor;
	private String data_fornecimento;
	private double valor_compra;
	
	public Fornecer(String cod_produto, String cad_gerente,
			String cnpj_fornecedor, String data_fornecimento,
			double valor_compra) {
		super();
		this.cod_produto = cod_produto;
		this.cad_gerente = cad_gerente;
		this.cnpj_fornecedor = cnpj_fornecedor;
		this.data_fornecimento = data_fornecimento;
		this.valor_compra = valor_compra;
	}

	public String getCod_produto() {
		return cod_produto;
	}
	
	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}
	
	public String getCad_gerente() {
		return cad_gerente;
	}
	
	public void setCad_gerente(String cad_gerente) {
		this.cad_gerente = cad_gerente;
	}
	
	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}
	
	public void setCnpj_fornecedor(String cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}
	
	public String getData_fornecimento() {
		return data_fornecimento;
	}
	
	public void setData_fornecimento(String data_fornecimento) {
		this.data_fornecimento = data_fornecimento;
	}
	
	public double getValor_compra() {
		return valor_compra;
	}
	
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	
}
