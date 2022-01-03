package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.PatientDao;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDaoImpl implements PatientDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_PATIENTS_BY_INSURANCE = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.insurance =?
            """;
    private static final String SQL_SELECT_PATIENTS_BY_MONEY_ACCOUNT = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.money_account =?""";
    private static final String SQL_SELECT_PATIENTS_BY_DISCOUNT = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   insurance,money_account,discount
            FROM users
            INNER JOIN patients on users.id = patients.users_id
            WHERE patients.discount =?""";

    private static PatientDaoImpl instance;

    private PatientDaoImpl() {
    }

    public static PatientDao getInstance() {
        if (instance == null) {
            instance = new PatientDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Patient> findAll() throws DaoException {
     //todo
        return null;
    }

    @Override
    public Optional<Patient> findById(Long id) throws DaoException {
      //todo
        return Optional.empty();
    }

    @Override
    public boolean create(Patient entity) throws DaoException {
       //todo
        return false;
    }

    @Override
    public boolean update(Patient entity) throws DaoException {
      //todo
         return false;
    }

    @Override
    public boolean delete(Long entity) throws DaoException {
      // todo
    return false;
    }

    @Override
    public boolean delete(Patient entity) throws DaoException {
      //todo
        return false;
    }

    @Override
    public List<Patient> findByInsurance(Boolean insurance) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_INSURANCE)) {
            preparedStatement.setBoolean(1, insurance);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Patient patient = getPatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return patientList;
    }


    @Override
    public List<Patient> findByMinimumMoneyAccount(BigDecimal moneyAccount) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_MONEY_ACCOUNT)) {
            preparedStatement.setBigDecimal(1, moneyAccount);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Patient patient = getPatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return patientList;
    }

    @Override
    public List<Patient> findByMaxDiscount(Integer discount) throws DaoException {
        List<Patient> patientList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PATIENTS_BY_DISCOUNT)) {
            preparedStatement.setInt(1, discount);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Patient patient = getPatientInfo(resultSet);
                    patientList.add(patient);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return patientList;
    }

    public Patient getPatientInfo(ResultSet resultSet) throws SQLException {
        return (new Patient.PatientBuilder()
                .setId(resultSet.getLong(ColumnName.USERS_ID))
                .setRole(Role.valueOf(resultSet.getString(ColumnName.USERS_ROLE)))
                .setLogin(resultSet.getString(ColumnName.USERS_LOGIN))
                .setPassword(resultSet.getString(ColumnName.USERS_PASSWORD))
                .setFirstName(resultSet.getString(ColumnName.USERS_FIRST_NAME))
                .setLastName(resultSet.getString(ColumnName.USERS_LAST_NAME))
                .setDataBirthday(LocalDate.parse(resultSet.getString(ColumnName.USERS_DATA_BIRTHDAY)))
                .setAddress(resultSet.getString(ColumnName.USERS_ADDRESS))
                .setPhoneNumber(resultSet.getString(ColumnName.USERS_PHONE_NUMBER))
                .setEmail(resultSet.getString(ColumnName.USERS_EMAIL))
                .setInsurance(resultSet.getBoolean(ColumnName.PATIENTS_INSURANCE))
                .setMoneyAccount(resultSet.getBigDecimal(ColumnName.PATIENTS_MONEY_ACCOUNT))
                .setDiscount(resultSet.getInt(ColumnName.PATIENTS_DISCOUNT))
                .buildPatient());
    }
}
