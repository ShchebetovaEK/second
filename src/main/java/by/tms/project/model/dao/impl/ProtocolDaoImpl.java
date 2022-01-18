package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProtocolDaoImpl implements ProtocolDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_ALL_PROTOCOL = """
            SELECT 
            FROM protocols
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.discount =?""";
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

    /**
     * find all protocol.
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findAll() throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Protocol protocol = getProtocolInfo(resultSet);
                protocolList.add(protocol);
            }
        } catch (SQLException e) {
            logger.error("Failed at PatientDaoImpl at method findAll", e);
            throw new DaoException("Failed at PatientDaoImpl at method findAll", e);
        }
        return protocolList;
    }

    public Protocol getProtocolInfo(ResultSet resultSet) throws SQLException {
        return (new Protocol.ProtocolBuilder()
                .setProtocolId(resultSet.getLong(ColumnName.PROTOCOLS_PROTOCOL_ID))
                .setProtocolData(LocalDate.parse(resultSet.getString(ColumnName.PROTOCOLS_PROTOCOL_DATA)))
                .setProtocolPayer(Payer.valueOf(resultSet.getString(ColumnName.PROTOCOLS_PROTOCOL_PAYER)))
                .setProtocolCost(resultSet.getBigDecimal(ColumnName.PROTOCOLS_PROTOCOL_COST))
                .buildProtocol());
    }
}
