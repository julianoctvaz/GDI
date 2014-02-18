package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class ComprarDoCliente {
	
	private String cad_gerente;
	private String cod_cliente;
	private String cod_veiculo;
	private String data_compra;
	
	public ComprarDoCliente(String cad_gerente, String cod_cliente,
			String cod_veiculo, String data_compra) {
		super();
		this.cad_gerente = cad_gerente;
		this.cod_cliente = cod_cliente;
		this.cod_veiculo = cod_veiculo;
		this.data_compra = data_compra;
	}

	public String getCad_gerente() {
		return cad_gerente;
	}

	public void setCad_gerente(String cad_gerente) {
		this.cad_gerente = cad_gerente;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCod_veiculo() {
		return cod_veiculo;
	}

	public void setCod_veiculo(String cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

}
