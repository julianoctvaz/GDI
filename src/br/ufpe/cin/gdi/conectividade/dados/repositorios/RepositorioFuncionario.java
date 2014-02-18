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

import br.ufpe.cin.gdi.conectividade.dados.entidades.Endereco;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Funcionario;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;

public class RepositorioFuncionario {
	private Connection con;

	public RepositorioFuncionario(Connection con) {
		this.con = con;
	}

	public Vector<Funcionario> getFuncionarios() throws SQLException,
			IOException {

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<Funcionario> funcionarios = new Vector<Funcionario>();

		String query = "SELECT f.*, f.endereco.CEP AS CEP, f.endereco.logradouro AS logradouro, f.endereco.numero AS numero, f.endereco.complemento AS complemento, f.endereco.bairro AS bairro, f.endereco.cidade AS cidade, f.endereco.estado AS estado FROM tb_funcionario f";

		rs = st.executeQuery(query);

		ByteArrayInputStream in = null;
		BufferedImage img = null;
		Blob fotoBlob = null;

		byte bytes[] = null;

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

		Endereco endereco;

		Vector<String> telefones = new Vector<String>();

		ResultSet rs2;

		String login;
		String senha;
		double salario;

		Funcionario funcionario;

		while (rs.next()) {
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
			while (rs2.next()) {
				telefones.add(rs2.getString(1));
			}

			endereco = new Endereco(CEP, logradouro, numero, complemento,
					bairro, cidade, estado);

			login = rs.getString("login");
			senha = rs.getString("senha");
			salario = rs.getDouble("salario");

			fotoBlob = rs.getBlob("foto");

			if (fotoBlob != null) {
				bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
				in = new ByteArrayInputStream(bytes);
				img = ImageIO.read(in);
			}

			Imagem imagem = new Imagem(img);

			funcionario = new Funcionario(cadastro, nome, email, endereco,
					telefones, login, senha, salario, imagem);

			funcionarios.add(funcionario);
		}

		st.close();

		return funcionarios;
	}

	public void inserirFuncionario(Funcionario funcionario)
			throws SQLException, IOException {

		String cadastro = funcionario.getCadastro();
		String nome = funcionario.getNome();
		String email = funcionario.getEmail();

		String CEP = funcionario.getEndereco().getCEP();
		String logradouro = funcionario.getEndereco().getLogradouro();
		String numero = funcionario.getEndereco().getNumero();
		String comp = funcionario.getEndereco().getComplemento();
		String bairro = funcionario.getEndereco().getCidade();
		String cidade = funcionario.getEndereco().getBairro();
		String estado = funcionario.getEndereco().getEstado();

		String telefones = "v_telefone(";
		for (int i = 0; i < funcionario.getTelefones().size(); i++) {

			if (i > 0) {
				telefones += ", ";
			}
			telefones += "tp_telefone('"
					+ funcionario.getTelefones().elementAt(i) + "')";
		}
		telefones += ")";

		String login = funcionario.getLogin();
		String senha = funcionario.getSenha();
		String salario = funcionario.getSalario() + "";

		String sql = "INSERT INTO tb_funcionario VALUES ('" + cadastro + "', '"
				+ nome + "', '" + email + "', tp_endereco('" + CEP + "', '"
				+ logradouro + "', '" + numero + "', '" + comp + "', '"
				+ bairro + "', '" + cidade + "', '" + estado + "'), "
				+ telefones + ", '" + login + "', '" + senha + "', " + salario
				+ ", ?))";

		PreparedStatement ps = con.prepareStatement(sql);

		InputStream in = (InputStream) new FileInputStream(funcionario.getFoto().getFile());

		ps.setBinaryStream(1, in, funcionario.getFoto().getFile().length());

		ps.executeUpdate();

		ps.close();
		in.close();

		con.commit();
	}

	public void removerFuncionario(Funcionario funcionario) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_funcionario WHERE cadastro='"
				+ funcionario.getCadastro() + "'";
		st.executeUpdate(sql);
		st.close();

		con.commit();
	}
	
	public void setFoto(Imagem imagem, Funcionario f) throws SQLException, FileNotFoundException {
		
		String sql = "UPDATE tb_funcionario SET foto = ? WHERE cadastro='"+f.getCadastro()+"'";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(imagem.getFile());

		ps.setBinaryStream(1, in, imagem.getFile().length());
		ps.executeUpdate();
		
		f.setFoto(imagem);
		
		ps.close();
		con.commit();
	}
	
}
