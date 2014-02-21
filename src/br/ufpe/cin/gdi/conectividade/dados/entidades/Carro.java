package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Carro extends Veiculo {
	
	private String alarme;
	private String cambio;
	private String direcao;
	private String air_bag;
	private String ar_condicionado;
	
	public Carro(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes, String chassi, String estado_uso,
			String cor, String modelo, String consumo, String freios,
			String marca, String ano, String sistema_partida,
			String cilindradas, double porta_malas, int quantidade_portas,
			String motor, String combustivel, Imagem imagem, String alarme,
			String cambio, String direcao, String air_bag,
			String ar_condicionado) {
		super(codigo, tempo_garantia, valor, lista_promocoes, chassi,
				estado_uso, cor, modelo, consumo, freios, marca, ano,
				sistema_partida, cilindradas, porta_malas, quantidade_portas,
				motor, combustivel, imagem);
		this.alarme = alarme;
		this.cambio = cambio;
		this.direcao = direcao;
		this.air_bag = air_bag;
		this.ar_condicionado = ar_condicionado;
	}

	public String getAlarme() {
		return alarme;
	}

	public void setAlarme(String alarme) {
		this.alarme = alarme;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getAir_bag() {
		return air_bag;
	}

	public void setAir_bag(String air_bag) {
		this.air_bag = air_bag;
	}

	public String getAr_condicionado() {
		return ar_condicionado;
	}

	public void setAr_condicionado(String ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}
	
}
