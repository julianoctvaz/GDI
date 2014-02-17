package br.ufpe.cin.gdi.conectividade.dados.entidades;

import java.util.Vector;

public class Motocicleta extends Veiculo {

	public Motocicleta(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes, String chassi, String estado_uso,
			String cor, String modelo, String consumo, String freios,
			String marca, String ano, String sistema_partida,
			String cilindradas, double porta_malas, int quantidade_portas,
			String motor, String combustivel, Imagem imagem) {
		super(codigo, tempo_garantia, valor, lista_promocoes, chassi, estado_uso, cor,
				modelo, consumo, freios, marca, ano, sistema_partida, cilindradas,
				porta_malas, quantidade_portas, motor, combustivel, imagem);
	}
	
}
