package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Carro;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Promocao;

public class RepositorioCarro {
	
	private Connection con;

	public RepositorioCarro(Connection con) {
		this.con = con;
	}
	
	public Vector<Carro> getCarros() throws SQLException, IOException {
		
		Statement st = con.createStatement();
		ResultSet rs;
		
		Vector<Carro> motos = new Vector<Carro>();
		
		rs = st.executeQuery("SELECT c.* FROM tb_carro c");
	
		String codigo, tempo_garantia;
		double valor;
		
		String chassi, estado, cor, modelo, consumo, freios, marca, ano, partida, cilindradas, motor, combustivel, alarme, cambio, direcao, air_bag, ar_condicionado;
		int portas;
		double malas;
		
		ByteArrayInputStream in = null;
		BufferedImage img = null;
		Blob fotoBlob = null;

		byte bytes[] = null;
		
		while (rs.next()) {
			
			codigo = rs.getString("codigo");
			tempo_garantia = rs.getString("tempo_garantia");
			valor = rs.getDouble("valor");
			chassi = rs.getString("chassi");
			estado = rs.getString("estado_uso");
			cor = rs.getString("cor");
			modelo = rs.getString("modelo");
			consumo = rs.getString("consumo");
			freios = rs.getString("freios");
			marca = rs.getString("marca");
			ano = rs.getString("ano");
			partida = rs.getString("sistema_partida");
			cilindradas = rs.getString("cilindradas");
			malas = rs.getDouble("porta_malas");
			portas = rs.getInt("quantidade_portas");
			motor = rs.getString("motor");
			combustivel = rs.getString("combustivel");
			alarme = rs.getString("alarme");
			cambio = rs.getString("cambio");
			direcao = rs.getString("direcao");
			air_bag = rs.getString("air_bag");
			ar_condicionado = rs.getString("ar_condicionado");
			
			Statement stm = con.createStatement();
			ResultSet rset;
			
			Vector<Promocao> lista_promocoes = new Vector<Promocao>();
			
			rset = stm.executeQuery("SELECT P.desconto AS desconto, TO_CHAR(P.periodo_validade) AS validade FROM tb_motocicleta M, TABLE(M.lista_promocoes) P");
			
			double desconto;
			String validade;
			
			while (rset.next()) {
				desconto = rset.getDouble("desconto");
				validade = rset.getString("validade");
				lista_promocoes.add(new Promocao(desconto, validade));
			}
			
			stm.close();
			
			fotoBlob = rs.getBlob("foto");

			if(fotoBlob != null){
				bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
				in = new ByteArrayInputStream(bytes);
				img = ImageIO.read(in);
			}
			
			Imagem imagem = new Imagem(img);
			
			Carro c = new Carro(codigo, tempo_garantia, valor, lista_promocoes, chassi, estado, cor, modelo, consumo, freios, marca, ano, partida, cilindradas, malas, portas, motor, combustivel, imagem, alarme, cambio, direcao, air_bag, ar_condicionado);
			
			motos.add(c);
		}
		st.close();
		
		return motos;
	}
	
	public void inserirCarro(Carro c) throws SQLException, FileNotFoundException {
		String codigo = c.getCodigo(), tempo_garantia = c.getTempo_garantia();
		double valor = c.getValor();
		
		String chassi = c.getChassi(), estado = c.getEstado_uso(), cor = c.getCor(), modelo = c.getModelo(), consumo = c.getConsumo(), freios = c.getFreios(), marca = c.getMarca(), ano = c.getAno(), partida = c.getSistema_partida(), cilindradas = c.getCilindradas(), motor = c.getMotor(), combustivel = c.getCombustivel(), alarme = c.getAlarme(), direcao = c.getDirecao(), cambio = c.getCambio(), air_bag = c.getAir_bag(), ar_condicionado = c.getAr_condicionado();
		int portas = c.getQuantidade_portas();
		double malas = c.getPorta_malas();
		
		String promocoes = "tp_nt_promocao(";
		
		for (int i = 0; i < c.getLista_promocoes().size(); i++) {
			if (i > 0) {
				promocoes += ", ";
			}
			
			double desconto = c.getLista_promocoes().get(i).getDesconto();
			String validade = c.getLista_promocoes().get(i).getPeriodo_validade();
			
			promocoes += "tp_promocao("+desconto+", to_date('"+validade+"', 'dd/mm/yyyy'))";
		}
		promocoes += ")";
		
		String sql = "INSERT INTO tb_carro VALUES('"+codigo+"', '"+tempo_garantia+"', "+valor+", "+promocoes+", '"+chassi+"', '"+estado+"', '"+cor+"', '"+modelo+"', '"+consumo+"', '"+freios+"', '"+marca+"', '"+ano+"', '"+partida+"', '"+cilindradas+"', "+malas+", "+portas+", '"+motor+"', '"+combustivel+"', ?, '"+alarme+"', '"+cambio+"', '"+direcao+"', '"+air_bag+"', '"+ar_condicionado+"')";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(c.getImagem().getFile());

		ps.setBinaryStream(1, in, c.getImagem().getFile().length());
		ps.executeUpdate();
		
		ps.close();
		con.commit();
	}
	
	public void removerCarro(Carro c) throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM tb_carro WHERE codigo='"+c.getCodigo()+"'");
		st.close();
		con.commit();
	}
	
	public void setFoto(Imagem imagem, Carro c) throws SQLException, FileNotFoundException {
		
		String sql = "UPDATE tb_carro SET foto = ? WHERE codigo='"+c.getCodigo()+"'";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(imagem.getFile());

		ps.setBinaryStream(1, in, imagem.getFile().length());
		ps.executeUpdate();
		
		c.setImagem(imagem);
		
		ps.close();
		con.commit();
	}
	
}
