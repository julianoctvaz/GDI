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
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Vendedor;



public class RepositorioVendedor {
	private Connection con;

	public RepositorioVendedor(Connection con){
		this.con = con;
	}

	public Vector<Vendedor> getVendedores() throws SQLException, IOException{

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<Vendedor> vendedores = new Vector<Vendedor>();

		String query = "SELECT v.*, v.endereco.CEP AS CEP, v.endereco.logradouro AS logradouro, v.endereco.numero AS numero, v.endereco.complemento AS complemento, v.endereco.bairro AS bairro, v.endereco.cidade AS cidade, v.endereco.bairro.estado,  v.supervisor.codigo AS superv_cad FROM tb_vendedor v";

		rs = st.executeQuery(query);

		st.close();

		ByteArrayInputStream in = null;
		BufferedImage img = null;
		Blob fotoBlob = null;

		byte bytes[] = null;

		String supervisor;
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

		Endereco  endereco;

		Vector<String> telefones = new Vector<String>();

		ResultSet rs2;

		String login;
		String senha;
		double salario;

		Vendedor vendedor;

		while(rs.next()){
			supervisor =  rs.getString("superv_cad");
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

			vendedor = new Vendedor(cadastro, nome, email, endereco, telefones, login, senha, salario, imagem, supervisor);

			vendedores.add(vendedor);	
		}

		return vendedores;
	}
	
	public void inserirVendedor(Vendedor vendedor) throws SQLException, IOException {
		
		String cadastro = vendedor.getCadastro();
		String nome = vendedor.getNome();
		String email = vendedor.getEmail();

		String CEP = vendedor.getEndereco().getCEP();
		String logradouro = vendedor.getEndereco().getLogradouro();
		String numero = vendedor.getEndereco().getNumero();
		String comp = vendedor.getEndereco().getComplemento();
		String bairro = vendedor.getEndereco().getCidade();
		String cidade = vendedor.getEndereco().getBairro();
		String estado = vendedor.getEndereco().getEstado();

		String telefones = "v_telefone(";
		for (int i = 0; i < vendedor.getTelefones().size(); i++) {

			if (i > 0) {
				telefones += ", ";
			}			
			telefones += "tp_telefone('" + vendedor.getTelefones().elementAt(i) + "')";
		}
		telefones += ")";

		String gerente_cad = vendedor.getCad_supervisor();
		
		String login = vendedor.getLogin();
		String senha = vendedor.getSenha();
		String salario = vendedor.getSalario() + "";

		String sql = "INSERT INTO tb_vendedor VALUES ('"+cadastro+"', '"+nome+"', '"+email+"', tp_endereco('"+CEP+"', '"+logradouro+"', '"+numero+"', '"+comp+"', '"+bairro+"', '"+cidade+"', '"+estado+"'), "+telefones+", '"+login+"', '"+senha+"', "+salario+", ?, (SELECT REF(S) FROM tb_gerente S WHERE S.cadastro = '"+gerente_cad+"'))";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(vendedor.getFoto().getFile());
		
		ps.setBinaryStream(1, in, vendedor.getFoto().getFile().length());
		
		ps.executeUpdate();
		
		ps.close();
		in.close();
		
		con.commit();
	}
	
	public void removerVendedor(Vendedor vendedor) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_vendedor WHERE cadastro='"+vendedor.getCadastro()+"'";
		st.executeUpdate(sql);
		st.close();
	}
	
}

