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

		String query = "SELECT cj.*, cj.patrocinador.cadastro AS patrocinador,cj.endereco.CEP AS CEP, cj.endereco.logradouro AS logradouro, cj.endereco.numero AS numero, cj.endereco.complemento AS complemento, cj.endereco.bairro AS bairro, cj.endereco.cidade AS cidade, cj.endereco.bairro.estado FROM tb_c_juridica cj";

		rs = st.executeQuery(query);

		st.close();

		Vector<ClienteJuridico> clientesJ = new Vector<ClienteJuridico>();

		String razao_social;
		String CNPJ;
		String patrocinador;
		String cadastro;
		String nome;
		String email;

		String CEP, logradouro, numero, complemento, bairro, cidade, estado;

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

	public void inserirClienteJuridico(ClienteJuridico cj) throws SQLException{

		Statement st = con.createStatement();

		String endereco = "tp_endereco('" + cj.getEndereco().getCEP() + "', '" + cj.getEndereco().getLogradouro() + "', '" + cj.getEndereco().getComplemento() + "', '" + cj.getEndereco().getNumero() + "', '" + cj.getEndereco().getBairro() + "', '" + cj.getEndereco().getCidade() + "', '" + cj.getEndereco().getEstado() + "')";

		String telefones = "v_telefone(";
		for (int i = 0; i < cj.getTelefones().size(); i++) {
			telefones = telefones + "tp_telefone('" + cj.getTelefones().elementAt(i) + "')";

			if(!(cj.getTelefones().size()-1 == i)){
				telefones = telefones + ", ";
			}
		}
		telefones = telefones + ")";

		String patrocinador = "SELECT REF(c) FROM tb_c_juridica c WHERE c.cadastro = '" + cj.getPatrocinador() + "'";
		String sql = "INSERT INTO tb_c_juridica VALUES('" + cj.getCadastro() + "', '" + cj.getNome() + "', '" + cj.getEmail() + "', " + endereco + ", " +  telefones + ", (" + patrocinador + ")" + ", '"+ cj.getCNPJ() + "', '" + cj.getRazaoSocial() + "')";

		st.executeUpdate(sql);

		st.close();
		con.commit();
	}

	public void removerClienteJuridico(ClienteJuridico cj) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_c_juridica WHERE cadastro = '" + cj.getCadastro() + "'";
		st.executeUpdate(sql);
		con.commit();
		st.close();
	}



}


