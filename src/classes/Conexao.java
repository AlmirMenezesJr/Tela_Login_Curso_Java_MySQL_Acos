package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// variaveis
	
	private static String caminho = "jdbc:mysql://localhost/db_dec";
	private static String user = "root";
	private static String senha = "Jrwii1.@";
	
	
	//tratamento de erro com banco de dados;
	
	public static Connection faz_conexao() throws SQLException {
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(caminho, user, senha);
			
			
		} catch (ClassNotFoundException e) {
			
			
			throw new SQLException(e.getException());
		}
		
	}
	
	
}
