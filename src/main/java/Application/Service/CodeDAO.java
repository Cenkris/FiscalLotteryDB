package Application.Service;

import Application.Model.Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CodeDAO {
    private PreparedStatement insertQuery;

    public CodeDAO(Connection connection) {
        try {
            insertQuery = connection.prepareStatement("INSERT INTO codes VALUES (?, ?, ?)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertCode(Code code) {
        try {
            insertQuery.setString(1, code.getId());
            insertQuery.setDate(2, code.getDate());
            insertQuery.setInt(3, code.getAmount());
            insertQuery.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
