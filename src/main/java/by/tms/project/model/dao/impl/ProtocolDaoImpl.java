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
             SELECT protocols.protocol_id, protocols.protocol_data,
             protocols.protocol_payer,protocols.protocol_cost,
             FROM protocols
             INNER JOIN patients on users.id = patients.users_id
             INNER JOIN doctors on users.id = doctors.users_id
             """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_DATA = """
             SELECT protocols.protocol_id, protocols.protocol_data,
             protocols.protocol_payer,protocols.protocol_cost,
             FROM protocols
             INNER JOIN patients on users.id = patients.users_id
             INNER JOIN doctors on users.id = doctors.users_id
             WHERE protocols.protocol_data=? """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_PATIENT = """
             SELECT protocols.protocol_id, protocols.protocol_data,
             protocols.protocol_payer,protocols.protocol_cost,
             FROM protocols
             INNER JOIN patients on users.id = patients.users_id
             INNER JOIN doctors on users.id = doctors.users_id
             WHERE user.id =?""";
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_DOCTOR = """
             SELECT protocols.protocol_id, protocols.protocol_data,
              protocols.protocol_payer,protocols.protocol_cost,
             FROM protocols
             INNER JOIN patients on users.id = patients.users_id
             INNER JOIN doctors on users.id = doctors.users_id
             WHERE user.id =?""";
    private static ProtocolDaoImpl instance;

    private ProtocolDaoImpl() {
    }

    /**
     * Get instance
     *
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
     *
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
            logger.error("Failed at ProtocolDaoImpl at method findAll", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findAll", e);
        }
        return protocolList;
    }

    /**
     * find all protocol with same data
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByData(LocalDate protocolData) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_DATA)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Protocol protocol = getProtocolInfo(resultSet);
                protocolList.add(protocol);
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByData", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByData", e);
        }
        return protocolList;    }

    /**
     * find all protocol same patient.
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByPatient() throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_PATIENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Protocol protocol = getProtocolInfo(resultSet);
                protocolList.add(protocol);
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByPatient", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByPatient", e);
        }
        return protocolList;
    }

    /**
     * find all protocol same doctor.
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByDoctor() throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_DOCTOR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Protocol protocol = getProtocolInfo(resultSet);
                protocolList.add(protocol);
            }
        } catch (SQLException e) {
            logger.error("Failed at PatientDaoImpl at method findByDoctor", e);
            throw new DaoException("Failed at PatientDaoImpl at method findByDoctor", e);
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
