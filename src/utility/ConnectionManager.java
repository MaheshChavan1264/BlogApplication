package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Properties loadPropertiesFile() throws IOException {
		Properties properties = new Properties();
        InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(input);
        input.close();
        return properties;
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		Properties properties = null;
		
		try {
			properties = loadPropertiesFile();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}