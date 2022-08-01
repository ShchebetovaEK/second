package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.PatientDao;
import by.tms.project.model.entity.Archiv;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDaoImpl implements PatientDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String PATIENT = "patient";
    private static final String ARCHIV_INACTIV = "inactiv";
    private static final String MIN_BALANCE = "10";
    private static final String SQL_SELECT_ALL_PATIENT = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE users.role =?""";
    private static final String SQL_SELECT_PATIENTS_BY_ID = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE users.id =?""";
    private static final String SQL_SELECT_PATIENTS_BY_INSURANCE = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.insurance =?""";
    private static final String SQL_SELECT_PATIENTS_BY_MONEY_ACCOUNT = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.money_account BETWEEN ? AND ? """;
    private static final String SQL_SELECT_PATIENTS_BY_DISCOUNT = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.discount =?""";
    private static final String SQL_SELECT_PATIENTS_BY_MIN_BALANCE = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.money_account < ?""";
    private static final String SQL_SELECT_PATIENT_BY_LOGIN = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE users.login=?""";
    private static final String SQL_SELECT_PATIENTS_BALANCE_BY_ID = """
            SELECT money_account
            FROM patients
            WHERE users.id =?""";
    private static final String SQL_UPDATE_INSURANCE = """
            UPDATE patients
            SET insurance =?
            WHERE users_id=?""";
    private static final String SQL_UPDATE_DISCOUNT = """
            UPDATE patients
            SET discount =?
            WHERE users_id=? """;
    private static final String SQL_UPDATE_MONEY_ACCOUNT = """
            UPDATE patients
            SET money_account =?
            WHERE users_id=? """;
    private static final String SQL_DELETE_PATIENT_BY_ID = """
            DELETE FROM users 
            WHERE users.id =?""";
    private static final String SQL_CREATE_PATIENT = """
             INSERT INTO patients (insurance, money_account, discount,users_id) 
             VALUES (?,?,?,?)
            """;
    private static final String SQL_CREATE_USER_PATIENT = """
            INSERT INTO users(role,login,password,first_name,last_name,
            data_birthday,address,phone_number,email) 
            VALUES (?,?,?,?,?,?,?,?,?)""";
    private static final String SQL_UPDATE_PATIENT = """
            UPDATE users 
            SET users.role=?,users.login=?,users.password=?,users.first_name=?,
            users.last_name=?,users.data_birthday=?,users.address=?,
            users.phone_number=?,users.email=?,users.archiv=?
            WHERE users.id=?""";
    private static final String SQL_ARCHIV_PATIENT_BY_ID = """
            UPDATE users
            SET archiv = ?
            WHERE users.id=?""";
    private static PatientDaoImpl instance;

    private PatientDaoImpl() {
    }

    /**
     * Get instance
     *
     * @return instance.
     */
    public static PatientDao getInstance() {
        if (instance == null) {
            instance = new PatientDaoImpl();
        }
        return instance;
    }

    /**
     * find all patients.
     *
     * @return patientList.
     * @throws DaoException
     */
    @Override
    public List<Patient> findAll() throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PATIENT)) {
            preparedStatement.setString(1, PATIENT);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = takePatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findAll", e);
        }
        return patientList;
    }

    /**
     * find patient with same id.
     *
     * @param id
     * @return optionalPatient.
     * @throws DaoException
     */
    @Override
    public Optional<Patient> findById(Long id) throws DaoException {
        Optional<Patient> optionalPatient = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalPatient = Optional.of(takePatientInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findById", e);
        }
        return optionalPatient;
    }

    /**
     * create patient.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean create(Patient entity) throws DaoException {
        int result = 0;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER_PATIENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getRole().name());
            preparedStatement.setString(2, entity.getLogin());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getLastName());
            Date dataBirthday = new Date(entity.getDataBirthday().getTime());
            preparedStatement.setDate(6, dataBirthday);
            preparedStatement.setString(7, entity.getAddress());
            preparedStatement.setString(8, entity.getPhoneNumber());
            preparedStatement.setString(9, entity.getEmail());

            result = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int key = -1;
            if (resultSet.next()) {
                key = resultSet.getInt(1);
            }
            PreparedStatement preparedStatementPat = connection.prepareStatement(SQL_CREATE_PATIENT);
            preparedStatementPat.setString(1, String.valueOf(entity.isInsurance()));
            preparedStatementPat.setString(2, String.valueOf(entity.getMoneyAccount()));
            preparedStatementPat.setString(3, String.valueOf(entity.getDiscount()));
            preparedStatementPat.setLong(4, key);
            result = preparedStatementPat.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                logger.error("transaction failed", e);
                throw new DaoException("transaction failed", e);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.info("setAutoCommit true");
            }
        }
        return (result > 0);
    }
//        int result = 0;
//        try (Connection connection = ConnectionPool.getInstance().takeConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_PATIENT)) {
//            preparedStatement.setBoolean(1, entity.isInsurance());
//            preparedStatement.setBigDecimal(2, entity.getMoneyAccount());
//            preparedStatement.setInt(3, entity.getDiscount());
//            result = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DaoException("Failed at PatientDaoImpl at method create", e);
//        }
//        return (result > 0);
//       }
    /**
     * update patient.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean update(Patient entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PATIENT)) {
            preparedStatement.setString(1, String.valueOf(entity.getRole()));
            preparedStatement.setString(2, entity.getLogin());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getLastName());
            Date dataBirthday = new Date(entity.getDataBirthday().getTime());//
            preparedStatement.setDate(6, dataBirthday);
            preparedStatement.setString(7, entity.getAddress());
            preparedStatement.setString(8, entity.getPhoneNumber());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, String.valueOf(entity.getArchiv()));
            preparedStatement.setBoolean(11, entity.isInsurance());
            preparedStatement.setBigDecimal(12, entity.getMoneyAccount());
            preparedStatement.setInt(13, entity.getDiscount());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method update", e);
        }
        return (result > 0);
    }

    /**
     * delete patient with same id.
     *
     * @param id
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(Long id) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PATIENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method delete", e);
        }
        return (result > 0);
    }

    /**
     * delete patient.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(Patient entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PATIENT_BY_ID)) {
            preparedStatement.setLong(1, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method delete entity", e);
        }
        return (result > 0);
    }

    /**
     * find patient with insurance.
     *
     * @param insurance
     * @return patientList.
     * @throws DaoException
     */
    @Override
    public List<Patient> findByInsurance(Boolean insurance) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_INSURANCE)) {
            preparedStatement.setBoolean(1, insurance);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = takePatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findByInsurance", e);
        }
        return patientList;
    }

    /**
     * find patient with minimum money in account.
     *
     * @param
     * @return patientLIst.
     * @throws DaoException
     */
    @Override
    public List<Patient> findByMoneyAccount(long firstRange, long secondRange) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_MONEY_ACCOUNT)) {
            preparedStatement.setLong(1, firstRange);
            preparedStatement.setLong(2, secondRange);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = takePatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findByMoneyAccount", e);
        }
        return patientList;
    }

    @Override
    public List<Patient> findMinBalance(int minBalance) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_MIN_BALANCE)) {
            preparedStatement.setLong(1, minBalance);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = takePatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findMinBalance", e);
        }
        return patientList;
    }

    /**
     * Find patient with discount.
     *
     * @param discount
     * @return patientList.
     * @throws DaoException
     */
    @Override
    public List<Patient> findByDiscount(Integer discount) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_DISCOUNT)) {
            preparedStatement.setInt(1, discount);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Patient patient = takePatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findByDiscount", e);
        }
        return patientList;
    }

    /**
     * find patient with same login.
     *
     * @param login
     * @return optionalpatient.
     * @throws DaoException
     */
    @Override
    public Optional<Patient> findPatientByLogin(String login) throws DaoException {
        Optional<Patient> optionalPatient = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENT_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalPatient = Optional.of(takePatientInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findPatientByLogin", e);
        }
        return optionalPatient;
    }

    @Override
    public Optional<Patient> findPatientById(long id) throws DaoException {
        Optional<Patient> optionalPatient = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalPatient = Optional.of(takePatientInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method findPatientByLogin", e);
        }
        return optionalPatient;
    }

    /**
     * update insurance
     *
     * @param id
     * @param insurance
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateInsurance(long id, Boolean insurance) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_INSURANCE)) {
            preparedStatement.setBoolean(1, insurance);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("Failed at PatientDaoImpl at method updateInsurance", e);
        }
        return result;
    }

    /**
     * update discount
     *
     * @param id
     * @param discount
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateDiscount(long id, Integer discount) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_DISCOUNT)) {
            preparedStatement.setInt(1, discount);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DaoException("Failed at  PatientDaoImpl at method updateDiscount", e);
        }
        return result;
    }

    /**
     * update money account
     *
     * @param id
     * @param moneyAccount
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateMoneyAccount(long id, BigDecimal moneyAccount) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_MONEY_ACCOUNT)) {
            preparedStatement.setBigDecimal(1, moneyAccount);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DaoException("Failed at  PatientDaoImpl at method updateMoneyAccount", e);
        }
        return result;
    }

    @Override
    public boolean updateBalance(long id, BigDecimal balance) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_MONEY_ACCOUNT)) {
            preparedStatement.setBigDecimal(1, balance);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DaoException("Failed at  PatientDaoImpl at method updateMoneyAccount", e);
        }
        return result;
    }

    /**
     * delete patient
     *
     * @param id
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean deletePatient(long id) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PATIENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("Failed at  PatientDaoImpl at method deletePatient", e);
        }
        return result;

    }

    /**
     * archiv Patient with same id
     *
     * @param id
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean archivPatient(long id) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ARCHIV_PATIENT_BY_ID)) {
            preparedStatement.setString(1, ARCHIV_INACTIV);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("Failed at  PatientDaoImpl at method archivPatient", e);
        }
        return result;

    }

    public Patient takePatientInfo(ResultSet resultSet) throws SQLException {
        return (new Patient.PatientBuilder()
                .setId(resultSet.getLong(ColumnName.USERS_ID))
                .setRole(Role.valueOf(resultSet.getString(ColumnName.USERS_ROLE).toUpperCase()))
                .setLogin(resultSet.getString(ColumnName.USERS_LOGIN))
                .setPassword(resultSet.getString(ColumnName.USERS_PASSWORD))
                .setFirstName(resultSet.getString(ColumnName.USERS_FIRST_NAME))
                .setLastName(resultSet.getString(ColumnName.USERS_LAST_NAME))
                .setDataBirthday(Date.valueOf(resultSet.getString(ColumnName.USERS_DATA_BIRTHDAY)))
                .setAddress(resultSet.getString(ColumnName.USERS_ADDRESS))
                .setPhoneNumber(resultSet.getString(ColumnName.USERS_PHONE_NUMBER))
                .setEmail(resultSet.getString(ColumnName.USERS_EMAIL))
                .setArchiv(Archiv.valueOf(resultSet.getString(ColumnName.USERS_ARCHIV).toUpperCase()))
                .setInsurance(resultSet.getBoolean(ColumnName.PATIENTS_INSURANCE))
                .setMoneyAccount(resultSet.getBigDecimal(ColumnName.PATIENTS_MONEY_ACCOUNT))
                .setDiscount(resultSet.getInt(ColumnName.PATIENTS_DISCOUNT))
                .buildPatient());
    }
}
