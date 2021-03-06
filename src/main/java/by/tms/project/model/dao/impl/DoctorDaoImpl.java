package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.DoctorDao;
import by.tms.project.model.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ShchebetovaEK
 * <p>
 * class DoctorDaoImpl
 */
public class DoctorDaoImpl implements DoctorDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String DOCTOR = "doctor";
    private static final String ARCHIV_INACTIV = "inactiv";
    private static final String SQL_SELECT_ALL_DOCTORS = """
            SELECT id,role,login,password,first_name,last_name,
            data_birthday,address,phone_number,email,archiv,
            category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE users.role =?""";
    private static final String SQL_SELECT_DOCTORS_BY_ID = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE users.id =?""";
    private static final String SQL_SELECT_DOCTORS_BY_LOGIN = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE users.login =?""";
    private static final String SQL_SELECT_DOCTORS_CATEGORY = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.category =?""";
    private static final String SQL_SELECT_DOCTORS_SPECIALITY = """
            SELECT id,role,login,password,first_name,last_name,
                   data_birthday,address,phone_number,email,archiv,
                   category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.speciality =?""";
    private static final String SQL_UPDATE_CATEGORY = """
            UPDATE doctors
            SET category =?
            WHERE users_id=?""";
    private static final String SQL_UPDATE_SPECIALITY = """
            UPDATE doctors
            SET speciality =?
            WHERE users_id=?""";
    private static final String SQL_DELETE_DOCTOR_BY_ID = """
            DELETE FROM users 
            WHERE users.id =?""";
    private static final String SQL_CREATE_USER_DOCTOR = """
            INSERT INTO users(role,login,password,first_name,last_name,
            data_birthday,address,phone_number,email) 
            VALUES (?,?,?,?,?,?,?,?,?)""";
    private static final String SQL_CREATE_DOCTOR = """
            INSERT INTO doctors(category,speciality,users_id)
            VALUES (?,?,?) """;
    private static final String SQL_UPDATE_DOCTOR = """
            UPDATE users 
            SET users.last_name=?,users.address=?,users.phone_number=?,users.email=? 
            WHERE users.id=?""";
    private static final String SQL_UPDATE_DOCTOR_FIELD = """
            UPDATE users 
            SET users.last_name=?,users.address=?,users.phone_number=?,users.email=? 
            WHERE users.id=?""";
    private static final String SQL_CHOOSE_DOCTOR = """
            SELECT first_name,last_name,category,speciality
            FROM users
            INNER JOIN doctors on users.id = doctors.users_id
            WHERE doctors.category = ?
            AND doctors.speciality = ?""";
    private static final String SQL_ARCHIV_DOCTOR_BY_ID = """
            UPDATE users
            SET archiv = ?
            WHERE users.id=?""";


    private static DoctorDaoImpl instance;

    private DoctorDaoImpl() {
    }

    /**
     * Get instance.
     *
     * @return instance.
     */
    public static DoctorDao getInstance() {
        if (instance == null) {
            instance = new DoctorDaoImpl();
        }
        return instance;
    }

    /**
     * find all doctors.
     *
     * @return doctorList.
     * @throws DaoException
     */
    @Override
    public List<Doctor> findAll() throws DaoException {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_DOCTORS)) {
            preparedStatement.setString(1, DOCTOR);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Doctor doctor = takeDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method findAll", e);
        }
        return doctorList;

    }

    /**
     * find doctor with same id.
     *
     * @param id
     * @return optinalDoctor.
     * @throws DaoException
     */
    @Override
    public Optional<Doctor> findById(Long id) throws DaoException {
        Optional<Doctor> optionalDoctor = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalDoctor = Optional.of(takeDoctorInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method findById", e);
        }
        return optionalDoctor;
    }

    /**
     * create doctor.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean create(Doctor entity) throws DaoException {
        int result = 0;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER_DOCTOR, Statement.RETURN_GENERATED_KEYS);
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
            PreparedStatement preparedStatementDoc = connection.prepareStatement(SQL_CREATE_DOCTOR);
            preparedStatementDoc.setString(1, String.valueOf(entity.getCategory()));
            preparedStatementDoc.setString(2, String.valueOf(entity.getSpeciality()));
            preparedStatementDoc.setLong(3, key);
            result = preparedStatementDoc.executeUpdate();
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

    /**
     * update doctor.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean update(Doctor entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_DOCTOR)) {
            preparedStatement.setString(1, String.valueOf(entity.getRole()));
            preparedStatement.setString(2, entity.getLogin());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getLastName());
            Date dataBirthday = new Date(entity.getDataBirthday().getTime());
            preparedStatement.setDate(6, dataBirthday);
            preparedStatement.setString(7, entity.getAddress());
            preparedStatement.setString(8, entity.getPhoneNumber());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, String.valueOf(entity.getArchiv()));
            preparedStatement.setString(10, String.valueOf(entity.getArchiv()));
            preparedStatement.setString(11, entity.getCategory().name());
            preparedStatement.setString(12, String.valueOf(entity.getSpeciality()));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method update", e);
        }
        return (result > 0);
    }

    /**
     * delete doctor by id
     *
     * @param id
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(Long id) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_DOCTOR_BY_ID)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method delete", e);
        }
        return (result > 0);
    }

    /**
     * delete doctor by id
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(Doctor entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_DOCTOR_BY_ID)) {
            preparedStatement.setLong(1, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method delete entity", e);
        }
        return (result > 0);

    }

    /**
     * find doctor with same category.
     *
     * @param category
     * @return doctorList.
     * @throws DaoException
     */
    @Override
    public List<Doctor> findByCategory(Category category) throws DaoException {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_CATEGORY)) {
            preparedStatement.setString(1, category.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Doctor doctor = takeDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method findByCategory", e);
        }
        return doctorList;
    }

    /**
     * find doctor with same speciality.
     *
     * @param speciality
     * @return doctorList.
     * @throws DaoException
     */
    @Override
    public List<Doctor> findBySpeciality(Speciality speciality) throws DaoException {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_SPECIALITY)) {
            preparedStatement.setString(1, speciality.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Doctor doctor = takeDoctorInfo(resultSet);
                    doctorList.add(doctor);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method findBySpeciality", e);
        }
        return doctorList;
    }

    /**
     * find doctor with same login
     *
     * @param login
     * @return
     * @throws DaoException
     */
    @Override
    public Optional<Doctor> findDoctorByLogin(String login) throws DaoException {
        Optional<Doctor> optionalDoctor = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DOCTORS_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalDoctor = Optional.of(takeDoctorInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method findDoctorByLogin", e);
        }
        return optionalDoctor;
    }

    /**
     * update category
     *
     * @param id
     * @param category
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateCategory(long id, Category category) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_CATEGORY)) {
            preparedStatement.setString(1, category.name());
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DaoException("Failed at  DoctorDaoImpl at method updateCategory", e);
        }
        return result;
    }

    /**
     * update speciality
     *
     * @param id
     * @param speciality
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean updateSpeciality(long id, Speciality speciality) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SPECIALITY)) {
            preparedStatement.setString(1, speciality.name());
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl at method updateSpeciality", e);
        }
        return result;
    }

    /**
     * delete doctor
     *
     * @param id
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean deleteDoctor(long id) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_DOCTOR_BY_ID)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("Failed at  DoctorDaoImpl at method deleteDoctor", e);
        }
        return result;
    }

    /**
     * archiv Doctor with same id
     *
     * @param id
     * @return the boolean
     * @throws DaoException
     */
    @Override
    public boolean archivDoctor(long id) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ARCHIV_DOCTOR_BY_ID)) {
            preparedStatement.setString(1, ARCHIV_INACTIV);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("Failed at DoctorDaoImpl  at method archivDoctor", e);
        }
        return result;
    }

    public Doctor takeDoctorInfo(ResultSet resultSet) throws SQLException {
        return (new Doctor.DoctorBuilder()
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
                .setCategory(Category.valueOf(resultSet.getString(ColumnName.DOCTORS_CATEGORY).toUpperCase()))
                .setSpeciality(Speciality.valueOf(resultSet.getString(ColumnName.DOCTORS_SPECIALITY).toUpperCase()))
                .buildDoctor());
    }
}
