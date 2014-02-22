package fraglab.webapp.servlet

import groovy.sql.Sql

import javax.naming.Context
import javax.naming.InitialContext
import javax.sql.DataSource

class DatabaseHelper {

    DataSource dataSource

    DataSource getDataSource() {
        if (!dataSource) {
            Context context = new InitialContext()
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/standard")
        }

        dataSource
    }

    String getMessage() {
        new Sql(getDataSource()).firstRow("SELECT message FROM STANDARD").message
    }

}
