package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Atendimento;

public class RepositorioAtendimento {

	private Connection con;

	public RepositorioAtendimento(Connection con) {
		this.con = con;
	}

	public Vector<Atendimento> getAtendimento() throws SQLException,
			IOException {

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<Atendimento> atendimentos = new Vector<Atendimento>();

		String query = "SELECT a.cliente.cadastro AS cliente, a.vendedor.cadastro AS vendedor FROM tb_atendimento a";

		rs = st.executeQuery(query);

		st.close();

		String cliente;
		String vendedor;

		Atendimento atendimento;

		while (rs.next()) {
			cliente = rs.getString("cliente");
			vendedor = rs.getString("vendedor");

			atendimento = new Atendimento(cliente, vendedor);

			atendimentos.add(atendimento);
		}

		return atendimentos;
	}

	public void inserirAtendimento(Atendimento atendimento) throws SQLException {
		String cliente = atendimento.getCod_cliente();
		String vendedor = atendimento.getCad_vendedor();

		String sql1 = "SELECT * FROM tb_c_fisico WHERE cadastro = '" + cliente
				+ "'";

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql1);

		if (rs.next() == true) {
			String sql = "INSERT INTO tb_atendimento VALUES((SELECT REF(cf) FROM tb_c_fisico cf WHERE cf.cadastro = '"
					+ cliente
					+ "'), (SELECT REF(v) FROM tb_vendedor v WHERE v.cadastro = '"
					+ vendedor + "')";
			st.executeUpdate(sql);

		} else {
			String sql = "INSERT INTO tb_atendimento VALUES((SELECT REF(cj) FROM tb_c_juridica cj WHERE cj.cadastro = '"
					+ cliente
					+ "'), (SELECT REF(v) FROM tb_vendedor v WHERE v.cadastro = '"
					+ vendedor + "')";
			st.executeUpdate(sql);
		}

		st.close();

		con.commit();
	}

	public void removerAtendimento(Atendimento atendimento) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_atendimento WHERE cliente.cadastro = '"
				+ atendimento.getCod_cliente() + "' AND vendedor.cadastro = '"
				+ atendimento.getCad_vendedor() + "'";
		st.executeUpdate(sql);
		st.close();

		con.commit();
	}

}
