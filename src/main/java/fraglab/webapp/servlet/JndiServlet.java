package fraglab.webapp.servlet;

import fraglab.webapp.bean.SampleBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JndiServlet extends HttpServlet {

    private static final String TEST_QUERY = "SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer databaseSaid = 0;
        String environmentSaid = "";
        SampleBean bean = null;
        Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/hsqldb");
            databaseSaid = getInteger(ds);
            environmentSaid = (String) envContext.lookup("message");
            bean = (SampleBean) envContext.lookup("bean/SampleBeanFactory");
            System.out.println("Found bean " + bean.toString());
        } catch (NamingException e) {
            e.printStackTrace();
        }

        resp.getWriter().println("Received GET request");
        resp.getWriter().println(String.format("Database said [%s]", databaseSaid));
        resp.getWriter().println(String.format("Environment said [%s]", environmentSaid));
        resp.getWriter().println(String.format("Bean [%s] has id [%s]", bean.getBeanName(), bean.incrementAndGetId()));
    }

    private Integer getInteger(DataSource ds) {
        Integer databaseSaid = null;
        try (Connection conn = ds.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(TEST_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            databaseSaid = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseSaid;
    }

}
