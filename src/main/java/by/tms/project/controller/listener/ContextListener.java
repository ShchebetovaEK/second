package by.tms.project.controller.listener;

import by.tms.project.model.connection.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContextListener implements ServletContextListener {
        private static final Logger logger = LogManager.getLogger();

        @Override
        public void contextInitialized(ServletContextEvent sce) {
           logger.info("Context was created");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            ConnectionPool.getInstance().destroyPool();
            logger.info("Connection pool has destroyed");
        }
    }

