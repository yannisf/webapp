package fraglab.webapp.servlet;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.Properties;

public class DatabaseHelperTest {

    @Test
    public void databaseTest() {
        DatabaseHelper helper = new DatabaseHelper();
        String version = helper.getVersion();
        System.out.println(version);
    }
}
