package by.tms.project.model.connection;

import by.tms.project.exception.DaoException;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;

class ConnectionPoolTest {

        ConnectionPool connectionPool;
        Connection connection;

        @BeforeClass
        public void before() throws DaoException {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();

        }

        @Test
        public void testGetInstance() {
            Assert.assertNotNull(connection);
            connectionPool.releaseConnection(connection);
        }

}