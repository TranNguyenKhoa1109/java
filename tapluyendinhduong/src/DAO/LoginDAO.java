package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.*;
public class LoginDAO {
   public boolean checkLogin(String username, String password) {
        try (Connection connection = DBConnect.getConnection()) {
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean registerUser(String username, String password) {
        try (Connection connection = DBConnect.getConnection()) {
            String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}
