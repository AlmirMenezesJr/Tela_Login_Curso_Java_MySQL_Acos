package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_acesso extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pwSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_acesso frame = new Tela_de_acesso();
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
	public Tela_de_acesso() {
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(0, 128, 0));
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSenha.setBounds(26, 134, 76, 26);
		contentPane.add(lblSenha);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setForeground(new Color(0, 128, 0));
		lblUsurio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsurio.setBounds(26, 82, 82, 32);
		contentPane.add(lblUsurio);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(118, 85, 185, 26);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pwSenha = new JPasswordField();
		pwSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwSenha.setBounds(118, 134, 185, 26);
		contentPane.add(pwSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = Conexao.faz_conexao();
					
					String sql = "select *from dados_dec where usuario=? and senha=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pwSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						Tela_cadastro exibir = new Tela_cadastro();
						exibir.setVisible(true);
						setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto!");
					}
					stmt.close();
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(119, 185, 128, 32);
		contentPane.add(btnNewButton);
	}
}
