package br.ufpe.cin.gdi.conectividade.fachada;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
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
import br.ufpe.cin.gdi.conectividade.dados.entidades.Promocao;
import br.ufpe.cin.gdi.conectividade.dados.entidades.Vendedor;

public class GUI {

	private Fachada comunicacao;

	private JFrame frmConcessionriaDeAutomveis;

	private Component func_visualizar;
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

	private JTextField ger_obj_field;
	private JTextField ger_nome_field;
	private JTextField ger_login_field;
	private JTextField ger_email_field;
	private JTextField ger_sal_field;
	private JScrollPane ger_list_scroll;
	private DefaultListModel<String> ger_main_listmodel;
	private JList<String> ger_main_list;
	private JButton ger_main_view;
	private JLabel ger_img;
	private JTextField ger_nome_par;
	private JTextField ger_email_par;
	private JTextField ger_login_par;
	private JTextField ger_senha_par;
	private JTextField ger_salario_par;
	private JTextField ger_cep_par;
	private JTextField ger_log_par;
	private JTextField ger_comp_par;
	private JTextField ger_bairro_par;
	private JTextField ger_numero_par;
	private JTextField ger_cidade_par;
	private JTextField ger_estado_par;
	private JTextField ger_img_path;
	private JTextField ger_cadastro_par;
	private JTextField ger_telefone_par;
	private JTextField ger_obj_par;
	private JLabel ger_multimedia_img;
	private JTextField ger_multimedia_input;
	private File ger_foto;
	private Component ger_visualizar;

	private JScrollPane moto_list_scroll;
	private DefaultListModel<String> moto_main_listmodel;
	private JList<String> moto_main_list;
	private JButton moto_main_view;
	private JLabel moto_img;
	private JTextField moto_modelo_field;
	private JTextField moto_marca_field;
	private JTextField moto_codigo_field;
	private JTextField moto_valor_field;
	private JLabel moto_multimedia_img;
	private JTextField moto_multimedia_input;
	private Component motos_visualizar;
	private File moto_foto;
	private JTextField moto_cod_par;
	private JTextField moto_garantia_par;
	private JTextField moto_val_par;
	private JTextField moto_chassi_par;
	private JTextField moto_cor_par;
	private JTextField moto_modelo_par;
	private JTextField moto_marca_par;
	private JTextField moto_ano_par;
	private JTextField moto_partida_par;
	private JTextField moto_cilindradas_par;
	private JTextField moto_malas_par;
	private JTextField moto_portas_par;
	private JTextField moto_motor_par;
	private JTextField moto_combustivel_par;
	private JTextField moto_consumo_par;
	private JTextField moto_estado_par;
	private JTextField moto_freios_par;

	private JTextField vend_nome_field;
	private JTextField vend_login_field;
	private JTextField vend_email_field;
	private JTextField vend_salario_field;
	private DefaultListModel<String> vend_main_listmodel;
	private JList<String> vend_main_list;
	private JLabel vend_img;
	private JTextField vend_img_par;
	private JTextField vend_num_par;
	private JTextField vend_bairro_par;
	private JTextField vend_logra_par;
	private JTextField vend_comple_par;
	private JTextField vend_cep_par;
	private JTextField vend_sal_par;
	private JTextField vend_senha_par;
	private JTextField vend_login_par;
	private JTextField vend_email_par;
	private JTextField vend_nome_par;
	private JTextField vend_cad_par;
	private JTextField vend_tel_par;
	private JTextField vend_cidade_par;
	private JTextField vend_estado_par;
	private JTextField vend_superv_par;
	private JTextField vend_update_img_input;
	private JLabel vend_multimedia_img;
	private Component vend_visualizar;
	private File vend_foto;

	private JScrollPane carro_list_scroll;
	private DefaultListModel<String> carro_main_listmodel;
	private JList<String> carro_main_list;
	private JTextField carro_codigo_field;
	private JTextField carro_marca_field;
	private JTextField carro_chassi_field;
	private JTextField carro_ano_field;
	private JTextField carro_modelo_field;
	private JTextField carro_estado_uso_field;
	private JTextField carro_valor_field;
	private JButton carro_main_view;
	private JLabel carro_img;
	private JLabel carro_multimedia_img;
	private JTextField carro_multimedia_input;
	private JTextField carro_codigo_par;
	private JTextField carro_tempo_garantia_par;
	private JTextField carro_valor_par;
	private JTextField carro_chassi_par;
	private JTextField carro_estado_uso_par;
	private JTextField carro_cor_par;
	private JTextField carro_modelo_par;
	private JTextField carro_consumo_par;
	private JTextField carro_freios_par;
	private JTextField carro_marca_par;
	private JTextField carro_ano_par;
	private JTextField carro_sistema_partida_par;
	private JTextField carro_cilindradas_par;
	private JTextField carro_porta_malas_par;
	private JTextField carro_quantidade_portas_par;
	private JTextField carro_motor_par;
	private JTextField carro_combustivel_par;
	private JTextField carro_imagem_par;
	private JTextField carro_alarme_par;
	private JTextField carro_cambio_par;
	private JTextField carro_direcao_par;
	private JTextField carro_air_bag_par;
	private JTextField carro_ar_condicionado_par;
	private File carro_foto;
	private Component carro_visualizar;

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

			initialize();

			updateFuncionarioMainList();
			updateVendedoresMainList();
			updateGerentesMainList();
			updateCarrosMainList();
			updateMotosMainList();

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível conectar ao banco de dados!");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		file_chooser = new JFileChooser();

		frmConcessionriaDeAutomveis = new JFrame();
		frmConcessionriaDeAutomveis
				.setTitle("Concession\u00E1ria de Autom\u00F3veis");
		frmConcessionriaDeAutomveis.setBounds(100, 100, 816, 499);
		frmConcessionriaDeAutomveis
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConcessionriaDeAutomveis.getContentPane().setLayout(
				new BoxLayout(frmConcessionriaDeAutomveis.getContentPane(),
						BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmConcessionriaDeAutomveis.getContentPane().add(tabbedPane);

		/*-------------------=Funcionario=-----------------*/
		JLayeredPane tab_funcionario = new JLayeredPane();
		tabbedPane.addTab("Funcionario", null, tab_funcionario, null);
		tab_funcionario.setLayout(new BoxLayout(tab_funcionario,
				BoxLayout.X_AXIS));

		JTabbedPane abas_funcionario = new JTabbedPane(JTabbedPane.TOP);
		tab_funcionario.add(abas_funcionario);

		JLayeredPane func_visualizar = new JLayeredPane();
		abas_funcionario.addTab("Principal", null, func_visualizar, null);
		func_visualizar.setLayout(null);

		// Labels
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
		// -----

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
		// --

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

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.setBounds(0, 0, 790, 405);
		vend_visualizar.add(layeredPane);

		JLabel label = new JLabel("Nome:");
		label.setBounds(390, 189, 58, 24);
		layeredPane.add(label);

		JLabel label_1 = new JLabel("Login:");
		label_1.setBounds(390, 237, 58, 24);
		layeredPane.add(label_1);

		JLabel label_2 = new JLabel("Email:");
		label_2.setBounds(390, 286, 58, 24);
		layeredPane.add(label_2);

		JLabel label_3 = new JLabel("Salario:");
		label_3.setBounds(390, 340, 58, 30);
		layeredPane.add(label_3);

		vend_nome_field = new JTextField();
		vend_nome_field.setEditable(false);
		vend_nome_field.setBounds(458, 191, 301, 20);
		layeredPane.add(vend_nome_field);
		vend_nome_field.setEditable(false);

		vend_login_field = new JTextField();
		vend_login_field.setEditable(false);
		vend_login_field.setColumns(10);
		vend_login_field.setBounds(458, 239, 301, 20);
		layeredPane.add(vend_login_field);
		vend_login_field.setEditable(false);

		vend_email_field = new JTextField();
		vend_email_field.setEditable(false);
		vend_email_field.setColumns(10);
		vend_email_field.setBounds(458, 288, 301, 20);
		layeredPane.add(vend_email_field);
		vend_email_field.setEditable(false);

		vend_salario_field = new JTextField();
		vend_salario_field.setEditable(false);
		vend_salario_field.setColumns(10);
		vend_salario_field.setBounds(458, 345, 301, 20);
		layeredPane.add(vend_salario_field);
		vend_salario_field.setEditable(false);

		JScrollPane vend_list_scroll = new JScrollPane();
		vend_list_scroll.setBounds(31, 30, 325, 308);
		layeredPane.add(vend_list_scroll);

		vend_main_listmodel = new DefaultListModel<String>();

		vend_main_list = new JList<String>(vend_main_listmodel);
		vend_list_scroll.setViewportView(vend_main_list);

		JButton button = new JButton("Ver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_selected_vend();
			}
		});
		button.setBounds(143, 347, 89, 23);
		layeredPane.add(button);

		vend_img = new JLabel("");
		vend_img.setBackground(Color.WHITE);
		vend_img.setBounds(490, 11, 220, 169);
		layeredPane.add(vend_img);

		JLayeredPane vend_inserir = new JLayeredPane();
		abas_vendedor.addTab("Inserir", null, vend_inserir, null);

		JLabel label_5 = new JLabel("Cadastro");
		label_5.setBounds(48, 28, 111, 14);
		vend_inserir.add(label_5);

		JLabel label_6 = new JLabel("Nome");
		label_6.setBounds(48, 59, 111, 14);
		vend_inserir.add(label_6);

		JLabel label_7 = new JLabel("Email");
		label_7.setBounds(48, 89, 111, 14);
		vend_inserir.add(label_7);

		JLabel label_8 = new JLabel("Login");
		label_8.setBounds(48, 123, 111, 14);
		vend_inserir.add(label_8);

		JLabel label_9 = new JLabel("Senha");
		label_9.setBounds(432, 123, 111, 14);
		vend_inserir.add(label_9);

		JLabel label_10 = new JLabel("Sal\u00E1rio");
		label_10.setBounds(48, 184, 111, 14);
		vend_inserir.add(label_10);

		JLabel label_11 = new JLabel("CEP");
		label_11.setBounds(48, 215, 93, 14);
		vend_inserir.add(label_11);

		JLabel label_12 = new JLabel("Logradouro");
		label_12.setBounds(48, 247, 93, 14);
		vend_inserir.add(label_12);

		JLabel label_13 = new JLabel("Complemento");
		label_13.setBounds(48, 278, 123, 14);
		vend_inserir.add(label_13);

		JLabel label_14 = new JLabel("Bairro");
		label_14.setBounds(48, 309, 70, 14);
		vend_inserir.add(label_14);

		JLabel label_15 = new JLabel("Numero");
		label_15.setBounds(48, 340, 93, 14);
		vend_inserir.add(label_15);

		vend_img_par = new JTextField();
		vend_img_par.setEditable(false);
		vend_img_par.setColumns(10);
		vend_img_par.setBounds(193, 372, 192, 20);
		vend_inserir.add(vend_img_par);

		vend_num_par = new JTextField();
		vend_num_par.setColumns(10);
		vend_num_par.setBounds(193, 337, 129, 20);
		vend_inserir.add(vend_num_par);

		vend_bairro_par = new JTextField();
		vend_bairro_par.setColumns(10);
		vend_bairro_par.setBounds(193, 306, 111, 20);
		vend_inserir.add(vend_bairro_par);

		vend_logra_par = new JTextField();
		vend_logra_par.setColumns(10);
		vend_logra_par.setBounds(193, 244, 192, 20);
		vend_inserir.add(vend_logra_par);

		vend_comple_par = new JTextField();
		vend_comple_par.setColumns(10);
		vend_comple_par.setBounds(193, 275, 192, 20);
		vend_inserir.add(vend_comple_par);

		vend_cep_par = new JTextField();
		vend_cep_par.setColumns(10);
		vend_cep_par.setBounds(193, 212, 146, 20);
		vend_inserir.add(vend_cep_par);

		vend_sal_par = new JTextField();
		vend_sal_par.setColumns(10);
		vend_sal_par.setBounds(193, 181, 192, 20);
		vend_inserir.add(vend_sal_par);

		vend_senha_par = new JTextField();
		vend_senha_par.setColumns(10);
		vend_senha_par.setBounds(490, 120, 192, 20);
		vend_inserir.add(vend_senha_par);

		vend_login_par = new JTextField();
		vend_login_par.setColumns(10);
		vend_login_par.setBounds(193, 120, 192, 20);
		vend_inserir.add(vend_login_par);

		vend_email_par = new JTextField();
		vend_email_par.setColumns(10);
		vend_email_par.setBounds(193, 89, 386, 20);
		vend_inserir.add(vend_email_par);

		vend_nome_par = new JTextField();
		vend_nome_par.setColumns(10);
		vend_nome_par.setBounds(193, 56, 386, 20);
		vend_inserir.add(vend_nome_par);

		vend_cad_par = new JTextField();
		vend_cad_par.setColumns(10);
		vend_cad_par.setBounds(193, 25, 192, 20);
		vend_inserir.add(vend_cad_par);

		vend_tel_par = new JTextField();
		vend_tel_par.setColumns(10);
		vend_tel_par.setBounds(450, 212, 129, 20);
		vend_inserir.add(vend_tel_par);

		JLabel label_16 = new JLabel("Telefone");
		label_16.setBounds(373, 215, 67, 14);
		vend_inserir.add(label_16);

		JLabel label_17 = new JLabel("Cidade");
		label_17.setBounds(360, 309, 93, 14);
		vend_inserir.add(label_17);

		vend_cidade_par = new JTextField();
		vend_cidade_par.setColumns(10);
		vend_cidade_par.setBounds(450, 306, 129, 20);
		vend_inserir.add(vend_cidade_par);

		vend_estado_par = new JTextField();
		vend_estado_par.setColumns(10);
		vend_estado_par.setBounds(450, 337, 129, 20);
		vend_inserir.add(vend_estado_par);

		JLabel label_18 = new JLabel("Estado");
		label_18.setBounds(360, 340, 52, 14);
		vend_inserir.add(label_18);

		JButton button_1 = new JButton("Escolher foto");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_vend_img();
			}
		});
		button_1.setBounds(421, 371, 158, 23);
		vend_inserir.add(button_1);

		JButton button_2 = new JButton("Cadastrar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vend_insert();
			}
		});
		button_2.setBounds(628, 306, 106, 84);
		vend_inserir.add(button_2);

		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setBounds(48, 151, 111, 14);
		vend_inserir.add(lblSupervisor);

		vend_superv_par = new JTextField();
		vend_superv_par.setColumns(10);
		vend_superv_par.setBounds(193, 148, 192, 20);
		vend_inserir.add(vend_superv_par);

		JLayeredPane vend_imagem = new JLayeredPane();
		abas_vendedor.addTab("Multim\u00EDdia", null, vend_imagem, null);

		vend_multimedia_img = new JLabel("");
		vend_multimedia_img.setBounds(268, 34, 293, 269);
		vend_imagem.add(vend_multimedia_img);

		JLabel label_20 = new JLabel("Cadastro");
		label_20.setBounds(139, 331, 78, 14);
		vend_imagem.add(label_20);

		vend_update_img_input = new JTextField();
		vend_update_img_input.setColumns(10);
		vend_update_img_input.setBounds(268, 328, 160, 20);
		vend_imagem.add(vend_update_img_input);

		JButton button_3 = new JButton("Carregar imagem atual");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vend_load_current_image();
			}
		});
		button_3.setBounds(496, 327, 160, 23);
		vend_imagem.add(button_3);

		JButton button_4 = new JButton("Alterar imagem");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vend_update_img();
			}
		});
		button_4.setBounds(496, 353, 160, 23);
		vend_imagem.add(button_4);

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

		// Labels
		JLabel ger_nome_lb = new JLabel("Nome:");
		ger_nome_lb.setBounds(390, 189, 58, 24);
		ger_visualizar.add(ger_nome_lb);

		JLabel ger_login_lb = new JLabel("Login:");
		ger_login_lb.setBounds(390, 237, 58, 24);
		ger_visualizar.add(ger_login_lb);

		JLabel ger_email_lb = new JLabel("Email:");
		ger_email_lb.setBounds(390, 272, 58, 24);
		ger_visualizar.add(ger_email_lb);

		JLabel ger_sal_lb = new JLabel("Salario:");
		ger_sal_lb.setBounds(390, 305, 58, 30);
		ger_visualizar.add(ger_sal_lb);

		JLabel ger_obj_lb = new JLabel("Objetivos:");
		ger_obj_lb.setBounds(390, 340, 58, 30);
		ger_visualizar.add(ger_obj_lb);

		ger_nome_field = new JTextField();
		ger_nome_field.setBounds(458, 191, 301, 20);
		ger_visualizar.add(ger_nome_field);
		ger_nome_field.setEditable(false);

		ger_login_field = new JTextField();
		ger_login_field.setColumns(10);
		ger_login_field.setBounds(458, 239, 301, 20);
		ger_visualizar.add(ger_login_field);
		ger_login_field.setEditable(false);

		ger_email_field = new JTextField();
		ger_email_field.setColumns(10);
		ger_email_field.setBounds(458, 272, 301, 20);
		ger_visualizar.add(ger_email_field);
		ger_email_field.setEditable(false);

		ger_sal_field = new JTextField();
		ger_sal_field.setColumns(10);
		ger_sal_field.setBounds(458, 310, 301, 20);
		ger_visualizar.add(ger_sal_field);
		ger_sal_field.setEditable(false);

		ger_obj_field = new JTextField();
		ger_obj_field.setBounds(390, 370, 370, 20);
		ger_visualizar.add(ger_obj_field);
		ger_obj_field.setEditable(false);
		// -----
		// -----

		ger_list_scroll = new JScrollPane();
		ger_list_scroll.setBounds(31, 30, 325, 308);
		ger_visualizar.add(ger_list_scroll);

		ger_main_listmodel = new DefaultListModel<String>();

		ger_main_list = new JList<String>(ger_main_listmodel);
		ger_list_scroll.setViewportView(ger_main_list);

		ger_main_view = new JButton("Ver");
		ger_main_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view_selected_ger();
			}
		});
		ger_main_view.setBounds(143, 347, 89, 23);
		ger_visualizar.add(ger_main_view);

		ger_img = new JLabel("");
		ger_img.setBackground(Color.WHITE);
		ger_img.setBounds(490, 11, 220, 169);
		ger_visualizar.add(ger_img);

		// ----parametros de inserção
		ger_nome_par = new JTextField();
		ger_nome_par.setBounds(226, 42, 386, 20);
		ger_inserir.add(ger_nome_par);
		ger_nome_par.setColumns(10);

		ger_email_par = new JTextField();
		ger_email_par.setColumns(10);
		ger_email_par.setBounds(226, 75, 386, 20);
		ger_inserir.add(ger_email_par);

		ger_login_par = new JTextField();
		ger_login_par.setColumns(10);
		ger_login_par.setBounds(226, 106, 192, 20);
		ger_inserir.add(ger_login_par);

		ger_senha_par = new JTextField();
		ger_senha_par.setColumns(10);
		ger_senha_par.setBounds(520, 106, 192, 20);
		ger_inserir.add(ger_senha_par);

		ger_obj_par = new JTextField();
		ger_obj_par.setBounds(226, 136, 386, 20);
		ger_inserir.add(ger_obj_par);

		ger_salario_par = new JTextField();
		ger_salario_par.setColumns(10);
		ger_salario_par.setBounds(226, 167, 192, 20);
		ger_inserir.add(ger_salario_par);

		ger_cep_par = new JTextField();
		ger_cep_par.setColumns(10);
		ger_cep_par.setBounds(226, 198, 146, 20);
		ger_inserir.add(ger_cep_par);

		ger_log_par = new JTextField();
		ger_log_par.setColumns(10);
		ger_log_par.setBounds(226, 230, 192, 20);
		ger_inserir.add(ger_log_par);

		ger_comp_par = new JTextField();
		ger_comp_par.setColumns(10);
		ger_comp_par.setBounds(226, 261, 192, 20);
		ger_inserir.add(ger_comp_par);

		ger_bairro_par = new JTextField();
		ger_bairro_par.setColumns(10);
		ger_bairro_par.setBounds(226, 292, 111, 20);
		ger_inserir.add(ger_bairro_par);

		ger_numero_par = new JTextField();
		ger_numero_par.setColumns(10);
		ger_numero_par.setBounds(226, 323, 129, 20);
		ger_inserir.add(ger_numero_par);

		ger_cidade_par = new JTextField();
		ger_cidade_par.setColumns(10);
		ger_cidade_par.setBounds(483, 292, 129, 20);
		ger_inserir.add(ger_cidade_par);

		ger_estado_par = new JTextField();
		ger_estado_par.setColumns(10);
		ger_estado_par.setBounds(483, 323, 129, 20);
		ger_inserir.add(ger_estado_par);

		ger_img_path = new JTextField();
		ger_img_path.setEditable(false);
		ger_img_path.setBounds(226, 358, 192, 20);
		ger_inserir.add(ger_img_path);
		ger_img_path.setColumns(10);

		ger_cadastro_par = new JTextField();
		ger_cadastro_par.setColumns(10);
		ger_cadastro_par.setBounds(226, 11, 192, 20);
		ger_inserir.add(ger_cadastro_par);

		ger_telefone_par = new JTextField();
		ger_telefone_par.setColumns(10);
		ger_telefone_par.setBounds(483, 198, 129, 20);
		ger_inserir.add(ger_telefone_par);
		// --

		JButton select_ger_img = new JButton("Escolher foto");
		select_ger_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_ger_img();
			}
		});
		select_ger_img.setBounds(454, 357, 158, 23);
		ger_inserir.add(select_ger_img);

		JButton ger_cadastrar = new JButton("Cadastrar");
		ger_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ger_insert();
			}

		});
		ger_cadastrar.setBounds(661, 292, 106, 84);
		ger_inserir.add(ger_cadastrar);

		// Labels
		JLabel gerlblCadastro = new JLabel("Cadastro");
		gerlblCadastro.setBounds(81, 14, 111, 14);
		ger_inserir.add(gerlblCadastro);

		JLabel gerlblNome = new JLabel("Nome");
		gerlblNome.setBounds(81, 45, 111, 14);
		ger_inserir.add(gerlblNome);

		JLabel gerlblEmail = new JLabel("Email");
		gerlblEmail.setBounds(81, 75, 111, 14);
		ger_inserir.add(gerlblEmail);

		JLabel gerlblLogin = new JLabel("Login");
		gerlblLogin.setBounds(81, 109, 111, 14);
		ger_inserir.add(gerlblLogin);

		JLabel gerlblSenha = new JLabel("Senha");
		gerlblSenha.setBounds(450, 109, 111, 14);
		ger_inserir.add(gerlblSenha);

		JLabel gerlblObj = new JLabel("Objetivos");
		gerlblObj.setBounds(81, 140, 111, 14);
		ger_inserir.add(gerlblObj);

		JLabel gerlblSalrio = new JLabel("Sal\u00E1rio");
		gerlblSalrio.setBounds(81, 170, 111, 14);
		ger_inserir.add(gerlblSalrio);

		JLabel gerlblCep = new JLabel("CEP");
		gerlblCep.setBounds(81, 201, 93, 14);
		ger_inserir.add(gerlblCep);

		JLabel gerlblNewLabel = new JLabel("Logradouro");
		gerlblNewLabel.setBounds(81, 233, 93, 14);
		ger_inserir.add(gerlblNewLabel);

		JLabel gerlblComplemento = new JLabel("Complemento");
		gerlblComplemento.setBounds(81, 264, 123, 14);
		ger_inserir.add(gerlblComplemento);

		JLabel gerlblKlk = new JLabel("Bairro");
		gerlblKlk.setBounds(81, 295, 70, 14);
		ger_inserir.add(gerlblKlk);

		JLabel gerlblCidade = new JLabel("Cidade");
		gerlblCidade.setBounds(393, 295, 93, 14);
		ger_inserir.add(gerlblCidade);

		JLabel gerlblNumero = new JLabel("Numero");
		gerlblNumero.setBounds(81, 326, 93, 14);
		ger_inserir.add(gerlblNumero);

		JLabel gerlblEstado = new JLabel("Estado");
		gerlblEstado.setBounds(393, 326, 52, 14);
		ger_inserir.add(gerlblEstado);

		JLabel gerlblTelefone = new JLabel("Telefone");
		gerlblTelefone.setBounds(406, 201, 67, 14);
		ger_inserir.add(gerlblTelefone);

		// --

		ger_multimedia_img = new JLabel("");
		ger_multimedia_img.setBounds(250, 52, 293, 269);
		ger_imagem.add(ger_multimedia_img);

		ger_multimedia_input = new JTextField();
		ger_multimedia_input.setBounds(250, 346, 160, 20);
		ger_imagem.add(ger_multimedia_input);
		ger_multimedia_input.setColumns(10);

		JLabel gerlblCadastro_1 = new JLabel("Cadastro");
		gerlblCadastro_1.setBounds(121, 349, 78, 14);
		ger_imagem.add(gerlblCadastro_1);

		JButton ger_load_img = new JButton("Carregar imagem atual");
		ger_load_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ger_load_current_image();
			}

		});
		ger_load_img.setBounds(478, 345, 160, 23);
		ger_imagem.add(ger_load_img);

		JButton ger_set_img = new JButton("Alterar imagem");
		ger_set_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ger_update_img();
			}

		});
		ger_set_img.setBounds(478, 371, 160, 23);
		ger_imagem.add(ger_set_img);

		/*-------------------=Gerente (FIM)=-----------------*/

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

		carro_list_scroll = new JScrollPane();
		carro_list_scroll.setBounds(31, 30, 325, 308);
		carro_visualizar.add(carro_list_scroll);

		carro_main_listmodel = new DefaultListModel<String>();

		carro_main_list = new JList<String>(carro_main_listmodel);
		carro_list_scroll.setViewportView(carro_main_list);

		JLabel carro_codigo_lb = new JLabel("Codigo:");
		carro_codigo_lb.setBounds(390, 189, 58, 24);
		carro_visualizar.add(carro_codigo_lb);

		JLabel carro_marca_lb = new JLabel("Marca:");
		carro_marca_lb.setBounds(390, 219, 58, 24);
		carro_visualizar.add(carro_marca_lb);

		JLabel carro_chassi_lb = new JLabel("Chassi:");
		carro_chassi_lb.setBounds(390, 249, 58, 24);
		carro_visualizar.add(carro_chassi_lb);

		JLabel carro_ano_lb = new JLabel("Ano:");
		carro_ano_lb.setBounds(390, 279, 58, 30);
		carro_visualizar.add(carro_ano_lb);

		JLabel carro_modelo_lb = new JLabel("Modelo:");
		carro_modelo_lb.setBounds(390, 309, 58, 24);
		carro_visualizar.add(carro_modelo_lb);

		JLabel carro_estado_uso_lb = new JLabel("Estado de Uso:");
		carro_estado_uso_lb.setBounds(390, 339, 58, 24);
		carro_visualizar.add(carro_estado_uso_lb);

		JLabel carro_valor_lb = new JLabel("Valor:");
		carro_valor_lb.setBounds(390, 369, 58, 30);
		carro_visualizar.add(carro_valor_lb);

		carro_codigo_field = new JTextField();
		carro_codigo_field.setBounds(458, 191, 301, 20);
		carro_visualizar.add(carro_codigo_field);
		carro_codigo_field.setEditable(false);

		carro_marca_field = new JTextField();
		carro_marca_field.setColumns(10);
		carro_marca_field.setBounds(458, 221, 301, 20);
		carro_visualizar.add(carro_marca_field);
		carro_marca_field.setEditable(false);

		carro_chassi_field = new JTextField();
		carro_chassi_field.setColumns(10);
		carro_chassi_field.setBounds(458, 251, 301, 20);
		carro_visualizar.add(carro_chassi_field);
		carro_chassi_field.setEditable(false);

		carro_ano_field = new JTextField();
		carro_ano_field.setColumns(10);
		carro_ano_field.setBounds(458, 281, 301, 20);
		carro_visualizar.add(carro_ano_field);
		carro_ano_field.setEditable(false);

		carro_modelo_field = new JTextField();
		carro_modelo_field.setColumns(10);
		carro_modelo_field.setBounds(458, 311, 301, 20);
		carro_visualizar.add(carro_modelo_field);
		carro_modelo_field.setEditable(false);

		carro_estado_uso_field = new JTextField();
		carro_estado_uso_field.setColumns(10);
		carro_estado_uso_field.setBounds(458, 341, 301, 20);
		carro_visualizar.add(carro_estado_uso_field);
		carro_estado_uso_field.setEditable(false);

		carro_valor_field = new JTextField();
		carro_valor_field.setColumns(10);
		carro_valor_field.setBounds(458, 371, 301, 20);
		carro_visualizar.add(carro_valor_field);
		carro_valor_field.setEditable(false);

		carro_main_view = new JButton("Ver");
		carro_main_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view_selected_carro();
			}
		});

		carro_main_view.setBounds(143, 347, 89, 23);
		carro_visualizar.add(carro_main_view);

		carro_img = new JLabel("");
		carro_img.setBackground(Color.WHITE);
		carro_img.setBounds(490, 11, 220, 169);
		carro_visualizar.add(carro_img);

		//

		carro_multimedia_img = new JLabel("");
		carro_multimedia_img.setBounds(250, 52, 293, 269);
		carro_imagem.add(carro_multimedia_img);

		carro_multimedia_input = new JTextField();
		carro_multimedia_input.setBounds(250, 346, 160, 20);
		carro_imagem.add(carro_multimedia_input);
		carro_multimedia_input.setColumns(10);

		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(121, 349, 78, 14);
		carro_imagem.add(lblCodigo_1);

		JButton carro_load_img = new JButton("Carregar imagem atual");
		carro_load_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro_load_current_image();
			}
		});
		carro_load_img.setBounds(478, 345, 160, 23);
		carro_imagem.add(carro_load_img);

		JButton carro_set_img = new JButton("Alterar imagem");
		carro_set_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro_update_img();
			}
		});
		carro_set_img.setBounds(478, 371, 160, 23);
		carro_imagem.add(carro_set_img);

		// Parametros para inserir
		carro_codigo_par = new JTextField();
		carro_codigo_par.setBounds(130, 13, 192, 20);
		carro_inserir.add(carro_codigo_par);
		carro_codigo_par.setColumns(10);

		carro_tempo_garantia_par = new JTextField();
		carro_tempo_garantia_par.setColumns(10);
		carro_tempo_garantia_par.setBounds(130, 230, 192, 20);
		carro_inserir.add(carro_tempo_garantia_par);

		carro_valor_par = new JTextField();
		carro_valor_par.setColumns(10);
		carro_valor_par.setBounds(130, 292, 192, 20);
		carro_inserir.add(carro_valor_par);

		carro_chassi_par = new JTextField();
		carro_chassi_par.setColumns(10);
		carro_chassi_par.setBounds(130, 44, 192, 20);
		carro_inserir.add(carro_chassi_par);

		carro_estado_uso_par = new JTextField();
		carro_estado_uso_par.setColumns(10);
		carro_estado_uso_par.setBounds(130, 261, 192, 20);
		carro_inserir.add(carro_estado_uso_par);

		carro_cor_par = new JTextField();
		carro_cor_par.setColumns(10);
		carro_cor_par.setBounds(130, 137, 192, 20);
		carro_inserir.add(carro_cor_par);

		carro_modelo_par = new JTextField();
		carro_modelo_par.setColumns(10);
		carro_modelo_par.setBounds(130, 75, 192, 20);
		carro_inserir.add(carro_modelo_par);

		carro_consumo_par = new JTextField();
		carro_consumo_par.setColumns(10);
		carro_consumo_par.setBounds(130, 199, 192, 20);
		carro_inserir.add(carro_consumo_par);

		carro_freios_par = new JTextField();
		carro_freios_par.setColumns(10);
		carro_freios_par.setBounds(508, 75, 200, 20);
		carro_inserir.add(carro_freios_par);

		carro_marca_par = new JTextField();
		carro_marca_par.setColumns(10);
		carro_marca_par.setBounds(130, 106, 192, 20);
		carro_inserir.add(carro_marca_par);

		carro_ano_par = new JTextField();
		carro_ano_par.setColumns(10);
		carro_ano_par.setBounds(130, 323, 192, 20);
		carro_inserir.add(carro_ano_par);

		carro_sistema_partida_par = new JTextField();
		carro_sistema_partida_par.setColumns(10);
		carro_sistema_partida_par.setBounds(508, 44, 200, 20);
		carro_inserir.add(carro_sistema_partida_par);

		carro_imagem_par = new JTextField();
		carro_imagem_par.setEditable(false);
		carro_imagem_par.setBounds(33, 358, 192, 20);
		carro_inserir.add(carro_imagem_par);
		carro_imagem_par.setColumns(10);

		carro_alarme_par = new JTextField();
		carro_alarme_par.setColumns(10);
		carro_alarme_par.setBounds(508, 106, 200, 20);
		carro_inserir.add(carro_alarme_par);

		carro_cilindradas_par = new JTextField();
		carro_cilindradas_par.setColumns(10);
		carro_cilindradas_par.setBounds(508, 230, 200, 20);
		carro_inserir.add(carro_cilindradas_par);

		carro_porta_malas_par = new JTextField();
		carro_porta_malas_par.setColumns(10);
		carro_porta_malas_par.setBounds(508, 292, 61, 20);
		carro_inserir.add(carro_porta_malas_par);

		carro_quantidade_portas_par = new JTextField();
		carro_quantidade_portas_par.setColumns(10);
		carro_quantidade_portas_par.setBounds(508, 323, 61, 20);
		carro_inserir.add(carro_quantidade_portas_par);

		carro_motor_par = new JTextField();
		carro_motor_par.setColumns(10);
		carro_motor_par.setBounds(508, 13, 200, 20);
		carro_inserir.add(carro_motor_par);

		carro_combustivel_par = new JTextField();
		carro_combustivel_par.setColumns(10);
		carro_combustivel_par.setBounds(130, 167, 192, 20);
		carro_inserir.add(carro_combustivel_par);

		carro_cambio_par = new JTextField();
		carro_cambio_par.setColumns(10);
		carro_cambio_par.setBounds(508, 261, 200, 20);
		carro_inserir.add(carro_cambio_par);

		carro_direcao_par = new JTextField();
		carro_direcao_par.setColumns(10);
		carro_direcao_par.setBounds(508, 167, 200, 20);
		carro_inserir.add(carro_direcao_par);

		carro_air_bag_par = new JTextField();
		carro_air_bag_par.setColumns(10);
		carro_air_bag_par.setBounds(508, 137, 200, 20);
		carro_inserir.add(carro_air_bag_par);

		carro_ar_condicionado_par = new JTextField();
		carro_ar_condicionado_par.setColumns(10);
		carro_ar_condicionado_par.setBounds(508, 199, 200, 20);
		carro_inserir.add(carro_ar_condicionado_par);
		// --

		JButton select_carro_img = new JButton("Escolher foto");
		select_carro_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_carro_img();
			}
		});
		select_carro_img.setBounds(265, 357, 158, 23);
		carro_inserir.add(select_carro_img);

		JButton carro_cadastrar = new JButton("Cadastrar");
		carro_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carro_insert();
			}
		});
		carro_cadastrar.setBounds(611, 310, 106, 84);
		carro_inserir.add(carro_cadastrar);

		// Labels
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(33, 14, 111, 14);
		carro_inserir.add(lblCodigo);

		JLabel lblGarantia = new JLabel("Garantia");
		lblGarantia.setBounds(33, 233, 71, 14);
		carro_inserir.add(lblGarantia);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(33, 292, 81, 14);
		carro_inserir.add(lblValor);

		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(33, 44, 52, 14);
		carro_inserir.add(lblChassi);

		JLabel lblEstadoUso = new JLabel("Estado de Uso");
		lblEstadoUso.setBounds(33, 264, 71, 14);
		carro_inserir.add(lblEstadoUso);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(33, 139, 35, 14);
		carro_inserir.add(lblCor);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(33, 78, 67, 14);
		carro_inserir.add(lblModelo);

		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(33, 201, 71, 14);
		carro_inserir.add(lblConsumo);

		JLabel lblFreios = new JLabel("Freios");
		lblFreios.setBounds(423, 78, 52, 14);
		carro_inserir.add(lblFreios);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(33, 109, 70, 14);
		carro_inserir.add(lblMarca);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(33, 326, 93, 14);
		carro_inserir.add(lblAno);

		JLabel lblPartida = new JLabel("Partida");
		lblPartida.setBounds(423, 47, 93, 14);
		carro_inserir.add(lblPartida);

		JLabel lblCinlindradas = new JLabel("Cilindradas");
		lblCinlindradas.setBounds(423, 233, 52, 14);
		carro_inserir.add(lblCinlindradas);

		JLabel lblMala = new JLabel("Porta Malas");
		lblMala.setBounds(423, 295, 67, 14);
		carro_inserir.add(lblMala);

		JLabel lblPortas = new JLabel("N° de Portas");
		lblPortas.setBounds(423, 326, 111, 14);
		carro_inserir.add(lblPortas);

		JLabel lblMortor = new JLabel("Motor");
		lblMortor.setBounds(423, 16, 111, 14);
		carro_inserir.add(lblMortor);

		JLabel lblCombustivel = new JLabel("Combustivel");
		lblCombustivel.setBounds(33, 170, 93, 14);
		carro_inserir.add(lblCombustivel);

		JLabel lblCambio = new JLabel("Cambio");
		lblCambio.setBounds(423, 264, 123, 14);
		carro_inserir.add(lblCambio);

		JLabel lblAirBag = new JLabel("Airbag");
		lblAirBag.setBounds(423, 139, 70, 14);
		carro_inserir.add(lblAirBag);

		JLabel lblArCondicionado = new JLabel("Ar-condicionado");
		lblArCondicionado.setBounds(423, 201, 81, 14);
		carro_inserir.add(lblArCondicionado);

		JLabel lblDirecao = new JLabel("Direcao");
		lblDirecao.setBounds(423, 170, 46, 14);
		carro_inserir.add(lblDirecao);

		JLabel lblAlarme = new JLabel("Alarme");
		lblAlarme.setBounds(423, 109, 46, 14);
		carro_inserir.add(lblAlarme);
		/*-------------------=Carro (FIM)=-----------------*/

		/*-------------------=Moto=-----------------*/
		JLayeredPane tab_moto = new JLayeredPane();
		tabbedPane.addTab("Motocicleta", null, tab_moto, null);
		tab_moto.setLayout(new BoxLayout(tab_moto, BoxLayout.X_AXIS));

		JTabbedPane abas_moto = new JTabbedPane(JTabbedPane.TOP);
		tab_moto.add(abas_moto);

		JLayeredPane moto_visualizar = new JLayeredPane();
		abas_moto.addTab("Principal", null, moto_visualizar, null);

		// Labels
		JLabel moto_nome_lb = new JLabel("Modelo:");
		moto_nome_lb.setBounds(390, 189, 58, 24);
		moto_visualizar.add(moto_nome_lb);

		JLabel moto_login_lb = new JLabel("Marca:");
		moto_login_lb.setBounds(390, 237, 58, 24);
		moto_visualizar.add(moto_login_lb);

		JLabel moto_email_lb = new JLabel("Codigo:");
		moto_email_lb.setBounds(390, 286, 58, 24);
		moto_visualizar.add(moto_email_lb);

		JLabel moto_sal_lb = new JLabel("Valor:");
		moto_sal_lb.setBounds(390, 340, 58, 30);
		moto_visualizar.add(moto_sal_lb);

		moto_modelo_field = new JTextField();
		moto_modelo_field.setBounds(458, 191, 301, 20);
		moto_visualizar.add(moto_modelo_field);
		moto_modelo_field.setEditable(false);

		moto_marca_field = new JTextField();
		moto_marca_field.setColumns(10);
		moto_marca_field.setBounds(458, 239, 301, 20);
		moto_visualizar.add(moto_marca_field);
		moto_marca_field.setEditable(false);

		moto_codigo_field = new JTextField();
		moto_codigo_field.setColumns(10);
		moto_codigo_field.setBounds(458, 288, 301, 20);
		moto_visualizar.add(moto_codigo_field);
		moto_codigo_field.setEditable(false);

		moto_valor_field = new JTextField();
		moto_valor_field.setColumns(10);
		moto_valor_field.setBounds(458, 345, 301, 20);
		moto_visualizar.add(moto_valor_field);
		moto_valor_field.setEditable(false);
		// -----

		moto_list_scroll = new JScrollPane();
		moto_list_scroll.setBounds(31, 30, 325, 308);
		moto_visualizar.add(moto_list_scroll);

		moto_main_listmodel = new DefaultListModel<String>();

		moto_main_list = new JList<String>(moto_main_listmodel);
		moto_list_scroll.setViewportView(moto_main_list);

		moto_main_view = new JButton("Ver");
		moto_main_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view_selected_moto();
			}
		});
		moto_main_view.setBounds(143, 347, 89, 23);
		moto_visualizar.add(moto_main_view);

		moto_img = new JLabel("");
		moto_img.setBackground(Color.WHITE);
		moto_img.setBounds(490, 11, 220, 169);
		moto_visualizar.add(moto_img);

		JLayeredPane moto_inserir = new JLayeredPane();
		abas_moto.addTab("Inserir", null, moto_inserir, null);

		moto_cod_par = new JTextField();
		moto_cod_par.setBounds(228, 70, 112, 20);
		moto_inserir.add(moto_cod_par);
		moto_cod_par.setColumns(10);

		moto_garantia_par = new JTextField();
		moto_garantia_par.setColumns(10);
		moto_garantia_par.setBounds(489, 70, 112, 20);
		moto_inserir.add(moto_garantia_par);

		moto_val_par = new JTextField();
		moto_val_par.setColumns(10);
		moto_val_par.setBounds(228, 101, 112, 20);
		moto_inserir.add(moto_val_par);

		moto_chassi_par = new JTextField();
		moto_chassi_par.setColumns(10);
		moto_chassi_par.setBounds(489, 101, 112, 20);
		moto_inserir.add(moto_chassi_par);

		moto_cor_par = new JTextField();
		moto_cor_par.setColumns(10);
		moto_cor_par.setBounds(228, 132, 112, 20);
		moto_inserir.add(moto_cor_par);

		moto_modelo_par = new JTextField();
		moto_modelo_par.setColumns(10);
		moto_modelo_par.setBounds(489, 132, 112, 20);
		moto_inserir.add(moto_modelo_par);

		moto_marca_par = new JTextField();
		moto_marca_par.setColumns(10);
		moto_marca_par.setBounds(228, 163, 112, 20);
		moto_inserir.add(moto_marca_par);

		moto_ano_par = new JTextField();
		moto_ano_par.setColumns(10);
		moto_ano_par.setBounds(489, 163, 112, 20);
		moto_inserir.add(moto_ano_par);

		moto_partida_par = new JTextField();
		moto_partida_par.setColumns(10);
		moto_partida_par.setBounds(228, 194, 112, 20);
		moto_inserir.add(moto_partida_par);

		moto_cilindradas_par = new JTextField();
		moto_cilindradas_par.setColumns(10);
		moto_cilindradas_par.setBounds(489, 194, 112, 20);
		moto_inserir.add(moto_cilindradas_par);

		moto_malas_par = new JTextField();
		moto_malas_par.setColumns(10);
		moto_malas_par.setBounds(228, 225, 112, 20);
		moto_inserir.add(moto_malas_par);

		moto_portas_par = new JTextField();
		moto_portas_par.setColumns(10);
		moto_portas_par.setBounds(489, 225, 112, 20);
		moto_inserir.add(moto_portas_par);

		moto_motor_par = new JTextField();
		moto_motor_par.setColumns(10);
		moto_motor_par.setBounds(228, 256, 112, 20);
		moto_inserir.add(moto_motor_par);

		moto_combustivel_par = new JTextField();
		moto_combustivel_par.setColumns(10);
		moto_combustivel_par.setBounds(489, 256, 112, 20);
		moto_inserir.add(moto_combustivel_par);

		moto_consumo_par = new JTextField();
		moto_consumo_par.setColumns(10);
		moto_consumo_par.setBounds(228, 287, 112, 20);
		moto_inserir.add(moto_consumo_par);

		moto_estado_par = new JTextField();
		moto_estado_par.setColumns(10);
		moto_estado_par.setBounds(489, 287, 112, 20);
		moto_inserir.add(moto_estado_par);

		moto_freios_par = new JTextField();
		moto_freios_par.setColumns(10);
		moto_freios_par.setBounds(228, 318, 112, 20);
		moto_inserir.add(moto_freios_par);

		JLabel lblCodigo1 = new JLabel("Codigo");
		lblCodigo1.setBounds(117, 72, 85, 14);
		moto_inserir.add(lblCodigo1);

		JLabel lblGarantia1 = new JLabel("Garantia");
		lblGarantia1.setBounds(403, 73, 76, 14);
		moto_inserir.add(lblGarantia1);

		JLabel lblValor1 = new JLabel("Valor");
		lblValor1.setBounds(117, 104, 85, 14);
		moto_inserir.add(lblValor1);

		JLabel lblChassi1 = new JLabel("Chassi");
		lblChassi1.setBounds(403, 104, 76, 14);
		moto_inserir.add(lblChassi1);

		JLabel lblCor1 = new JLabel("Cor");
		lblCor1.setBounds(117, 135, 101, 14);
		moto_inserir.add(lblCor1);

		JLabel lblModelo1 = new JLabel("Modelo");
		lblModelo1.setBounds(403, 135, 76, 14);
		moto_inserir.add(lblModelo1);

		JLabel lblMarca1 = new JLabel("Marca");
		lblMarca1.setBounds(117, 166, 101, 14);
		moto_inserir.add(lblMarca1);

		JLabel lblAno1 = new JLabel("Ano");
		lblAno1.setBounds(403, 166, 76, 14);
		moto_inserir.add(lblAno1);

		JLabel lblPartida1 = new JLabel("Partida");
		lblPartida1.setBounds(117, 197, 85, 14);
		moto_inserir.add(lblPartida1);

		JLabel lblCilindradas = new JLabel("Cilindradas");
		lblCilindradas.setBounds(403, 197, 76, 14);
		moto_inserir.add(lblCilindradas);

		JLabel lblPortaMalas = new JLabel("Porta Malas");
		lblPortaMalas.setBounds(117, 228, 101, 14);
		moto_inserir.add(lblPortaMalas);

		JLabel lblPortas1 = new JLabel("Portas");
		lblPortas1.setBounds(403, 228, 76, 14);
		moto_inserir.add(lblPortas1);

		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(117, 259, 85, 14);
		moto_inserir.add(lblMotor);

		JLabel lblCombustvel = new JLabel("Combust\u00EDvel");
		lblCombustvel.setBounds(403, 259, 76, 14);
		moto_inserir.add(lblCombustvel);

		JLabel lblConsumo1 = new JLabel("Consumo");
		lblConsumo1.setBounds(117, 290, 101, 14);
		moto_inserir.add(lblConsumo1);

		JLabel lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setBounds(401, 290, 78, 14);
		moto_inserir.add(lblEstado_1);

		JLabel lblFreios1 = new JLabel("Freios");
		lblFreios1.setBounds(117, 321, 85, 14);
		moto_inserir.add(lblFreios1);

		JButton moto_select_img_btn = new JButton("Escolher foto");
		moto_select_img_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				select_moto_img();
			}
		});
		moto_select_img_btn.setBounds(441, 317, 137, 23);
		moto_inserir.add(moto_select_img_btn);

		JButton moto_insert_btn = new JButton("Cadastrar");
		moto_insert_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moto_insert();
			}
		});
		moto_insert_btn.setBounds(648, 256, 101, 84);
		moto_inserir.add(moto_insert_btn);

		JLayeredPane moto_imagem = new JLayeredPane();
		abas_moto.addTab("Multim\u00EDdia", null, moto_imagem, null);

		moto_multimedia_img = new JLabel("");
		moto_multimedia_img.setBounds(250, 52, 293, 269);
		moto_imagem.add(moto_multimedia_img);

		moto_multimedia_input = new JTextField();
		moto_multimedia_input.setBounds(250, 346, 160, 20);
		moto_imagem.add(moto_multimedia_input);
		moto_multimedia_input.setColumns(10);

		JLabel lblCodigo_moto = new JLabel("Codigo");
		lblCodigo_moto.setBounds(121, 349, 78, 14);
		moto_imagem.add(lblCodigo_moto);

		JButton moto_load_img = new JButton("Carregar imagem atual");
		moto_load_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moto_load_current_image();
			}
		});
		moto_load_img.setBounds(478, 345, 160, 23);
		moto_imagem.add(moto_load_img);

		JButton moto_set_img = new JButton("Alterar imagem");
		moto_set_img.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moto_update_img();
			}
		});
		moto_set_img.setBounds(478, 371, 160, 23);
		moto_imagem.add(moto_set_img);

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
		func_sal_field.setText(f.getSalario() + "");

		if (f.getFoto().getImagem() != null) {
			func_img.setIcon(new ImageIcon(f.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			func_img.updateUI();
		} else {
			func_img.setIcon(new ImageIcon());
			func_img.updateUI();
		}
	}

	private void select_func_img() {

		int r = file_chooser.showOpenDialog(func_visualizar);

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
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}

		if (cadastro.equals("") || nome.equals("") || login.equals("")
				|| senha.equals("") || (salario <= 0)) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			try {
				this.comunicacao.cadastrarFuncionario(cadastro, nome, email,
						cep, log, numero, comp, bairro, cidade, estado, fones,
						login, senha, salario, img);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir no Banco de Dados! " + e.getMessage());
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar o arquivo!");
				return;
			}

			JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");

			try {
				funcionarios = this.comunicacao.getFuncionarios();
				updateFuncionarioMainList();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
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

				if (f.getFoto().getImagem() != null) {
					func_multimedia_img.setIcon(new ImageIcon(f.getFoto()
							.getImagem()
							.getScaledInstance(300, 200, Image.SCALE_FAST)));
					func_multimedia_img.updateUI();
				} else {
					JOptionPane.showMessageDialog(null,
							"Esse funcionário não possui foto cadastrada!");
					func_multimedia_img.setIcon(new ImageIcon());
					func_multimedia_img.updateUI();
				}

				did = true;
				return;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
		}

	}

	private void func_update_img() {

		select_func_img();

		if (func_foto == null) {
			return;
		}

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
			func_multimedia_img.setIcon(new ImageIcon(f.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			func_multimedia_img.updateUI();

			JOptionPane.showMessageDialog(null, "Foto atualizada!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}

	}

	/*-----------------=Funcionario(FIM)=-----------------*/

	/*-----------------=Motos=-----------------*/

	private void select_moto_img() {

		int r = file_chooser.showOpenDialog(motos_visualizar);

		if (r == JFileChooser.APPROVE_OPTION) {
			moto_foto = file_chooser.getSelectedFile();
		} else {
			moto_foto = null;
		}

	}

	private void updateMotosMainList() {
		Motocicleta m;

		moto_main_listmodel.clear();

		for (int i = 0; i < motos.size(); i++) {
			m = motos.get(i);
			moto_main_listmodel.addElement(m.getCodigo());
		}

		moto_main_list.setSelectedIndex(0);
		moto_main_list.updateUI();
	}

	private void view_selected_moto() {
		int i = moto_main_list.getSelectedIndex();
		Motocicleta m = motos.get(i);

		moto_modelo_field.setText(m.getModelo());
		moto_marca_field.setText(m.getMarca());
		moto_codigo_field.setText(m.getCodigo());
		moto_valor_field.setText(m.getValor() + "");

		if (m.getImagem().getImagem() != null) {
			moto_img.setIcon(new ImageIcon(m.getImagem().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			moto_img.updateUI();
		} else {
			moto_img.setIcon(new ImageIcon());
			moto_img.updateUI();
		}
	}

	private void moto_insert() {

		String codigo = moto_cod_par.getText();
		String garantia = moto_garantia_par.getText();
		String marca = moto_marca_par.getText();
		String modelo = moto_modelo_par.getText();
		String freios = moto_modelo_par.getText();
		String chassi = moto_chassi_par.getText();
		String cor = moto_cor_par.getText();
		String ano = moto_ano_par.getText();
		String partida = moto_partida_par.getText();
		String cilindradas = moto_cilindradas_par.getText();
		String motor = moto_motor_par.getText();
		String estado = moto_estado_par.getText();
		String consumo = moto_consumo_par.getText();
		String combustivel = moto_combustivel_par.getText();
		double valor = Double.parseDouble(moto_val_par.getText());
		double malas = Double.parseDouble(moto_malas_par.getText());
		int portas = Integer.parseInt(moto_portas_par.getText());

		Imagem img = null;
		try {
			if (moto_foto == null) {
				img = new Imagem("");
			} else {
				img = new Imagem(moto_foto);
			}
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}

		if (codigo.equals("") || chassi.equals("") || valor <= 0 || malas <= 0 || portas <= 0) {
			JOptionPane.showMessageDialog(null, "Preencha os valores corretamente! Código e Chassi são obrigatórios!");
		} else {
			try {
				this.comunicacao.cadastrarMotocicleta(codigo, garantia, valor,
						new Vector<Promocao>(), chassi, estado, cor, modelo,
						consumo, freios, marca, ano, partida, cilindradas,
						malas, portas, motor, combustivel, img);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar o arquivo!");
				return;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir no banco de dados!!");
				return;
			}

			JOptionPane.showMessageDialog(null, "Moto cadastrada!");

			try {
				motos = this.comunicacao.getMotos();
				updateMotosMainList();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			}
		}

	}

	private void moto_load_current_image() {
		String cod = moto_multimedia_input.getText();

		if (cod.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o codigo!");
			return;
		}

		Motocicleta m;
		boolean did = false;

		for (int i = 0; i < motos.size(); i++) {
			m = motos.get(i);
			if (m.getCodigo().equals(cod)) {

				if (m.getImagem().getImagem() != null) {
					moto_multimedia_img.setIcon(new ImageIcon(m.getImagem()
							.getImagem()
							.getScaledInstance(300, 200, Image.SCALE_FAST)));
					moto_multimedia_img.updateUI();
				} else {
					JOptionPane.showMessageDialog(null,
							"Essa moto não possui foto cadastrada!");
					moto_multimedia_img.setIcon(new ImageIcon());
					moto_multimedia_img.updateUI();
				}

				did = true;
				return;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Moto não encontrada!");
		}
	}

	private void moto_update_img() {
		select_moto_img();

		if (func_foto == null) {
			return;
		}

		String cod = moto_multimedia_input.getText();

		if (cod.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o codigo!");
			return;
		}

		Motocicleta f = null;
		boolean did = false;

		for (int i = 0; i < motos.size(); i++) {
			f = motos.get(i);
			if (f.getCodigo().equals(cod)) {
				did = true;
				break;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Moto não encontrada!");
			return;
		}

		try {
			this.comunicacao.setFotoMotocicleta(new Imagem(func_foto), f);
			func_multimedia_img.setIcon(new ImageIcon(f.getImagem().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			func_multimedia_img.updateUI();

			JOptionPane.showMessageDialog(null, "Foto atualizada!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}
	}

	/*-----------------=Motos(FIM)=-----------------*/

	/*---------------Gerentes---------------------*/
	private void view_selected_ger() {
		int i = ger_main_list.getSelectedIndex();
		Gerente g = gerentes.get(i);

		ger_nome_field.setText(g.getNome());
		ger_login_field.setText(g.getLogin());
		ger_email_field.setText(g.getEmail());
		ger_sal_field.setText(g.getSalario() + "");
		ger_obj_field.setText(g.getObjetivos());

		if (g.getFoto().getImagem() != null) {
			ger_img.setIcon(new ImageIcon(g.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			ger_img.updateUI();
		} else {
			ger_img.setIcon(new ImageIcon());
			ger_img.updateUI();
		}
	}

	private void ger_load_current_image() {
		String cad = ger_multimedia_input.getText();

		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}

		Gerente g;
		boolean did = false;

		for (int i = 0; i < gerentes.size(); i++) {
			g = gerentes.get(i);
			if (g.getCadastro().equals(cad)) {

				if (g.getFoto().getImagem() != null) {
					ger_multimedia_img.setIcon(new ImageIcon(g.getFoto()
							.getImagem()
							.getScaledInstance(300, 200, Image.SCALE_FAST)));
					ger_multimedia_img.updateUI();
				} else {
					JOptionPane.showMessageDialog(null,
							"Esse funcionário não possui foto cadastrada!");
					ger_multimedia_img.setIcon(new ImageIcon());
					ger_multimedia_img.updateUI();
				}

				did = true;
				return;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Gerente não encontrado!");
		}

	}

	private void ger_update_img() {
		select_ger_img();

		if (ger_foto == null) {
			return;
		}

		String cad = ger_multimedia_input.getText();

		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}

		Gerente g = null;
		boolean did = false;

		for (int i = 0; i < gerentes.size(); i++) {
			g = gerentes.get(i);
			if (g.getCadastro().equals(cad)) {
				did = true;
				break;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
			return;
		}

		try {
			this.comunicacao.setFotoGerente(new Imagem(ger_foto), g);
			ger_multimedia_img.setIcon(new ImageIcon(g.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			ger_multimedia_img.updateUI();

			JOptionPane.showMessageDialog(null, "Foto atualizada!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}

	}

	private void select_ger_img() {

		int r = file_chooser.showOpenDialog(ger_visualizar);

		if (r == JFileChooser.APPROVE_OPTION) {
			ger_foto = file_chooser.getSelectedFile();
		} else {
			ger_foto = null;
		}

	}

	private void ger_insert() {
		String cadastro = ger_cadastro_par.getText();
		String nome = ger_nome_par.getText();
		String email = ger_email_par.getText();
		String login = ger_login_par.getText();
		String senha = ger_senha_par.getText();
		String obj = ger_obj_par.getText();
		double salario = Double.parseDouble(ger_salario_par.getText());
		String cep = ger_cep_par.getText();
		String log = ger_log_par.getText();
		String numero = ger_numero_par.getText();
		String cidade = ger_cidade_par.getText();
		String bairro = ger_bairro_par.getText();
		String estado = ger_estado_par.getText();
		String comp = ger_comp_par.getText();

		Vector<String> fones = new Vector<String>();

		fones.add(ger_telefone_par.getText());

		Imagem img = null;
		try {
			if (ger_foto == null) {
				img = new Imagem("");
			} else {
				img = new Imagem(ger_foto);
			}
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}

		if (cadastro.equals("") || nome.equals("") || login.equals("")
				|| senha.equals("") || (salario <= 0) || obj.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			try {
				this.comunicacao.cadastrarGerente(cadastro, nome, email, cep,
						log, numero, comp, bairro, cidade, estado, fones,
						login, senha, salario, img, obj);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir no Banco de Dados! " + e.getMessage());
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar o arquivo!");
				return;
			}

			JOptionPane.showMessageDialog(null, "Gerente cadastrado!");

			try {
				gerentes = this.comunicacao.getGerentes();
				updateGerentesMainList();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			}
		}

	}

	private void updateGerentesMainList() {
		Gerente g;

		ger_main_listmodel.clear();

		for (int i = 0; i < gerentes.size(); i++) {
			g = gerentes.get(i);
			ger_main_listmodel.addElement(g.getCadastro());
		}

		ger_main_list.setSelectedIndex(0);
		ger_main_list.updateUI();
	}

	/*-----------Gerentes FIM-----------*/

	/*-----------------=Vendedor=-----------------*/
	private void updateVendedoresMainList() {
		Vendedor v;

		vend_main_listmodel.clear();

		for (int i = 0; i < vendedores.size(); i++) {
			v = vendedores.get(i);
			vend_main_listmodel.addElement(v.getCadastro());
		}

		vend_main_list.setSelectedIndex(0);
		vend_main_list.updateUI();
	}

	private void view_selected_vend() {
		int i = vend_main_list.getSelectedIndex();
		Vendedor v = vendedores.get(i);

		vend_nome_field.setText(v.getNome());
		vend_login_field.setText(v.getLogin());
		vend_email_field.setText(v.getEmail());
		vend_salario_field.setText(v.getSalario() + "");

		if (v.getFoto().getImagem() != null) {
			vend_img.setIcon(new ImageIcon(v.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			vend_img.updateUI();
		} else {
			vend_img.setIcon(new ImageIcon());
			vend_img.updateUI();
		}
	}

	private void select_vend_img() {

		int r = file_chooser.showOpenDialog(vend_visualizar);

		if (r == JFileChooser.APPROVE_OPTION) {
			vend_foto = file_chooser.getSelectedFile();
		} else {
			vend_foto = null;
		}

	}

	private void vend_insert() {
		String cadastro = vend_cad_par.getText();
		String nome = vend_nome_par.getText();
		String email = vend_email_par.getText();
		String login = vend_login_par.getText();
		String senha = vend_senha_par.getText();
		double salario = Double.parseDouble(vend_sal_par.getText());
		String cep = vend_cep_par.getText();
		String log = vend_logra_par.getText();
		String numero = vend_num_par.getText();
		String cidade = vend_cidade_par.getText();
		String bairro = vend_bairro_par.getText();
		String estado = vend_estado_par.getText();
		String comp = vend_comple_par.getText();
		String superv = vend_superv_par.getText();
		Vector<String> fones = new Vector<String>();
		fones.add(vend_tel_par.getText());
		Imagem img = null;
		
		try {
			if (vend_foto == null) {
				img = new Imagem("");
			} else {
				img = new Imagem(vend_foto);
			}
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}
		
		if (cadastro.equals("") || nome.equals("") || login.equals("")
				|| senha.equals("") || (salario <= 0) || superv.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			try {
				this.comunicacao.cadastrarVendedor(cadastro, nome, email, cep,
						log, numero, comp, bairro, cidade, estado, fones,
						login, senha, salario, img, superv);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir no Banco de Dados! " + e.getMessage());
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar o arquivo!");
				return;
			}
			JOptionPane.showMessageDialog(null, "Vendedor cadastrado!");
			try {
				vendedores = this.comunicacao.getVendedores();
				updateVendedoresMainList();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			}
		}
	}

	private void vend_load_current_image() {
		String cad = vend_update_img_input.getText();

		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}

		Vendedor v;
		boolean did = false;

		for (int i = 0; i < vendedores.size(); i++) {
			v = vendedores.get(i);
			if (v.getCadastro().equals(cad)) {

				if (v.getFoto().getImagem() != null) {
					vend_multimedia_img.setIcon(new ImageIcon(v.getFoto()
							.getImagem()
							.getScaledInstance(300, 200, Image.SCALE_FAST)));
					vend_multimedia_img.updateUI();
				} else {
					JOptionPane.showMessageDialog(null,
							"Esse vendedor não possui foto cadastrada!");
					vend_multimedia_img.setIcon(new ImageIcon());
					vend_multimedia_img.updateUI();
				}

				did = true;
				return;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Vendedor não encontrado!");
		}

	}

	private void vend_update_img() {

		select_vend_img();

		if (vend_foto == null) {
			return;
		}

		String cad = vend_update_img_input.getText();

		if (cad.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cadastro!");
			return;
		}

		Vendedor f = null;
		boolean did = false;

		for (int i = 0; i < vendedores.size(); i++) {
			f = vendedores.get(i);
			if (f.getCadastro().equals(cad)) {
				did = true;
				break;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Vendedor não encontrado!");
			return;
		}

		try {
			this.comunicacao.setFotoVendedor(new Imagem(vend_foto), f);
			vend_multimedia_img.setIcon(new ImageIcon(f.getFoto().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			vend_multimedia_img.updateUI();

			JOptionPane.showMessageDialog(null, "Foto atualizada!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}

	}

	/*-----------------=Funcionario(FIM)=-----------------*/

	// ---------------------------Carro-------------------------
	private void updateCarrosMainList() {
		Carro c;

		carro_main_listmodel.clear();

		for (int i = 0; i < carros.size(); i++) {
			c = carros.get(i);
			carro_main_listmodel.addElement(c.getCodigo());
		}

		func_main_list.setSelectedIndex(0);
		func_main_list.updateUI();
	}

	private void view_selected_carro() {
		int i = carro_main_list.getSelectedIndex();
		Carro c = carros.get(i);
		carro_modelo_field.setText(c.getModelo());
		carro_marca_field.setText(c.getMarca());
		carro_valor_field.setText("" + c.getValor());
		carro_ano_field.setText(c.getAno());
		carro_chassi_field.setText(c.getChassi());
		carro_codigo_field.setText(c.getCodigo());
		carro_estado_uso_field.setText(c.getEstado_uso() + "");

		if (c.getImagem().getImagem() != null) {
			carro_img.setIcon(new ImageIcon(c.getImagem().getImagem()
					.getScaledInstance(204, 169, Image.SCALE_FAST)));
			carro_img.updateUI();
		} else {
			carro_img.setIcon(new ImageIcon());
			carro_img.updateUI();
		}
	}

	private void select_carro_img() {

		int r = file_chooser.showOpenDialog(carro_visualizar);

		if (r == JFileChooser.APPROVE_OPTION) {
			carro_foto = file_chooser.getSelectedFile();
		} else {
			carro_foto = null;
		}

	}

	private void carro_insert() {

		String codigo = carro_codigo_par.getText();
		String tempo_garantia = carro_tempo_garantia_par.getText();
		double valor = Double.parseDouble(carro_valor_par.getText());
		String chassi = carro_chassi_par.getText();
		String estado_uso = carro_estado_uso_par.getText();
		String cor = carro_cor_par.getText();
		String modelo = carro_modelo_par.getText();
		String consumo = carro_consumo_par.getText();
		String freios = carro_freios_par.getText();
		String marca = carro_marca_par.getText();
		String ano = carro_ano_par.getText();
		String sistema_partida = carro_sistema_partida_par.getText();
		String cilindradas = carro_cilindradas_par.getText();
		double porta_malas = Double
				.parseDouble(carro_porta_malas_par.getText());
		int quantidade_portas = Integer.parseInt(carro_quantidade_portas_par
				.getText());
		String motor = carro_motor_par.getText();
		String combustivel = carro_combustivel_par.getText();
		String alarme = carro_alarme_par.getText();
		String cambio = carro_cambio_par.getText();
		String direcao = carro_direcao_par.getText();
		String air_bag = carro_air_bag_par.getText();
		String ar_condicionado = carro_ar_condicionado_par.getText();

		Vector<Promocao> lista_promocoes = new Vector<Promocao>();
		;

		Imagem img = null;
		try {
			if (carro_foto == null) {
				img = new Imagem("");
			} else {
				img = new Imagem(carro_foto);
			}
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
			return;
		}

		if (codigo.equals("") || valor <= 0
				|| chassi.equals("") || porta_malas <= 0 || quantidade_portas <= 0
				|| alarme.equals("") || cambio.equals("") || direcao.equals("")
				|| air_bag.equals("") || ar_condicionado.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		} else {
			try {
				this.comunicacao.cadastrarCarro(codigo, tempo_garantia, valor,
						lista_promocoes, chassi, estado_uso, cor, modelo,
						consumo, freios, marca, ano, sistema_partida,
						cilindradas, porta_malas, quantidade_portas, motor,
						combustivel, img, alarme, cambio, direcao, air_bag,
						ar_condicionado);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir no Banco de Dados! " + e.getMessage());
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar o arquivo!");
				return;
			}

			JOptionPane.showMessageDialog(null, "Carro cadastrado!");

			try {
				carros = this.comunicacao.getCarros();
				updateCarrosMainList();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao recarregar os dados!");
			}
		}

	}

	private void carro_load_current_image() {
		String cod = carro_multimedia_input.getText();

		if (cod.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o codigo!");
			return;
		}

		Carro c;
		boolean did = false;

		for (int i = 0; i < carros.size(); i++) {
			c = carros.get(i);
			if (c.getCodigo().equals(cod)) {

				if (c.getImagem().getImagem() != null) {
					carro_multimedia_img.setIcon(new ImageIcon(c.getImagem()
							.getImagem()
							.getScaledInstance(300, 200, Image.SCALE_FAST)));
					carro_multimedia_img.updateUI();
				} else {
					JOptionPane.showMessageDialog(null,
							"Esse carro não possui imagem cadastrada!");
					carro_multimedia_img.setIcon(new ImageIcon());
					carro_multimedia_img.updateUI();
				}

				did = true;
				return;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Carro não encontrado!");
		}

	}

	private void carro_update_img() {

		select_carro_img();

		if (carro_foto == null) {
			return;
		}

		String cod = carro_multimedia_input.getText();

		if (cod.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o código!");
			return;
		}

		Carro c = null;
		boolean did = false;

		for (int i = 0; i < carros.size(); i++) {
			c = carros.get(i);
			if (c.getCodigo().equals(cod)) {
				did = true;
				break;
			}
		}

		if (!did) {
			JOptionPane.showMessageDialog(null, "Carro não encontrado!");
			return;
		}

		try {
			this.comunicacao.setFotoCarro(new Imagem(carro_foto), c);
			carro_multimedia_img
					.setIcon(new ImageIcon(c.getImagem().getImagem()
							.getScaledInstance(204, 169, Image.SCALE_FAST)));
			carro_multimedia_img.updateUI();

			JOptionPane.showMessageDialog(null, "Imagem atualizada!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao inserir no Banco de Dados!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
		}

	}
	/*-----------------=Carro(FIM)=-----------------*/

}
