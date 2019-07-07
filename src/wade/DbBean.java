package wade;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

@SuppressWarnings("serial")
public class DbBean implements Serializable{
	private String jdbcUri;
	private String username;
	private String password;
	
	public DbBean () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public boolean isCoonectedOK() {
		try (Connection conn = DriverManager.getConnection(
				jdbcUri, username, password)){
			return !conn.isClosed();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void setJdbcUri(String jdbcUri) {
		this.jdbcUri = jdbcUri;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
