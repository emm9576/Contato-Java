package Control;
import java.sql.*;

public class DAO {
	private Connection conn;
	private String url;
	
	public DAO() {
		String PASS = "senha";
		url = "jdbc:postgresql://localhost/agenda_2b?user=postgres&password=" + PASS;
	}
	
	
	
	public Connection abreConexao() {
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			
			String SQL = "SELECT * FROM contatos";
			
			stmt.execute(SQL);
			stmt.close();
			return conn;
		}
		catch (SQLException	| ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void fechaConexao() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Conexão Fechada");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
