package problem2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/fas";
				String username = "root";
				String passeword = "";
				connection = DriverManager.getConnection(url, username, passeword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
