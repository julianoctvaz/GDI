package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Fornecedor;

public class RepositorioFornecedor {
	private Connection con;

	public RepositorioFornecedor(Connection con){
		this.con = con;
	}
	
	public Vector<Fornecedor> getFornecedor() throws SQLException {
		Vector<Fornecedor> fornecedores = new Vector<Fornecedor>();
		
		String cnpj, nome, tipo;
		
		Statement st = con.createStatement();
		ResultSet rs;
		
		rs = st.executeQuery("SELECT F.* FROM tb_fornecedor");
		st.close();
		
		while (rs.next()) {
			cnpj = rs.getString("CNPJ");
			nome = rs.getString("nome");
			tipo = rs.getString("tipo");
			
			fornecedores.add(new Fornecedor(cnpj, nome, tipo));
		}
		
		return fornecedores;
	}
	
	public void removerFornecedor(Fornecedor f) throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM tb_fornecedor WHERE cnpj='"+f.getCNPJ()+"'");
		st.close();
		con.commit();
	}
	
	public void inserirFornecedor(Fornecedor f) throws SQLException {
		String cnpj = f.getCNPJ(), nome = f.getNome(), tipo = f.getTipo();
		String sql = "INSERT INTO tb_fornecedor VALUES('"+cnpj+"', '"+nome+"', '"+tipo+"')";
		
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		st.close();
		con.commit();
	}
	
}
