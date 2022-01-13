package by.tms.project.model.util.property;

import by.tms.project.model.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ShchebetovaEK
 *
 * final class PropertyLoader
 *
 */
public final class PropertyLoader {
    private static final Logger logger = LogManager.getLogger();

    private PropertyLoader(){}

    /**
     * Get property.
     *
     * @param path
     * @return the property.
     */
    public static Properties getProperty(String path) {
        Properties properties = new Properties();

        try {
            properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            logger.info("Failed in method getProperty", e);
        }
        return properties;
    }
}
