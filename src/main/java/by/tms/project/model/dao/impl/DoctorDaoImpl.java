package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.DoctorDao;
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
import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_DOCTORS_CATEGORY = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   category,experience,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.category =?""";
    private static final String SQL_SELECT_DOCTORS_EXPERIENCE = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   category,experience,speciality
            FROM users 
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.experience =?""";
    private static final String SQL_SELECT_DOCTORS_SPECIALITY = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,
                   category,experience,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.speciality =?""";

    private static DoctorDaoImpl instance;

    private DoctorDaoImpl() {
    }

    public static DoctorDao getInstance() {
        if (instance == null) {
            instance = new DoctorDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Doctor> findAll() throws DaoException {
      //todo
        return null;
    }

    @Override
    public Optional<Doctor> findById(Long id) throws DaoException {
      //todo
        return Optional.empty();
    }

    @Override
    public boolean create(Doctor entity) throws DaoException {
     //todo
        return false;
    }

    @Override
    public boolean update(Doctor entity) throws DaoException {
        //todo
        return false;
    }

    @Override
    public boolean delete(Long entity) throws DaoException {
        //todo
        return false;
    }

    @Override
    public boolean delete(Doctor entity) throws DaoException {
       //todo
        return false;
    }

    @Override
    public List<Doctor> findByCategory(Category category) throws DaoException {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_CATEGORY)) {
            preparedStatement.setString(1, String.valueOf(category));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Doctor doctor = getDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return doctorList;
    }



    @Override
    public List<Doctor> findByExperience(Experience experience) throws DaoException {
       List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_EXPERIENCE)) {
            preparedStatement.setString(1, String.valueOf(experience));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Doctor doctor =getDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpeciality(Speciality speciality) throws DaoException {
        List<Doctor> doctorList =new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_SPECIALITY)) {
            preparedStatement.setString(1, String.valueOf(speciality));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Doctor doctor = getDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            logger.error("", e);
            throw new DaoException("", e);
        }
        return doctorList;
    }

    public Doctor getDoctorInfo(ResultSet resultSet) throws SQLException {
        return (new Doctor.DoctorBuilder()
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
                .setCategory(Category.valueOf(resultSet.getString(ColumnName.DOCTORS_CATEGORY)))
                .setExperience(Experience.valueOf(resultSet.getString(ColumnName.DOCTORS_EXPERIENCE)))
                .setSpeciality(Speciality.valueOf(resultSet.getString(ColumnName.DOCTORS_SPECIALITY)))
                .buildDoctor());
    }
}
