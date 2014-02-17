package br.ufpe.cin.gdi.conectividade.dados.entidades;

public class Atendimento {
	
	private String cad_vendedor;
	private String cod_cliente;
	
	public Atendimento(String cad_vendedor, String cod_cliente) {
		super();
		this.cad_vendedor = cad_vendedor;
		this.cod_cliente = cod_cliente;
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
	
}
