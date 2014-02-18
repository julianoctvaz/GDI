package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Veiculo extends Produto {
	
	private String chassi;
	private String  estado_uso;
	private String cor;
	private String modelo;
	private String consumo;
	private String freios;
	private String marca;
	private String ano;
	private String sistema_partida;
	private String cilindradas;
	private double porta_malas;
	private int quantidade_portas;
	private String motor;
	private String combustivel;
	private Imagem imagem;
	
	public Veiculo(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes, String chassi, String estado_uso,
			String cor, String modelo, String consumo, String freios,
			String marca, String ano, String sistema_partida,
			String cilindradas, double porta_malas, int quantidade_portas,
			String motor, String combustivel, Imagem imagem) {
		super(codigo, tempo_garantia, valor, lista_promocoes);
		this.chassi = chassi;
		this.estado_uso = estado_uso;
		this.cor = cor;
		this.modelo = modelo;
		this.consumo = consumo;
		this.freios = freios;
		this.marca = marca;
		this.ano = ano;
		this.sistema_partida = sistema_partida;
		this.cilindradas = cilindradas;
		this.porta_malas = porta_malas;
		this.quantidade_portas = quantidade_portas;
		this.motor = motor;
		this.combustivel = combustivel;
		this.imagem = imagem;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getEstado_uso() {
		return estado_uso;
	}

	public void setEstado_uso(String estado_uso) {
		this.estado_uso = estado_uso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getFreios() {
		return freios;
	}

	public void setFreios(String freios) {
		this.freios = freios;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getSistema_partida() {
		return sistema_partida;
	}

	public void setSistema_partida(String sistema_partida) {
		this.sistema_partida = sistema_partida;
	}

	public String getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(String cilindradas) {
		this.cilindradas = cilindradas;
	}

	public double getPorta_malas() {
		return porta_malas;
	}

	public void setPorta_malas(double porta_malas) {
		this.porta_malas = porta_malas;
	}

	public int getQuantidade_portas() {
		return quantidade_portas;
	}

	public void setQuantidade_portas(int quantidade_portas) {
		this.quantidade_portas = quantidade_portas;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
}
