package br.ufpe.cin.gdi.conectividade.fachada;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.ufpe.cin.gdi.conectividade.dados.entidades.Carro;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Funcionario;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Gerente;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Imagem;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Motocicleta;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Vendedor;

public class GUI {
	
	private Fachada comunicacao;
	
	private JFrame frmConcessionriaDeAutomveis;
	private JTextField func_nome_field;
	private JTextField func_login_field;
	private JTextField func_email_field;
	private JTextField func_sal_field;
	private JScrollPane func_list_scroll;
	private JList<String> func_main_list;
	private DefaultListModel<String> func_main_listmodel;
	private JLabel func_img;
	private JButton func_main_view;
	private JTextField func_nome_par;
	private JTextField func_email_par;
	private JTextField func_login_par;
	private JTextField func_senha_par;
	private JTextField func_salario_par;
	private JTextField func_cep_par;
	private JTextField func_log_par;
	private JTextField func_comp_par;
	private JTextField func_bairro_par;
	private JTextField func_numero_par;
	private JTextField func_cidade_par;
	private JTextField func_estado_par;
	private JTextField func_img_path;
	private JTextField func_cadastro_par;
	private JTextField func_multimedia_input;
	private JTextField func_telefone_par;
	private JLabel func_multimedia_img; 
	
	private File func_foto;
	
	private JFileChooser file_chooser;

	
	private Vector<Funcionario> funcionarios;
	private Vector<Vendedor> vendedores;
	private Vector<Gerente> gerentes;
	private Vector<Carro> carros;
	private Vector<Motocicleta> motos;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmConcessionriaDeAutomveis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		try {
			this.comunicacao = new Fachada();
			
			funcionarios = this.comunicacao.getFuncionarios();
			vendedores = this.comunicacao.getVendedores();
			gerentes = this.comunicacao.getGerentes();
			carros = this.comunicacao.getCarros();
			motos = this.comunicacao.getMotos();
			
			updateFuncionarioMainList();
			updateVendedoresMainList();
			updateGerentesMainList();
			updateCarrosMainList();
			updateMotosMainList();
			
			initialize();
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados!");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcessionriaDeAutomveis = new JFrame();
		frmConcessionriaDeAutomveis.setTitle("Concession\u00E1ria de Autom\u00F3veis");
		frmConcessionriaDeAutomveis.setBounds(100, 100, 816, 499);
		frmConcessionriaDeAutomveis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConcessionriaDeAutomveis.getContentPane().setLayout(new BoxLayout(frmConcessionriaDeAutomveis.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmConcessionriaDeAutomveis.getContentPane().add(tabbedPane);
		
		/*-------------------=Funcionario=-----------------*/
		JLayeredPane tab_funcionario = new JLayeredPane();
		tabbedPane.addTab("Funcionario", null, tab_funcionario, null);
		tab_funcionario.setLayout(new BoxLayout(tab_funcionario, BoxLayout.X_AXIS));
		
		JTabbedPane abas_funcionario = new JTabbedPane(JTabbedPane.TOP);
		tab_funcionario.add(abas_funcionario);
		
		JLayeredPane func_visualizar = new JLayeredPane();
		abas_funcionario.addTab("Principal", null, func_visualizar, null);
		func_visualizar.setLayout(null);
		
			//Labels
		JLabel func_nome_lb = new JLabel("Nome:");
		func_nome_lb.setBounds(390, 189, 58, 24);
		func_visualizar.add(func_nome_lb);
		
		JLabel func_login_lb = new JLabel("Login:");
		func_login_lb.setBounds(390, 237, 58, 24);
		func_visualizar.add(func_login_lb);
		
		JLabel func_email_lb = new JLabel("Email:");
		func_email_lb.setBounds(390, 286, 58, 24);
		func_visualizar.add(func_email_lb);
		
		JLabel func_sal_lb = new JLabel("Salario:");
		func_sal_lb.setBounds(390, 340, 58, 30);
		func_visualizar.add(func_sal_lb);
		
		func_nome_field = new JTextField();
		func_nome_field.setBounds(458, 191, 301, 20);
		func_visualizar.add(func_nome_field);
		func_nome_field.setEditable(false);
		
		func_login_field = new JTextField();
		func_login_field.setColumns(10);
		func_login_field.setBounds(458, 239, 301, 20);
		func_visualizar.add(func_login_field);
		func_login_field.setEditable(false);
		
		func_email_field = new JTextField();
		func_email_field.setColumns(10);
		func_email_field.setBounds(458, 288, 301, 20);
		func_visualizar.add(func_email_field);
		func_email_field.setEditable(false);
		
		func_sal_field = new JTextField();
		func_sal_field.setColumns(10);
		func_sal_field.setBounds(458, 345, 301, 20);
		func_visualizar.add(func_sal_field);
		func_sal_field.setEditable(false);
		//-----
		
		func_list_scroll = new JScrollPane();
		func_list_scroll.setBounds(31, 30, 325, 308);
		func_visualizar.add(func_list_scroll);
		
		func_main_listmodel = new DefaultListModel<String>();
		
		func_main_list = new JList<String>(func_main_listmodel);
		func_list_scroll.setViewportView(func_main_list);
		
		func_main_view = new JButton("Ver");
		func_main_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view_selected_func();
			}
		});
		func_main_view.setBounds(143, 347, 89, 23);
		func_visualizar.add(func_main_view);
		
		func_img = new JLabel("");
		func_img.setBackground(Color.WHITE);
		func_img.setBounds(490, 11, 220, 169);
		func_visualizar.add(func_img);
		
		JLayeredPane func_inserir = new JLayeredPane();
		abas_funcionario.addTab("Inserir", null, func_inserir, null);
			
			// Parametros para inserir
		func_nome_par = new JTextField();
		func_nome_par.setBounds(226, 42, 386, 20);
		func_inserir.add(func_nome_par);
		func_nome_par.setColumns(10);
		
		func_email_par = new JTextField();
		func_email_par.setColumns(10);
		func_email_par.setBounds(226, 75, 386, 20);
		func_inserir.add(func_email_par);
		
		func_login_par = new JTextField();
		func_login_par.setColumns(10);
		func_login_par.setBounds(226, 106, 192, 20);
		func_inserir.add(func_login_par);
		
		func_senha_par = new JTextField();
		func_senha_par.setColumns(10);
		func_senha_par.setBounds(226, 136, 192, 20);
		func_inserir.add(func_senha_par);
		
		func_salario_par = new JTextField();
		func_salario_par.setColumns(10);
		func_salario_par.setBounds(226, 167, 192, 20);
		func_inserir.add(func_salario_par);
		
		func_cep_par = new JTextField();
		func_cep_par.setColumns(10);
		func_cep_par.setBounds(226, 198, 146, 20);
		func_inserir.add(func_cep_par);
		
		func_log_par = new JTextField();
		func_log_par.setColumns(10);
		func_log_par.setBounds(226, 230, 192, 20);
		func_inserir.add(func_log_par);
		
		func_comp_par = new JTextField();
		func_comp_par.setColumns(10);
		func_comp_par.setBounds(226, 261, 192, 20);
		func_inserir.add(func_comp_par);
		
		func_bairro_par = new JTextField();
		func_bairro_par.setColumns(10);
		func_bairro_par.setBounds(226, 292, 111, 20);
		func_inserir.add(func_bairro_par);
		
		func_numero_par = new JTextField();
		func_numero_par.setColumns(10);
		func_numero_par.setBounds(226, 323, 129, 20);
		func_inserir.add(func_numero_par);
		
		func_cidade_par = new JTextField();
		func_cidade_par.setColumns(10);
		func_cidade_par.setBounds(483, 292, 129, 20);
		func_inserir.add(func_cidade_par);
		
		func_estado_par = new JTextField();
		func_estado_par.setColumns(10);
		func_estado_par.setBounds(483, 323, 129, 20);
		func_inserir.add(func_estado_par);
		
		func_img_path = new JTextField();
		func_img_path.setEditable(false);
		func_img_path.setBounds(226, 358, 192, 20);
		func_inserir.add(func_img_path);
		func_img_path.setColumns(10);
		
		func_cadastro_par = new JTextField();
		func_cadastro_par.setColumns(10);
		func_cadastro_par.setBounds(226, 11, 192, 20);
		func_inserir.add(func_cadastro_par);
		
		func_telefone_par = new JTextField();
		func_telefone_par.setColumns(10);
		func_telefone_par.setBounds(483, 198, 129, 20);
		func_inserir.add(func_telefone_par);
			// --
		
		JButton select_func_img = new JButton("Escolher foto");
		select_func_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_func_img();
			}
		});
		select_func_img.setBounds(454, 357, 158, 23);
		func_inserir.add(select_func_img);
		
		JButton func_cadastrar = new JButton("Cadastrar");
		func_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				func_insert();
			}
		});
		func_cadastrar.setBounds(661, 292, 106, 84);
		func_inserir.add(func_cadastrar);
		
			// Labels
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(81, 14, 111, 14);
		func_inserir.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 45, 111, 14);
		func_inserir.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(81, 75, 111, 14);
		func_inserir.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(81, 109, 111, 14);
		func_inserir.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(81, 139, 111, 14);
		func_inserir.add(lblSenha);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(81, 170, 111, 14);
		func_inserir.add(lblSalrio);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(81, 201, 93, 14);
		func_inserir.add(lblCep);
		
		JLabel lblNewLabel = new JLabel("Logradouro");
		lblNewLabel.setBounds(81, 233, 93, 14);
		func_inserir.add(lblNewLabel);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(81, 264, 123, 14);
		func_inserir.add(lblComplemento);
		
		JLabel lblKlk = new JLabel("Bairro");
		lblKlk.setBounds(81, 295, 70, 14);
		func_inserir.add(lblKlk);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(393, 295, 93, 14);
		func_inserir.add(lblCidade);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(81, 326, 93, 14);
		func_inserir.add(lblNumero);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(393, 326, 52, 14);
		func_inserir.add(lblEstado);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(406, 201, 67, 14);
		func_inserir.add(lblTelefone);
			//--
		
		JLayeredPane func_imagem = new JLayeredPane();
		abas_funcionario.addTab("Multim\u00EDdia", null, func_imagem, null);
		
		func_multimedia_img = new JLabel("");
		func_multimedia_img.setBounds(250, 52, 293, 269);
		func_imagem.add(func_multimedia_img);
		
		func_multimedia_input = new JTextField();
		func_multimedia_input.setBounds(250, 346, 160, 20);
		func_imagem.add(func_multimedia_input);
		func_multimedia_input.setColumns(10);
		
		JLabel lblCadastro_1 = new JLabel("Cadastro");
		lblCadastro_1.setBounds(121, 349, 78, 14);
		func_imagem.add(lblCadastro_1);
		
		JButton func_load_img = new JButton("Carregar imagem atual");
		func_load_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				func_load_current_image();
			}
		});
		func_load_img.setBounds(478, 345, 160, 23);
		func_imagem.add(func_load_img);
		
		JButton func_set_img = new JButton("Alterar imagem");
		func_set_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				func_update_img();
			}
		});
		func_set_img.setBounds(478, 371, 160, 23);
		func_imagem.add(func_set_img);

		/*-------------------=Funcionario (FIM) =-----------------*/
		
		/*-------------------=Vendedor=-----------------*/
		JLayeredPane tab_vendedor = new JLayeredPane();
		tabbedPane.addTab("Vendedor", null, tab_vendedor, null);
		
		JTabbedPane abas_vendedor = new JTabbedPane(JTabbedPane.TOP);
		abas_vendedor.setBounds(0, 0, 795, 433);
		tab_vendedor.add(abas_vendedor);
		
		JLayeredPane vend_visualizar = new JLayeredPane();
		abas_vendedor.addTab("Principal", null, vend_visualizar, null);
		
		JLayeredPane vend_inserir = new JLayeredPane();
		abas_vendedor.addTab("Inserir", null, vend_inserir, null);
		
		JLayeredPane vend_imagem = new JLayeredPane();
		abas_vendedor.addTab("Multim\u00EDdia", null, vend_imagem, null);
		
		/*--------------------=Vendedor (FIM)=-----------------*/
		
		/*-------------------=Gerente=-----------------*/
		JLayeredPane tab_gerente = new JLayeredPane();
		tabbedPane.addTab("Gerente", null, tab_gerente, null);
		tab_gerente.setLayout(new BoxLayout(tab_gerente, BoxLayout.X_AXIS));
		
		JTabbedPane abas_gerente = new JTabbedPane(JTabbedPane.TOP);
		tab_gerente.add(abas_gerente);
		
		JLayeredPane ger_visualizar = new JLayeredPane();
		abas_gerente.addTab("Principal", null, ger_visualizar, null);
		
		JLayeredPane ger_inserir = new JLayeredPane();
		abas_gerente.addTab("Inserir", null, ger_inserir, null);
		
		JLayeredPane ger_imagem = new JLayeredPane();
		abas_gerente.addTab("Multim\u00EDdia", null, ger_imagem, null);
		
		/*-------------------=Gerente (FIM)=-----------------*/
		
		/*-------------------=Carro=-----------------*/
		JLayeredPane tab_carro = new JLayeredPane();
		tabbedPane.addTab("Carro", null, tab_carro, null);
		tab_carro.setLayout(new BoxLayout(tab_carro, BoxLayout.X_AXIS));
		
		JTabbedPane abas_carro = new JTabbedPane(JTabbedPane.TOP);
		tab_carro.add(abas_carro);
		
		JLayeredPane carro_visualizar = new JLayeredPane();
		abas_carro.addTab("Principal", null, carro_visualizar, null);
		
		JLayeredPane carro_inserir = new JLayeredPane();
		abas_carro.addTab("Inserir", null, carro_inserir, null);
		
		JLayeredPane carro_imagem = new JLayeredPane();
		abas_carro.addTab("Multim\u00EDdia", null, carro_imagem, null);
		
		/*-------------------=Carro (FIM)=-----------------*/
		
		/*-------------------=Moto=-----------------*/
		JLayeredPane tab_moto = new JLayeredPane();
		tabbedPane.addTab("Motocicleta", null, tab_moto, null);
		tab_moto.setLayout(new BoxLayout(tab_moto, BoxLayout.X_AXIS));
		
		JTabbedPane abas_moto = new JTabbedPane(JTabbedPane.TOP);
		tab_moto.add(abas_moto);
		
		JLayeredPane moto_visualizar = new JLayeredPane();
		abas_moto.addTab("Principal", null, moto_visualizar, null);
		
		JLayeredPane moto_inserir = new JLayeredPane();
		abas_moto.addTab("Inserir", null, moto_inserir, null);
		
		JLayeredPane moto_imagem = new JLayeredPane();
		abas_moto.addTab("Multim\u00EDdia", null, moto_imagem, null);
		
		/*-------------------=Moto (FIM)=-----------------*/
		
	}
	
	/*-----------------=Funcionario=-----------------*/
	private void updateFuncionarioMainList() {
		Funcionario f;
		
		func_main_listmodel.clear();
		
		for (int i = 0; i < funcionarios.size(); i++) {
			f = funcionarios.get(i);
			func_main_listmodel.addElement(f.getCadastro());
		}
		
		func_main_list.setSelectedIndex(0);
		func_main_list.updateUI();
	}

	private void view_selected_func() {
		int i = func_main_list.getSelectedIndex();
		Funcionario f = funcionarios.get(i);
		
		func_nome_field.setText(f.getNome());
		func_login_field.setText(f.getLogin());
		func_email_field.setText(f.getEmail());
		func_sal_field.setText(f.getSalario()+"");
		
		func_img.setIcon(new ImageIcon(f.getFoto().getImagem()));
		func_img.updateUI();
	}

	private void select_func_img() {
		int r = file_chooser.showOpenDialog(null);
		
		if (r == JFileChooser.APPROVE_OPTION) {
			func_foto = file_chooser.getSelectedFile();
		} else {
			func_foto = null;
		}
		
	}
	
	private void func_insert() {
		
		String cadastro = func_cadastro_par.getText();
		String nome = func_nome_par.getText();
		String email = func_email_par.getText();
		String login = func_login_par.getText();
		String senha = func_senha_par.getText();
		double salario = Double.parseDouble(func_salario_par.getText());
		String cep = func_cep_par.getText();
		String log = func_log_par.getText();
		String numero = func_numero_par.getText();
		String cidade = func_cidade_par.getText();
		String bairro = func_bairro_par.getText();
		String estado = func_estado_par.getText();
		String comp = func_comp_par.getText();
		
		Vector<String> fones = new Vector<String>();
		
		fones.add(func_telefone_par.getText());
		
		Imagem img = null;
		try {
			if (func_foto == null) {
				img = new Imagem("");
			} else {
				img = new Imagem(func_foto);
			}
		} catch (IOException exp){
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}
		
		if (cadastro.equals("") || nome.equals("") || login.equals("") || senha.equals("") || (salario <= 0) || cep.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			try {
				this.comunicacao.cadastrarFuncionario(cadastro, nome, email, cep, log, numero, comp, bairro, cidade, estado, fones, login, senha, salario, img);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir no Banco de Dados!");
				return;
			} catch (IOException e){
				JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
				return;
			}
			
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
			
			try {
				funcionarios = this.comunicacao.getFuncionarios();
				updateFuncionarioMainList();
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao recarregar os dados!");
			}
		}
		
	}
	

	private void func_load_current_image() {
		String cad = func_multimedia_input.getText();
		
		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}
		
		Funcionario f;
		boolean did = false;
		
		for (int i = 0; i < funcionarios.size(); i++) {
			f = funcionarios.get(i);
			if (f.getCadastro().equals(cad)) {
				func_multimedia_img.setIcon(new ImageIcon(f.getFoto().getImagem()));
				func_multimedia_img.updateUI();
				did = true;
				return;
			}
		}
		
		if (!did) {
			JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
		}
		
	}
	
	private void func_update_img() {
		String cad = func_multimedia_input.getText();
		
		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}
		
		Funcionario f = null;
		boolean did = false;
		
		for (int i = 0; i < funcionarios.size(); i++) {
			f = funcionarios.get(i);
			if (f.getCadastro().equals(cad)) {
				did = true;
				break;
			}
		}
		
		if (!did) {
			JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
			return;
		}
		
		try {
			this.comunicacao.setFotoFuncionario(new Imagem(func_foto), f);
			func_multimedia_img.setIcon(new ImageIcon(f.getFoto().getImagem()));
			func_multimedia_img.updateUI();
			
			JOptionPane.showMessageDialog(null, "Foto atualizada!");
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}
		
	}
	/*-----------------=Funcionario(FIM)=-----------------*/
	
	private void updateMotosMainList() {
		
	}

	private void updateGerentesMainList() {
		
	}

	private void updateCarrosMainList() {
		
	}

	private void updateVendedoresMainList() {
		
	}
}
