package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProtocolDaoImpl implements ProtocolDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_ALL_PROTOCOL = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                      insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id""";
    private static final String SQL_SELECT_PROTOCOL_BY_ID = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                      insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE protocols.protocol_id=? """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_DATA = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                      insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE protocols.protocol_data=? """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_PAYER = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                   insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE protocols.protocol_payer=? """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_APPLICATION = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                   insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE protocols.application=? """;
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_STATUS = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                   insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE protocols.status=? """;

    private static final String SQL_SELECT_ALL_PROTOCOL_BY_PATIENT = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                   insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE patients_users_id=?;""";
    private static final String SQL_SELECT_ALL_PROTOCOL_BY_DOCTOR = """
            SELECT protocol_id, protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id,
                   insurance, money_account, discount, doctors.users_id, doctors.category, doctors.experience, doctors.speciality, doctors.users_id
            FROM protocols
            INNER JOIN patients on protocols.patients_users_id = patients.users_id
            INNER JOIN doctors on protocols.doctors_users_id = doctors.users_id
            WHERE doctors_users_id=?;""";
    private static final String SQL_CREATE_PROTOCOL = """
            INSERT INTO protocols (protocol_data, protocol_payer, protocol_cost,application,status, patients_users_id, doctors_users_id)
            VALUES (?,?,?,?,?)""";
    private static final String SQL_PATIENT_CREATE_PROTOCOLS = """
            INSERT INTO protocols (protocol_data, protocol_payer,  patients_users_id, doctors_users_id)
            VALUES (?,?,?,?)""";
    private static final String SQL_ADMIN_CREATE_PROTOCOLS = """
            INSERT INTO protocols (protocol_data, protocol_payer, protocol_cost, 
            patients_users_id, doctors_users_id,application)
            VALUES (?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_PROTOCOL_COST = """
            UPDATE  protocols 
            SET protocol_cost=? 
            WHERE protocol_id =?""";
    private static final String SQL_UPDATE_PROTOCOL_APPLICATION = """
            UPDATE  protocols 
            SET application=? 
            WHERE protocol_id =?""";
    private static final String SQL_UPDATE_PROTOCOL_STATUS = """
            UPDATE  protocols 
            SET status=? 
            WHERE protocol_id =?""";
    private static final String SQL_TAKE_PROTOCOL_COST = """
            SELECT SUM(capability_cost) 
            FROM capabilities 
            WHERE forestmed.capabilities.protocols_protocol_id=?""";

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
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findAll", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findAll", e);
        }
        return protocolList;
    }

    /**
     * find protocol with same id
     * @param id
     * @return
     * @throws DaoException
     */
    @Override
    public Optional<Protocol> findById(Long id) throws DaoException {
        Optional<Protocol> optionalProtocol = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PROTOCOL_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalProtocol = Optional.of(takeProtocolInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findById", e);
            throw new DaoException("Failed at ProtocolDaoImpl  at method findById", e);
        }
        return optionalProtocol;
    }

    @Override
    public boolean create(Protocol entity) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_PATIENT_CREATE_PROTOCOLS)) {
            Date protocolData = new Date(entity.getProtocolData().getTime());
            preparedStatement.setDate(1, protocolData);
            preparedStatement.setString(2, String.valueOf(entity.getProtocolPayer()));
            preparedStatement.setLong(3, entity.getDoctorsUsersId());
            preparedStatement.setLong(4, entity.getPatientsUsersId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method create", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method create", e);
        }
        return (result > 0);
    }

    @Override
    public boolean createAdmin(Protocol entity) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADMIN_CREATE_PROTOCOLS)) {
            Date protocolData = new Date(entity.getProtocolData().getTime());
            preparedStatement.setDate(1, protocolData);
            preparedStatement.setString(2, String.valueOf(entity.getProtocolPayer()));
            preparedStatement.setLong(3,entity.getProtocolCost());
            preparedStatement.setLong(4, entity.getDoctorsUsersId());
            preparedStatement.setLong(5, entity.getPatientsUsersId());
            preparedStatement.setString(6, String.valueOf(entity.getApplication()));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method createAdmin", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method createAdmin", e);
        }
        return (result > 0);
    }



    @Override
    public boolean update(Protocol entity) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long entity) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Protocol entity) throws DaoException {
        return false;
    }

    /**
     * find protocol with same payer
     * @param payer
     * @return
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByPayer(Payer payer) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_PAYER)) {
            preparedStatement.setString(1, payer.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByPayer", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByPayer", e);
        }
        return protocolList;
    }

    /**
     * find all protocol with same data
     *
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByData(LocalDate protocolData) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_DATA)) {
            preparedStatement.setDate(1, Date.valueOf(protocolData));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByData", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByData", e);
        }
        return protocolList;
    }

    @Override
    public List<Protocol> findByApplication(Application application) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_APPLICATION)) {
            preparedStatement.setString(1, application.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByApplication ", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByApplication ", e);
        }
        return protocolList;
    }

    @Override
    public List<Protocol> findByStatus(Status status) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_STATUS)) {
            preparedStatement.setString(1, status.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByStatus", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByStatus", e);
        }
        return protocolList;
    }

    /**
     * find all protocol same patient.
     *
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByPatient(long patientId) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_PATIENT)) {
            preparedStatement.setLong(1, patientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (
                SQLException e) {
            logger.error("Failed at ProtocolDaoImpl at method findByPatient", e);
            throw new DaoException("Failed at ProtocolDaoImpl at method findByPatient", e);
        }
        return protocolList;
    }

    /**
     * find all protocol same doctor.
     *
     * @return protocolList.
     * @throws DaoException
     */
    @Override
    public List<Protocol> findByDoctor(long doctorId) throws DaoException {
        List<Protocol> protocolList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PROTOCOL_BY_DOCTOR)) {
            preparedStatement.setLong(1, doctorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Protocol protocol = takeProtocolInfo(resultSet);
                    protocolList.add(protocol);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at  at method findByDoctor", e);
            throw new DaoException("Failed at  at method findByDoctor", e);
        }
        return protocolList;
    }

    /**
     * update protocol cost
     * @param protocolCost
     * @param protocolId
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateProtocolCost(long protocolCost, Long protocolId) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PROTOCOL_COST)) {
            preparedStatement.setLong(1, protocolCost);
            preparedStatement.setLong(2, protocolId);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Failed at  at method updateProtocolCost", e);
            throw new DaoException("Failed at  at method updateProtocolCost", e);
        }
        return result;
    }

    /**
     * update protocol application
     * @param protocolId
     * @param application
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateProtocolApplication(long protocolId, Application application) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PROTOCOL_APPLICATION)) {
            preparedStatement.setString(1, application.name());
            preparedStatement.setLong(2, protocolId);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Failed at  at method updateProtocolApplication", e);
            throw new DaoException("Failed at  at method updateProtocolApplication", e);
        }
        return result;
    }

    /**
     * update protocolstatus
     * @param protocolId
     * @param status
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateProtocolStatus(long protocolId, Status status) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PROTOCOL_STATUS)) {
            preparedStatement.setString(1, status.name());
            preparedStatement.setLong(2, protocolId);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Failed at  at method updateProtocolStatus", e);
            throw new DaoException("Failed at  at method updateProtocolStatus", e);
        }
        return result;
    }

    /** take protocol cost
     *
     * @param protocolId
     * @return boolean.
     * @throws DaoException
     */
    @Override
    public boolean takeProtocolCost(long protocolId) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_TAKE_PROTOCOL_COST)) {
            preparedStatement.setLong(1, protocolId);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Failed at  at method takeProtocolCost", e);
            throw new DaoException("Failed at  at method takeProtocolCost", e);
        }
        return result;
    }

    public Protocol takeProtocolInfo(ResultSet resultSet) throws SQLException {
        return (new Protocol.ProtocolBuilder()
                .setProtocolId(resultSet.getLong(ColumnName.PROTOCOLS_PROTOCOL_ID))
                .setProtocolData(Date.valueOf(resultSet.getString(ColumnName.PROTOCOLS_PROTOCOL_DATA)))
                .setProtocolPayer(Payer.valueOf(resultSet.getString(ColumnName.PROTOCOLS_PROTOCOL_PAYER).toUpperCase()))
                .setProtocolCost(resultSet.getLong(ColumnName.PROTOCOLS_PROTOCOL_COST))
                .setPatientId(resultSet.getLong(ColumnName.PROTOCOLS_PATIENTS_USERS_ID))
                .setDoctorId(resultSet.getLong(ColumnName.PROTOCOLS_DOCTORS_USER_ID))
                .setApplication(Application.valueOf(resultSet.getString(ColumnName.APPLICATION).toUpperCase()))
                .setStatus(Status.valueOf(resultSet.getString(ColumnName.STATUS).toUpperCase()))
                .buildProtocol());
    }
}
