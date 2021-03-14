package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private volatile static Connection con;

	private Conexao() {};
	
	public static Connection getConnection(){

		if(con == null) {
			synchronized(Conexao.class) {
				if(con == null) {
					String driver = "org.postgresql.Driver";
					String url = "jdbc:postgresql://localhost:5433/ASS MODA";
					String usuario = "postgres";
					String senha = "abacaxi";
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, usuario, senha);
					}catch (ClassNotFoundException e) {
						System.out.println("Não foi possivel carregar o drive "+e.getMessage());
					} catch (SQLException e) {
						System.out.println("Não foi possível criar a conexão "+e.getMessage());
					}
				}
			}
		}
		
		return con;
		
	}

	
	
	
}

