package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.AgendarTestDrive;

public class RepositorioAgendarTestDrive {
	private Connection con;

	public RepositorioAgendarTestDrive(Connection con) {
		this.con = con;
	}

	public Vector<AgendarTestDrive> getAgendarTestDrive() throws SQLException,
			IOException {

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<AgendarTestDrive> agendarTDs = new Vector<AgendarTestDrive>();

		String query = "SELECT ag.atendimento.cliente.cadastro AS cliente, ag.atendimento.vendedor.cadastro AS vendedor, ag.veiculo.codigo AS veiculo, TO_CHAR(ag.data_test) AS data FROM tb_agendar_test_drive ag";

		rs = st.executeQuery(query);

		st.close();

		String cliente;
		String vendedor;
		String veiculo;
		String data;

		AgendarTestDrive agendarTD;

		while (rs.next()) {
			cliente = rs.getString("cliente");
			vendedor = rs.getString("vendedor");
			veiculo = rs.getString("veiculo");
			data = rs.getString("data");

			agendarTD = new AgendarTestDrive(cliente, vendedor, veiculo, data);

			agendarTDs.add(agendarTD);
		}

		return agendarTDs;
	}

	public void inserirAgendarTestDrive(AgendarTestDrive agendarTD)
			throws SQLException {
		String cliente = agendarTD.getCliente();
		String vendedor = agendarTD.getVendedor();
		String veiculo = agendarTD.getVeiculo();
		String data = agendarTD.getData();

		String sql = "INSERT INTO tb_agendar_test_drive VALUES((SELECT REF(a) FROM tb_atendimento a WHERE a.cliente.cadastro = '"
				+ cliente
				+ "' AND a.vendedor.cadastro = '"
				+ vendedor
				+ "'), "
				+ "(SELECT REF(v) FROM tb_veiculo v WHERE v.codigo = '"
				+ veiculo + "'), TO_DATE('" + data + "', 'dd/mm/yyyy'))";

		Statement st = con.createStatement();

		st.executeUpdate(sql);

		st.close();
		con.commit();
	}

	public void removerAgendarTestDrive(AgendarTestDrive agendarTD)
			throws SQLException {
		Statement st = con.createStatement();

		String sql = "DELETE FROM tb_agendar_test_drive WHERE atendimento.cliente.cadastro = '"
				+ agendarTD.getCliente()
				+ "' AND atendimento.vendedor.cadastro = '"
				+ agendarTD.getVendedor()
				+ "' AND veiculo.codigo = '"
				+ agendarTD.getVeiculo()
				+ "' AND data_test = '"
				+ agendarTD.getData() + "'";

		st.executeUpdate(sql);
		st.close();

		con.commit();
	}
}
