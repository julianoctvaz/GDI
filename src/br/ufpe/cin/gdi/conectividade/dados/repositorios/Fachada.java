package br.ufpe.cin.gdi.conectividade.fachada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Carro;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Endereco;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Funcionario;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Gerente;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Motocicleta;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Promocao;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Vendedor;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.Conexao;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.RepositorioCarro;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.RepositorioFuncionario;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.RepositorioGerente;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.RepositorioMotocicleta;
import br.ufpe.cin.gdi.conectividade.dados.repositorios.RepositorioVendedor;

public class Fachada {

	private RepositorioCarro repCarro;
	private RepositorioMotocicleta repMotocicleta;
	private RepositorioFuncionario repFuncionario;
	private RepositorioGerente repGerente;
	private RepositorioVendedor repVendedor;

	public Fachada() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		conexao.conectarBD();
		this.repCarro = new RepositorioCarro(conexao.getCon());
		this.repMotocicleta = new RepositorioMotocicleta(conexao.getCon());
		this.repFuncionario = new RepositorioFuncionario(conexao.getCon());
		this.repGerente = new RepositorioGerente(conexao.getCon());
		this.repVendedor = new RepositorioVendedor(conexao.getCon());
	}

	public void cadastrarFuncionario(String cadastro, String nome,
			String email, String CEP, String logradouro, String numero,
			String complemento, String bairro, String cidade, String estado,
			Vector<String> telefones, String login, String senha,
			double salario, Imagem foto) throws SQLException, IOException {

		Endereco endereco = new Endereco(CEP, logradouro, complemento, numero,
				bairro, cidade, estado);

		Funcionario funcionario = new Funcionario(cadastro, nome, email,
				endereco, telefones, login, senha, salario, foto);

		repFuncionario.inserirFuncionario(funcionario);

	}

	public void setFotoFuncionario(Imagem foto, Funcionario f)
			throws FileNotFoundException, SQLException {
		repFuncionario.setFoto(foto, f);
	}

	public Vector<Funcionario> exibirFuncionarios() throws SQLException,
			IOException {
		Vector<Funcionario> funcionarios = repFuncionario.getFuncionarios();
		return funcionarios;
	}

	public void cadastrarGerente(String cadastro, String nome, String email,
			String CEP, String logradouro, String numero, String complemento,
			String bairro, String cidade, String estado,
			Vector<String> telefones, String login, String senha,
			double salario, Imagem foto, String objetivos) throws SQLException,
			IOException {

		Endereco endereco = new Endereco(CEP, logradouro, complemento, numero,
				bairro, cidade, estado);

		Gerente gerente = new Gerente(cadastro, nome, email, endereco,
				telefones, login, senha, salario, foto, objetivos);

		repGerente.inserirGerente(gerente);

	}

	public void setFotoGerente(Imagem foto, Gerente g)
			throws FileNotFoundException, SQLException {
		repGerente.setFoto(foto, g);
	}

	public Vector<Vendedor> exibirVendedores() throws SQLException, IOException {
		Vector<Vendedor> vendedores = repVendedor.getVendedores();
		return vendedores;
	}

	public void cadastrarVendedor(String cadastro, String nome, String email,
			String CEP, String logradouro, String numero, String complemento,
			String bairro, String cidade, String estado,
			Vector<String> telefones, String login, String senha,
			double salario, Imagem foto, String supervisor)
			throws SQLException, IOException {

		Endereco endereco = new Endereco(CEP, logradouro, complemento, numero,
				bairro, cidade, estado);

		Vendedor vendedor = new Vendedor(cadastro, nome, email, endereco,
				telefones, login, senha, salario, foto, supervisor);

		repVendedor.inserirVendedor(vendedor);

	}

	public void setFotoVendedor(Imagem foto, Vendedor v)
			throws FileNotFoundException, SQLException {
		repVendedor.setFoto(foto, v);
	}

	public Vector<Vendedor> getVendedores() throws SQLException, IOException {
		Vector<Vendedor> vendedores = repVendedor.getVendedores();
		return vendedores;
	}

	public void cadastrarCarro(String codigo, String tempo_garantia,
			double valor, Vector<Promocao> promocoes, String chassi,
			String estado, String cor, String modelo, String consumo,
			String freio, String marca, String ano, String partida,
			String clindradas, double malas, int portas, String motor,
			String combustivel,Imagem foto, String alarme, String cambio, String direcao,
			String air_bag, String ar_condicionado) throws SQLException,
			IOException {

		Carro carro = new Carro(codigo, tempo_garantia, valor, promocoes,
				chassi, estado, cor, modelo, consumo, freio, marca, ano,
				partida, clindradas, malas, portas, motor, combustivel, foto,alarme,
				cambio, direcao, air_bag, ar_condicionado);

		repCarro.inserirCarro(carro);

	}
	
	public void setFotoCarro(Imagem foto, Carro c) throws FileNotFoundException, SQLException{
		repCarro.setFoto(foto, c);
	}
	
	public Vector<Carro> getCarros() throws SQLException, IOException{
		Vector<Carro> carros = repCarro.getCarros();
		return carros;
	}
	
	public void cadastrarMotocicleta(String codigo, String tempo_garantia, double valor,
			Vector<Promocao> lista_promocoes, String chassi, String estado_uso,
			String cor, String modelo, String consumo, String freios,
			String marca, String ano, String sistema_partida,
			String cilindradas, double porta_malas, int quantidade_portas,
			String motor, String combustivel, Imagem imagem) throws FileNotFoundException, SQLException{
		
		Motocicleta moto = new Motocicleta(codigo, tempo_garantia, valor, lista_promocoes, chassi, estado_uso, cor,
				modelo, consumo, freios, marca, ano, sistema_partida, cilindradas,
				porta_malas, quantidade_portas, motor, combustivel, imagem);
		
		repMotocicleta.inserirMoto(moto);
		
	}
	
	public void setFotoMotocicleta(Imagem imagem, Motocicleta m) throws FileNotFoundException, SQLException{
		repMotocicleta.setFoto(imagem, m);
	}

	
	public Vector<Motocicleta> getMotos() throws SQLException, IOException{
		Vector<Motocicleta> motos = repMotocicleta.getMotos();
		return motos;
	}
}
