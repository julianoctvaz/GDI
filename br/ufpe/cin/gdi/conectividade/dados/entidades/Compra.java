package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class Comprar {
	
	private String cad_gerente;
	private String cad_vendedor;
	private String cod_cliente;
	private String cod_produto;
	private String data_compra;
	
	public Comprar(String cad_gerente, String cad_vendedor, String cod_cliente,
			String cod_produto, String data_compra) {
		super();
		this.cad_gerente = cad_gerente;
		this.cad_vendedor = cad_vendedor;
		this.cod_cliente = cod_cliente;
		this.cod_produto = cod_produto;
		this.data_compra = data_compra;
	}

	public String getCad_gerente() {
		return cad_gerente;
	}
	
	public void setCad_gerente(String cad_gerente) {
		this.cad_gerente = cad_gerente;
	}
	
	public String getCad_vendedor() {
		return cad_vendedor;
	}
	
	public void setCad_vendedor(String cad_vendedor) {
		this.cad_vendedor = cad_vendedor;
	}
	
	public String getCod_cliente() {
		return cod_cliente;
	}
	
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	
	public String getCod_produto() {
		return cod_produto;
	}
	
	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}
	
	public String getData_compra() {
		return data_compra;
	}
	
	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	
}
