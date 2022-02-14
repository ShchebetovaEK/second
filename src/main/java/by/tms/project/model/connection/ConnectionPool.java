package by.tms.project.model.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ShchebetovaEK
 * <p>
 * final class ConnectionPool
 */
public final class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final int DEFAULT_POOL_SIZE = 8;
    private static final AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static final ReentrantLock lock = new ReentrantLock();
    private static ConnectionPool instance;
    private final BlockingQueue<ProxyConnection> freeConnections;
    private final BlockingQueue<ProxyConnection> usingConnections;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        usingConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);

        try {
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                ProxyConnection connection = new ProxyConnection(ConnectionFactory.getConnection());
                freeConnections.offer(connection);
            }
        } catch (SQLException e) {
            logger.fatal("Connection is not create.", e);
            throw new RuntimeException("Connection pool is empty.");
        }

    }

    /**
     * Get instance ConnectionPool.
     *
     * @return the ConnectionPool
     */
    public static ConnectionPool getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    /**
     * Get connection from ConnectionPool.
     *
     * @return the connection
     */
    public Connection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            usingConnections.put(connection);
        } catch (InterruptedException e) {
            logger.error("There are some problems with get connection", e);
        }
        return connection;
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     * @return the boolean
     */
    public boolean releaseConnection(Connection connection) {
        if (!(connection instanceof ProxyConnection)) {
            return false;
        }
        try {
            ProxyConnection proxy = (ProxyConnection) connection;
            usingConnections.remove(proxy);
            freeConnections.put(proxy);
        } catch (InterruptedException e) {
            logger.error("There are some problems with release connection", e);
        }
        return true;
    }

    /**
     * Destroy ConnectionPool.
     */
    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().realClose();
            } catch (InterruptedException | SQLException e) {
                logger.error("There are some problems with destroying connection pool", e);
            }
        }
        deregisterDriver();
    }

    /**
     * Deregister driver.
     */
    private void deregisterDriver() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("There are some problems with deregister driver", e);

            }
        });
    }
}