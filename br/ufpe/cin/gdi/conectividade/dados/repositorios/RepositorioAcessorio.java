package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Endereco;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Gerente;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;



public class RepositorioGerente {
	private Connection con;
	
	public RepositorioGerente(Connection con){
		this.con = con;
	}
	
	public Vector<Gerente> getGerentes() throws SQLException, IOException{
		
		Statement st = con.createStatement();
		
		ResultSet rs;
		
		Vector<Gerente> gerentes = new Vector<Gerente>();
		
		String query = "SELECT g.*, g.endereco.CEP AS CEP, g.endereco.logradouro AS logradouro, g.endereco.numero AS numero, g.endereco.complemento AS complemento, g.endereco.bairro AS bairro, g.endereco.cidade AS cidade, g.endereco.bairro.estado FROM tb_vendedor g";
		
		rs = st.executeQuery(query);
		
		ByteArrayInputStream in = null;
        BufferedImage img = null;
        Blob fotoBlob = null;
      
        byte bytes[] = null;
		
        String objetivos;
        String cadastro;
        String nome;
        String email;
        String CEP;
        String logradouro;
        String numero;
        String complemento;
        String bairro;
        String cidade;
        String estado;
        String telefone;
        
        Endereco  endereco;
      
        Vector<String> telefones = new Vector<String>();
        
        ResultSet rs2;
        
        String login;
        String senha;
        Double salario;
        
        Gerente gerente;
        
		while(rs.next()){
			objetivos =  rs.getString("objetivos");
			cadastro = rs.getString("cadastro");
			nome = rs.getString("nome");
			email = rs.getString("email");
			
			CEP = rs.getString("CEP");
			logradouro = rs.getString("logradouro");
			numero = rs.getString("numero");
			complemento = rs.getString("complemento");
			bairro = rs.getString("bairro");
			cidade = rs.getString("cidade");
			estado = rs.getString("estado");
			
			rs2 = rs.getArray("telefone").getResultSet();
			while(rs2.next()){
				telefones.add(rs2.getString(2));
				
			}
			
			endereco = new Endereco(CEP, logradouro, numero, complemento, bairro, cidade, estado);
			
			login = rs.getString("login");
			senha = rs.getString("senha");
			salario = rs.getDouble("salario");
			
			fotoBlob = rs.getBlob("foto");
			
			if(fotoBlob != null){
				  bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
                  in = new ByteArrayInputStream(bytes);
                  img = ImageIO.read(in);
			}
			
			Imagem imagem = new Imagem(img);
			
            gerente = new Gerente(cadastro, nome, email, endereco, telefones, login, senha, salario, imagem, objetivos);
            
			gerentes.add(gerente);
			
			
		}
		
		return gerentes;
	}
}

