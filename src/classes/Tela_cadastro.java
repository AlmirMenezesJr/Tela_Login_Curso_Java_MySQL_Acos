package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Tela_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JButton btnSalvar;
	private JPasswordField pwSenha;
	private JTextField tfBusca;
	private JTable tbDados;
	private JButton btnListarDados;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JMenuBar menuBar;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_cadastro() {
		setResizable(false);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 552);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ações");
		menuBar.add(mnNewMenu);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equals("")|pwSenha.getText().equals("") ){
					
					JOptionPane.showMessageDialog(null, "Informe um Usuário/Senha.");
				
				} else {
					
					Acoes ac = new Acoes(tfUsuario.getText(),pwSenha.getText());				
					ac.salvar();
					
					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
				}
				
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmSalvar);
		
		mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Informe o id.");
				
				} else if(tfUsuario.getText().equals("")|(pwSenha.getText()).equals("") ){
					
					JOptionPane.showMessageDialog(null, "Insira o novo Usuário/Senha!");
				
				} else {
					
					Acoes ac = new Acoes(Integer.parseInt(tfId.getText()), tfUsuario.getText(), pwSenha.getText());
					ac.atualizar();
					
					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
					
				}
				
			}
		});
		mntmAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmAtualizar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id.");
		lblNewLabel.setBounds(40, 60, 130, 30);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(40, 110, 100, 30);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(40, 160, 88, 30);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		tfId = new JTextField();
		tfId.setBounds(140, 60, 101, 30);
		tfId.setEditable(false);
		tfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(140, 110, 200, 30);
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setColumns(10);
		contentPane.add(tfUsuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 341, 696, 67);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(11, 27, 130, 29);
		btnSalvar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equals("")|pwSenha.getText().equals("") ){
					
					JOptionPane.showMessageDialog(null, "Informe um Usuário/Senha.");
				
				} else {
					
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "insert into dados_dec(usuario, senha) value(?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pwSenha.getPassword()));
					
					stmt.execute();
					
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!");
					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		panel.setLayout(null);
		panel.add(btnSalvar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Informe o id.");
				
				} else if(tfUsuario.getText().equals("")|(pwSenha.getText()).equals("") ){
					
					JOptionPane.showMessageDialog(null, "Insira o novo Usuário/Senha!");
				
				} else {
				
				try {
					Connection con = Conexao.faz_conexao();
				
					String sql = "update dados_dec set usuario=?, senha=? where id=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pwSenha.getPassword()));
					stmt.setString(3, tfId.getText());
								
					
					stmt.execute();
				
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!!");

					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
					
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				}
				
			}
		});
		btnAtualizar.setBounds(148, 27, 130, 29);
		btnAtualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Informe o id.");
				
				} else {
				
				
				try {
					Connection con = Conexao.faz_conexao();
				
					String sql = "delete from dados_dec where id=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfId.getText());
								
					stmt.execute();
				
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Objeto de Id (" + tfId.getText() + ") foi excluído com Sucesso!!!");
					
					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				}
				
			}
		});
		btnExcluir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.setBounds(288, 27, 130, 29);
		panel.add(btnExcluir);
		
		pwSenha = new JPasswordField();
		pwSenha.setBounds(140, 160, 200, 30);
		contentPane.add(pwSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16), null));
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(10, 418, 696, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tfBusca = new JTextField();
		tfBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tfBusca.setText("");
				
			}
		});
		tfBusca.setHorizontalAlignment(SwingConstants.CENTER);
		tfBusca.setForeground(new Color(0, 0, 0));
		tfBusca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfBusca.setText("Informe o id.");
		tfBusca.setBounds(150, 27, 136, 30);
		panel_1.add(tfBusca);
		tfBusca.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfBusca.getText().equals("")|tfBusca.getText().equals("Informe o id.") ){
					
					JOptionPane.showMessageDialog(null, "Informe o id.");
				
				} else {
					
					try {
						Connection con = Conexao.faz_conexao();
					
						String sql = "select *from dados_dec where id=?";
					
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, tfBusca.getText());
					
						ResultSet rs = stmt.executeQuery();
					
						while (rs.next()) {
							tfId.setText(rs.getString("id"));
							tfUsuario.setText(rs.getString("usuario"));
							pwSenha.setText(rs.getString("senha"));
						}
					
						rs.close();
						con.close();
					
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		});
		btnAbrir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAbrir.setBounds(10, 27, 130, 30);
		panel_1.add(btnAbrir);
		
		btnListarDados = new JButton("Listar Dados");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
				
					String sql = "select *from dados_dec";
				
					PreparedStatement stmt = con.prepareStatement(sql);
									
					ResultSet rs = stmt.executeQuery();
				
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
						
						modelo.addRow(new Object[] {rs.getString("id"),rs.getString("usuario"),rs.getString("senha")});
						
					}
				
					rs.close();
					con.close();
					tfUsuario.setText("");
					pwSenha.setText("");
					tfId.setText("");
					tfBusca.setText("");
				
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
		});
		btnListarDados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListarDados.setBounds(543, 27, 130, 30);
		panel_1.add(btnListarDados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 696, 100);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Usu\u00E1rio", "Senha"
			}
		));
		scrollPane.setViewportView(tbDados);
	}
	public String getTfBusca() {
		String busca = tfBusca.getText();
		return busca;
		
	}
}
