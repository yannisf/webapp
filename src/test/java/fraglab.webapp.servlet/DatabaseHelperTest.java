package fraglab.webapp.servlet;

import java.sql.*;
import java.util.Properties;

class DatabaseHelper {

    String getVersion() {
        String version = "N/A";
        String url = "jdbc:postgresql://localhost/registry_db";
        Properties props = new Properties();
        props.setProperty("user", "registry_db_user");
        props.setProperty("password", "registry_db_user");
        try (
                Connection connection = DriverManager.getConnection(url, props);
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery("select version()");
            resultSet.next();
            version = resultSet.getString(1);
        } catch (SQLException e) {
            //
        }

        return version;
    }


}
