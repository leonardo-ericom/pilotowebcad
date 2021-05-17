package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao = null;
    
    
    
	/** modulo de conexao **/
	// parametros de conexao
	

	// metodo de conexao
	public static Connection conectar() {
            
            
    /*   String driver = "com.mysql.cj.jdbc.Driver";
       String url = "jdbc:mysql://127.0.0.1:3306/piloto?useTimezone=true&serverTimezone=UTC";
        String user = "root";
	String password = "1234";
*/
     String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/piloto";
                String user = "postgres";
                String password = "123";
                
                
		Connection con = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}}