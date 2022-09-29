package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Acoes {

	
	private int id;
	private String usuario;
	private String senha;
	
	public Acoes(int id_p) {
		this.id = id_p;
	}
	
	public Acoes(String usu, String sen) {
		this.usuario = usu;
		this.senha = sen;
	}
	
	public Acoes(int id_p, String usu, String sen) {
		this.id = id_p;
		this.usuario = usu;
		this.senha = sen;
	}
	
	public Acoes(int id_p, String usu, String sen, String bus) {
		this.id = id_p;
		this.usuario = usu;
		this.senha = sen;
	}
	
	// início do metodo salvar;
	public void salvar() {
		
		try {
			Connection con = Conexao.faz_conexao();
			
			String sql = "insert into dados_dec(usuario, senha) value(?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!");
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	// fim do metodo salvar
	
	// início do metodo limpar
	public void limpar() {
		
	}
	
	//fim do metodo limpar
	
	//inicio do metodo atualizar
	
	public void atualizar() {
		
		try {
			Connection con = Conexao.faz_conexao();
		
			String sql = "update dados_dec set usuario=?, senha=? where id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			stmt.setInt(3, id);
						
			
			stmt.execute();
		
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!!");

					
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	}
}
	
	//fim do metodo atulizar
	
