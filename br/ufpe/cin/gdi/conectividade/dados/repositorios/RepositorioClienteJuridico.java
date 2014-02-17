package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.ClienteJuridico;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Endereco;



public class RepositorioClienteJuridico {
	private Connection con;
	
	public RepositorioClienteJuridico(Connection con){
		this.con = con;
	}
	
	public Vector<ClienteJuridico> getClientesJ() throws SQLException{
		
		Statement st = con.createStatement();
		
		ResultSet rs;
		
		Vector<ClienteJuridico> clientesJ = new Vector<ClienteJuridico>();
		
		String query = "SELECT cj.*, cj.patrocinador.cadastro AS patrocinador,cj.endereco.CEP AS CEP, cj.endereco.logradouro AS logradouro, cj.endereco.numero AS numero, cj.endereco.complemento AS complemento, cj.endereco.bairro AS bairro, cj.endereco.cidade AS cidade, cj.endereco.bairro.estado FROM tb_c_fisico cj";
		
		rs = st.executeQuery(query);
		
		String razao_social;
		String CNPJ;
		String patrocinador;
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
        		
		while(rs.next()){
			
			cadastro = rs.getString("cadastro");
			CNPJ = rs.getString("CNPJ");
			razao_social = rs.getString("razao_social");
			nome = rs.getString("nome");
			email = rs.getString("email");
			
			patrocinador = rs.getString("patrocinador");
			
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
			
			clientesJ.add(new ClienteJuridico(cadastro, nome, email, endereco, telefones, patrocinador, CNPJ, razao_social));
			
			
		}
		return clientesJ;
	}
	
}


