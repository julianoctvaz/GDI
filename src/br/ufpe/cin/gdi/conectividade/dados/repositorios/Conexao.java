package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Carro;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Funcionario;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Gerente;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Motocicleta;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Vendedor;

public class Conexao {

	private final String ipServidor = "oracle11g.cin.ufpe.br";
	private final String portaServidor = "1521";
	private final String nomeBD = "Instance01";
	private final String usuarioBD = "g132if685cc_eq02";
	private final String senhaBD = "eydfajul6";

	private Connection con;

	public void conectarBD() throws ClassNotFoundException, SQLException{
		
		// driver de acesso ao SGBD Oracle:
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// configurando a conex√£o com o banco de dados:
		Connection con = DriverManager.getConnection(this.toString(), this.usuarioBD, this.senhaBD);

		this.con = con;
	}

	public void desconectarBD() throws SQLException{
		this.con.close();
	}

	public String toString(){
		// String de conex„o
		return "jdbc:oracle:thin:@" + this.ipServidor +":"+ this.portaServidor + ":" + this.nomeBD; 
	}

	public Connection getCon() {
		return con;
	}       

	public static void main(String args[]) {
		Conexao c = new Conexao();
		
		try {
			c.conectarBD();
			
			RepositorioGerente rep_gerente = new RepositorioGerente(c.getCon());
			
			Vector<Gerente> gerentes = new Vector<Gerente>();
			
			gerentes = rep_gerente.getGerentes();
			
			for (int i = 0; i < gerentes.size(); i++) {
				System.out.println(gerentes.get(i).toString());
			}
			
			RepositorioCarro rep_carro = new RepositorioCarro(c.getCon());
			
			Vector<Carro> carro = new Vector<Carro>();
			
			carro = rep_carro.getCarros();
			
			for (int i = 0; i < carro.size(); i++) {
				System.out.println(carro.get(i).toString());
			}
			
			RepositorioFuncionario rep_func = new RepositorioFuncionario(c.getCon());
			
			Vector<Funcionario> func = new Vector<Funcionario>();
			
			func = rep_func.getFuncionarios();
			
			for (int i = 0; i < func.size(); i++) {
				System.out.println(func.get(i).toString());
			}
			
			RepositorioMotocicleta rep_moto = new RepositorioMotocicleta(c.getCon());
			
			Vector<Motocicleta> moto = new Vector<Motocicleta>();
			
			moto = rep_moto.getMotos();
			
			for (int i = 0; i < moto.size(); i++) {
				System.out.println(moto.get(i).toString());
			}
			
			RepositorioVendedor rep_vend = new RepositorioVendedor(c.getCon());
			
			Vector<Vendedor> vend = new Vector<Vendedor>();
			
			vend = rep_vend.getVendedores();
			
			for (int i = 0; i < vend.size(); i++) {
				System.out.println(vend.get(i).toString());
			}
			
			c.desconectarBD();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}

