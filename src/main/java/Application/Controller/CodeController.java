package Application.Controller;

import Application.Model.Code;
import Application.Service.CodeDAO;
import DataBase.DatabaseConnection;

import java.sql.Connection;

public class CodeController {
    private final CodeDAO codeDAO;

    public CodeController() {
        Connection connection = DatabaseConnection.getConnection();
        codeDAO = new CodeDAO(connection);
    }

    public void insertCode(Code code) {
        codeDAO.insertCode(code);
    }
}
