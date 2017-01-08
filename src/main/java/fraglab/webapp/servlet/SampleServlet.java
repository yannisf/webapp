package fraglab.webapp.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

public class SampleServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(SampleServlet.class);

//    @Resource(lookup = "java:/postgresDS")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = "N/A";
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, value from test where id = 1");
            resultSet.next();
            value = resultSet.getString("value");
        } catch (Exception e) {
            LOG.info("Exception while executing sample servlet!", e);
        }
        resp.getWriter().println("Received GET request: " + value);

    }
}
