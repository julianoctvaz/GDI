package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class AgendarTestDrive {
	private String cliente;
	private String vendedor;
	private String veiculo;
	private String data;

	public AgendarTestDrive(String cliente, String vendedor, String veiculo,
			String data) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.veiculo = veiculo;
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
