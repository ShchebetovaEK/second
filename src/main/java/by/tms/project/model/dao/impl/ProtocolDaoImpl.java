package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.entity.Protocol;

import java.util.List;

public class ProtocolDaoImpl implements ProtocolDao {

    private static ProtocolDaoImpl instance;

    private ProtocolDaoImpl() {
    }

    /**
     * Get instance
     * @return instance.
     */
    public static ProtocolDao getInstance() {
        if (instance == null) {
            instance = new ProtocolDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Protocol> findAll() throws DaoException {
        return null;
    }
}
