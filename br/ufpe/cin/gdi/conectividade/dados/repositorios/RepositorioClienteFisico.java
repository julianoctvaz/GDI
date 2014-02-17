package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.ClienteFisico;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Endereco;



public class RepositorioClienteFisico {
	private Connection con;
	
	public RepositorioClienteFisico(Connection con){
		this.con = con;
	}
	
	public Vector<ClienteFisico> getClientesF() throws SQLException{
		
		Statement st = con.createStatement();
		
		ResultSet rs;
		
		Vector<ClienteFisico> clientesF = new Vector<ClienteFisico>();
		
		String query = "SELECT cf.*, cf.patrocinador.cadastro AS patrocinador,cf.endereco.CEP AS CEP, cf.endereco.logradouro AS logradouro, cf.endereco.numero AS numero, cf.endereco.complemento AS complemento, cf.endereco.bairro AS bairro, cf.endereco.cidade AS cidade, cf.endereco.bairro.estado FROM tb_c_fisico cf";
		
		rs = st.executeQuery(query);
		
		String patrocinador;
        String cadastro;
        String nome;
        String email;
		String data;
		String CPF;
		String sexo;
		String RG;
		
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
			CPF = rs.getString("CPF");
			data = rs.getString("data");
			sexo = rs.getString("sexo");
			RG = rs.getString("RG");
			
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
			
			clientesF.add(new ClienteFisico(cadastro, nome, email, endereco, telefones, patrocinador, CPF, data, sexo, RG));
			
			
		}
		return clientesF;
	}
	
}



