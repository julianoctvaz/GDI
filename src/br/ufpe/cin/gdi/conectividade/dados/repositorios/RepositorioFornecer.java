package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Fornecer;

public class RepositorioFornecer {
	private Connection con;

	public RepositorioFornecer(Connection con){
		this.con = con;
	}
	
	public Vector<Fornecer> getFornecer() throws SQLException {
		String cod_produto;
		String cad_gerente;
		String cnpj_fornecedor;
		String data_fornecimento;
		double valor_compra;
		
		Vector<Fornecer> fornecer = new Vector<Fornecer>();
		
		Statement st = con.createStatement();
		ResultSet rs;
		
		rs = st.executeQuery("SELECT F.codigo_produto AS produto, F.gerente.cadastro AS gerente, F.fornecedor.cnpj AS fornecedor, TO_CHAR(F.data_fornecimento) AS data, F.valor_de_compra AS valor FROM tb_fornecer F");
		st.close();
		
		while (rs.next()) {
			cod_produto = rs.getString("produto");
			cad_gerente = rs.getString("gerente");
			cnpj_fornecedor = rs.getString("fornecedor");
			data_fornecimento = rs.getString("data");
			valor_compra = rs.getDouble("valor");
			
			fornecer.add(new Fornecer(cod_produto, cad_gerente, cnpj_fornecedor, data_fornecimento, valor_compra));
		}
		
		return fornecer;
	}
	
	public void inserirFornecer(Fornecer f) throws SQLException {
		String cod_produto = f.getCod_produto();
		String cad_gerente = f.getCad_gerente();
		String cnpj_fornecedor = f.getCnpj_fornecedor();
		String data_fornecimento = f.getData_fornecimento();
		double valor_compra = f.getValor_compra();
		
		String sql = "INSERT INTO tb_fornecer VALUES ((SELECT REF(P) FROM tb_acessorio P WHERE P.codigo = '"+cod_produto+"'), (SELECT REF(G) FROM tb_gerente G WHERE G.cadastro = '"+cad_gerente+"'), (SELECT REF(F) FROM tb_fornecedor F WHERE F.CNPJ = '"+cnpj_fornecedor+"'), to_date('"+data_fornecimento+"', 'dd/mm/yyyy'), "+valor_compra+")";
		
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		st.close();
		con.commit();
	}
	
}
