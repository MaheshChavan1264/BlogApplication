package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDao implements UserDaoInterface {

	@Override
	public int signup(User user) {
		String INSERT_USERS_SQL = "insert into users (email, password) values(?,?)";
		int result = 0;
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			System.out.println(statement);
			result = statement.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean loginUser(User user) {
		boolean status = false;
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from users where email = ? and password = ?");
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			status = result.next();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
}
