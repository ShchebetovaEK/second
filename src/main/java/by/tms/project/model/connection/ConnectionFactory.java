package by.tms.project.model.connection;

import by.tms.project.model.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final Properties property;
    private static final String DATABASE_URL;
    private static final String DATABASE_URL_PROP = "url";
    private static final String PATH = "prop/dbData.properties";

    static {
        property = PropertyLoader.getProperty(PATH);
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException e){
            logger.error("Driver don't have registration ",e);
        }
        DATABASE_URL = property.getProperty(DATABASE_URL_PROP);
    }

    /**
     * Get connection.
     *
     * @return the connection
     * @throws SQLException the SQL exception
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL,property);
    }

    private ConnectionFactory() {

    }
}
