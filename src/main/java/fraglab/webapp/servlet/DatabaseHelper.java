package fraglab.webapp.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseHelper {

    String getMessage() {

        DataSource ds = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        String message = null;
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("select message from sample where id = 1");
            resultSet.next();
            message = resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return message;
    }

}
