package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Acessorio;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Promocao;

public class RepositorioAcessorio {

	private Connection con;

	public RepositorioAcessorio(Connection con) {
		this.con = con;
	}

	public Vector<Acessorio> getAcessorios() throws SQLException{
		Statement st = con.createStatement();
		ResultSet rs;

		Vector<Acessorio> acessorios = new Vector<Acessorio>();

		String query = "SELECT * from tb_acessorio";

		rs = st.executeQuery(query);
		st.close();

		Acessorio acessorio;

		while(rs.next()){

			String codigo = rs.getString("codigo");
			String nome = rs.getString("nome");
			String tempo_garantia = rs.getString("tempo_garantia");
			double valor = rs.getDouble("valor");

			Statement st2 = con.createStatement();

			String sql = "SELECT T.desconto, TO_CHAR(T.periodo_validade) FROM tb_acessorio a, TABLE(a.lista_promocoes) T WHERE a.codigo = '" + codigo + "'";

			ResultSet rs2 = st2.executeQuery(sql);
			st2.close();

			Vector<Promocao> promocoes = new Vector<Promocao>();

			while(rs2.next()){
				double desconto = rs2.getDouble("desconto");
				String periodo_validade = rs2.getString("periodo_validade");

				Promocao promocao = new Promocao(desconto, periodo_validade);

				promocoes.add(promocao); 
			}

			acessorio = new Acessorio(codigo, nome, valor, promocoes, tempo_garantia);
			acessorios.add(acessorio);
		}

		return acessorios;
	}

	public void removerAcessorio(Acessorio acc) throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM tb_acessorio WHERE codigo='"+acc.getCodigo()+"'");
		st.close();
	}

	public void inserirAcessorio(Acessorio acc) throws SQLException {
		String codigo = acc.getCodigo();
		String nome = acc.getNome();
		String tempo_garantia = acc.getTempo_garantia();
		double valor = acc.getValor();

		String promocoes = "tp_nt_promocao(";

		for (int i = 0; i < acc.getLista_promocoes().size(); i++) {
			if (i > 0) {
				promocoes += ", ";
			}

			double desconto = acc.getLista_promocoes().get(i).getDesconto();
			String validade = acc.getLista_promocoes().get(i).getPeriodo_validade();

			promocoes += "tp_promocao("+desconto+", to_date('"+validade+"', 'dd/mm/yyyy'))";
		}
		
		String sql = "INSERT INTO tb_acessorio VALUES('"+codigo+"', '"+tempo_garantia+"', "+valor+", "+promocoes+", '"+nome+"')";
		
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		st.close();
	}

}
