package by.tms.project.model.dao.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.model.connection.ConnectionPool;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.dao.UserDao;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import by.tms.project.model.util.security.PasswordEncryptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ShchebetovaEK
 *
 * class UserDaoImpl.
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_ALL = """
            SELECT id,role,login,password,first_name,last_name,
            data_birthday,address,phone_number,email  
            FROM users""";
    private static final String SQL_SELECT_BY_ID = """ 
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users
            WHERE users.id =?""";
    private static final String SQL_SELECT_BY_LOGIN = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.login =?""";
    private static final String SQL_SELECT_BY_LOGIN_AND_PASSWORD = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.login =? 
            AND users.password = ?"""; //todo password hash

    private static final String SQL_SELECT_BY_FIRST_NAME = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.first_name=?""";
    private static final String SQL_SELECT_BY_LAST_NAME = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.last_name =?""";
    private static final String SQL_SELECT_BY_EMAIL = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.email =?""";
    private static final String SQL_SELECT_BY_DATA_BIRTHDAY = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.data_birthday =?""";
    private static final String SQL_SELECT_BY_PHONE_NUMBER = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users
            WHERE users.phone_number=?""";
    private static final String SQL_SELECT_BY_FIRST_NAME_AND_ROLE = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.first_name =?  
            AND users.role=?""";
    private static final String SQL_SELECT_BY_LAST_NAME_AND_ROLE = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.last_name =? 
            AND users.role=?""";
    private static final String SQL_SELECT_ALL_BY_ROLE = """
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email 
            FROM users 
            WHERE users.role =?""";
    private static final String SQL_SET_LOGIN = """
            UPDATE users 
            SET users.login=? 
            WHERE users.id=?""";

    //todo
    private static final String SQL_SET_PASSWORD = """
            UPDATE users 
            SET users.password=? 
            WHERE users.id=?""";
    private static final String SQL_CREATE_USER = """
            INSERT INTO users(role,login,password,first_name,last_name,
            data_birthday,address,phone_number,email)
            VALUES (?,?,?,?,?,?,?,?,?)""";

    private static final String SQL_UPDATE_USER = """
            UPDATE users 
            SET users.role=?,users.login=?,users.password=?,users.first_name=?,
            users.last_name=?,users.data_birthday=?,users.address=?,users.phone_number=?,users.email=? 
            WHERE users.id=?""";
    private static final String SQL_DELETE_USER_BY_ID = """
            DELETE FROM users 
            WHERE users.id =?""";
    private static final String SQL_CHECK_BY_LOGIN_PASSWORD = """ 
            SELECT users.id,users.role,users.login,users.password,users.first_name,users.last_name,
            users.data_birthday,users.address,users.phone_number,users.email
            FROM users
            WHERE users.login =?
            AND  users.password =? """;
    private static final String SQL_CHECK_OLD_PASSWORD = """
            SELECT users.password
            FROM users 
            WHERE users.id=? 
            AND users.login=?""";
    private static final String SQL_BY_CURRENT_LOGIN = """
            SELECT users.id,users.login 
            FROM users 
            WHERE users.login=?""";

    private static final String SQL_UPDATE_USER_FIRST_NAME = """
            UPDATE users 
            SET first_name 
            WHERE id =?""";
    private static final String SQL_UPDATE_USER_LAST_NAME = """
            UPDATE users 
            SET last_name 
            WHERE id =?""";
    private static final String SQL_UPDATE_USER_EMAIL = """
            UPDATE users 
            SET email 
            WHERE id =?""";
    private static final String SQL_UPDATE_USER_ADDRESS = """
            UPDATE users 
            SET address
            WHERE id =?""";
    private static final String SQL_UPDATE_USER_PHONE_NUMBER = """
            UPDATE users 
            SET phone_number 
            WHERE id =?""";
    private static final String SQL_UPDATE_USER_DATA_BIRTHDAY = """
            UPDATE users 
            SET data_birthday 
            WHERE id =?""";

    private static UserDaoImpl instance;

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    /**
     * find all users.
     *
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findAll", e);
            throw new DaoException("Failed at UserDaoImpl at method findAll", e);
        }
        return userList;
    }

    /**
     * find all users with same id.
     *
     * @param id
     * @return optionalUser.
     * @throws DaoException
     */
    @Override
    public Optional<User> findById(Long id) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findById", e);
            throw new DaoException("Failed at UserDaoImpl at method findById", e);
        }
        return optionalUser;
    }

    /**
     * create user.
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean create(User entity) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER)) {
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
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method create", e);
            throw new DaoException("Failed at UserDaoImpl at method create", e);
        }
        return (result > 0);
    }

    /**
     * update user
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean update(User entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER)) {
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
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method update", e);
            throw new DaoException("Failed at UserDaoImpl at method update", e);
        }
        return (result > 0);
    }

    /**
     * delete user with same login.
     *
     * @param id
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(Long id) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method delete", e);
            throw new DaoException("Failed at UserDaoImpl at method delete", e);
        }
        return (result > 0);
    }

    /**
     * delete user
     *
     * @param entity
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean delete(User entity) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            preparedStatement.setLong(1, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method delete entity", e);
            throw new DaoException("Failed at UserDaoImpl at method delete entity", e);
        }
        return (result > 0);
    }

    /**
     * find user with same login and password.
     *
     * @param login
     * @param passwordHash
     * @return optionalList.
     * @throws DaoException
     */
    @Override
    public Optional<User> findByLoginAndPassword(String login, String passwordHash) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN_AND_PASSWORD)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2,passwordHash);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByLoginAndPassword", e);
            throw new DaoException("Failed at UserDaoImpl at method findByLoginAndPassword", e);
        }
        return optionalUser;
    }

    /**
     * find user with same login
     *
     * @param login
     * @return optionalUser.
     * @throws DaoException
     */
    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByLogin", e);
            throw new DaoException("Failed at UserDaoImpl at method findByLogin", e);
        }
        return optionalUser;
    }

    /**
     * find user with same first name.
     *
     * @param firstName
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findByFirstName(String firstName) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_FIRST_NAME)) {
            preparedStatement.setString(1, firstName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByFirstName", e);
            throw new DaoException("Failed at UserDaoImpl at method findByFirstName", e);
        }
        return userList;
    }

    /**
     * find user with same last name.
     *
     * @param lastName
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findByLastName(String lastName) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LAST_NAME)) {
            preparedStatement.setString(1, lastName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByLastName", e);
            throw new DaoException("Failed at UserDaoImpl at method findByLastName", e);
        }
        return userList;
    }

    /**
     * find user with same role.
     *
     * @param role
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findByRole(Role role) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_BY_ROLE)) {
            preparedStatement.setString(1, role.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByRole", e);
            throw new DaoException("Failed at UserDaoImpl at method findByRole", e);
        }
        return userList;
    }

    /**
     * find user with same first name and role.
     *
     * @param firstName
     * @param role
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findByFirstNameAndRole(String firstName, Role role) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_FIRST_NAME_AND_ROLE)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, role.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByFirstNameAndRole", e);
            throw new DaoException("Failed at UserDaoImpl at method findByFirstNameAndRole", e);
        }
        return userList;
    }

    /**
     * find user with same last name and role.
     *
     * @param lastName
     * @param role
     * @return userList.
     * @throws DaoException
     */
    @Override
    public List<User> findByLastNameAndRole(String lastName, Role role) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LAST_NAME_AND_ROLE)) {
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, role.name());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByLastNameAndRole", e);
            throw new DaoException("Failed at UserDaoImpl at method findByLastNameAndRole", e);
        }
        return userList;
    }

    /**
     * find user with same date birthday.
     *
     * @param dataBirthday
     * @return userList.
     * @throws DaoException
     */

    public List<User> findByDataBirthday(Date dataBirthday) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_DATA_BIRTHDAY)) {
//               Date dataBirthday = new Date(.getDataBirthday().getTime());//
            preparedStatement.setDate(1, dataBirthday); //todo
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = takeUserInfo(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByDataBirthday", e);
            throw new DaoException("Failed at UserDaoImpl at method findByDataBirthday", e);
        }
        return userList;
    }

    /**
     * find user with same email.
     *
     * @param email
     * @return userList.
     * @throws DaoException
     */
    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByEmail", e);
            throw new DaoException("Failed at UserDaoImpl at method findByEmail", e);
        }
        return optionalUser;
    }

    /**
     * find user with same phone number.
     *
     * @param phoneNumber
     * @return optionalList.
     * @throws DaoException
     */
    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PHONE_NUMBER)) {
            preparedStatement.setString(1, phoneNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findByPhoneNumber", e);
            throw new DaoException("Failed at UserDaoImpl at method findByPhoneNumber", e);
        }
        return optionalUser;
    }

    /**
     * exist user with same login.
     *
     * @param login
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean ifExistByLogin(String login) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_BY_CURRENT_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                if (resultSet.getString(ColumnName.USERS_LOGIN).equals(login)) {
                    result = 1;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method ifExistByLogin", e);
            throw new DaoException("Failed at UserDaoImpl at method ifExistByLogin", e);
        }
        return result > 0;

    }

    /**
     * exist user with same email.
     *
     * @param email
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean ifExistByEmail(String email) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                if (resultSet.getString(ColumnName.USERS_EMAIL).equals(email)) {
                    result = 1;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method ifExistByEmail", e);
            throw new DaoException("Failed at UserDaoImpl at method ifExistByEmail", e);
        }
        return (result > 0);
    }

    /**
     * exist user with same phone number.
     *
     * @param phoneNumber
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean ifExistByPhoneNumber(String phoneNumber) throws DaoException {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PHONE_NUMBER)) {
            preparedStatement.setString(1, phoneNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                if (resultSet.getString(ColumnName.USERS_PHONE_NUMBER).equals(phoneNumber)) {
                    result = 1;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method ifExistByPhoneNumber", e);
            throw new DaoException("Failed at UserDaoImpl at method ifExistByPhoneNumber", e);
        }
        return (result > 0);
    }

    /**
     * set  user login.
     *
     * @param user
     * @param login
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean setLogin(User user, String login) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_LOGIN)) {
            preparedStatement.setString(1, login);
            preparedStatement.setLong(2, user.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method setLogin", e);
            throw new DaoException("Failed at UserDaoImpl at method setLogin", e);
        }
        return (result > 0);

    }

    /**
     * set user password.
     *
     * @param user
     * @param password
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean setPassword(User user, String password) throws DaoException {
        int result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_PASSWORD)) {
            String resultPassword = PasswordEncryptor.encrypt(password);
            preparedStatement.setString(1, resultPassword);
            preparedStatement.setString(2, user.getLogin());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method setPassword", e);
            throw new DaoException("Failed at UserDaoImpl at method setPassword", e);
        }
        return (result > 0);

    }

    /**
     * check user old password.
     *
     * @param user
     * @param oldPassword
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    //todo
    public boolean checkOldPassword(User user, String oldPassword) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHECK_OLD_PASSWORD)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                if (BCrypt.checkpw(oldPassword, resultSet.getString(ColumnName.USERS_PASSWORD))) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method checkOldPassword", e);
            throw new DaoException("Failed at UserDaoImpl at method checkOldPassword", e);
        }
        return result;
    }

    /**
     * check user login.
     *
     * @param login
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean checkUserLogin(String login) throws DaoException {
        boolean exist;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                exist = resultSet.next();
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method checkUserLogin", e);
            throw new DaoException("Failed at UserDaoImpl at method checkUserLogin", e);
        }
        return exist;

    }

    /**
     * find user with same login and password.
     *
     * @param login
     * @param passwordSalt
     * @return optionalList.
     * @throws DaoException
     */
    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String passwordSalt) throws DaoException {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PHONE_NUMBER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordSalt);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalUser = Optional.of(takeUserInfo(resultSet));
                }
            }
        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method findUserByLoginAndPassword", e);
            throw new DaoException("Failed at UserDaoImpl at method findUserByLoginAndPassword", e);
        }
        return optionalUser;
    }

    /**
     * change  user's last name by same id.
     *
     * @param id
     * @param firstName
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateFirstNameById(long id, String firstName) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_FIRST_NAME)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updateFirstNameById", e);
            throw new DaoException("Failed at UserDaoImpl at method updateFirstNameById", e);
        }
        return result;
    }

    /**
     * change  user's last name by same id.
     *
     * @param id
     * @param lastName
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateLastNameById(long id, String lastName) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_LAST_NAME)) {
            preparedStatement.setString(1, lastName);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updateLastNameById", e);
            throw new DaoException("Failed at UserDaoImpl at method updateLastNameById", e);
        }
        return result;
    }

    /**
     * change  user's phone number by same id.
     *
     * @param id
     * @param phoneNumber
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updatePhoneNumberById(long id, String phoneNumber) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_PHONE_NUMBER)) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updatePhoneNumberById", e);
            throw new DaoException("Failed at UserDaoImpl at method updatePhoneNumberById", e);
        }
        return result;
    }

    /**
     * change  user's address by same id.
     *
     * @param id
     * @param address
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateAddressById(long id, String address) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_ADDRESS)) {
            preparedStatement.setString(1, address);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updateAddressById", e);
            throw new DaoException("Failed at UserDaoImpl at method updateAddressById", e);
        }
        return result;
    }

    /**
     * change  user's email by same id.
     *
     * @param id
     * @param email
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateEmailById(long id, String email) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_EMAIL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updateEmailById", e);
            throw new DaoException("Failed at UserDaoImpl at method updateEmailById", e);
        }
        return result;
    }

    /**
     * change  user's dataBirthday by same id.
     *
     * @param id
     * @param dataBirthday
     * @return the boolean.
     * @throws DaoException
     */
    @Override
    public boolean updateDataBirthdayById(long id, String dataBirthday) throws DaoException {
        boolean result;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_DATA_BIRTHDAY)) {
            preparedStatement.setString(1, dataBirthday);
            preparedStatement.setLong(2, id);
            result = preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            logger.error("Failed at UserDaoImpl at method updateDataBirthdayById", e);
            throw new DaoException("Failed at UserDaoImpl at method updateDataBirthdayById", e);
        }
        return result;
    }


    public User takeUserInfo(ResultSet resultSet) throws SQLException {
        return (new User.UserBuilder()
                .setId(resultSet.getLong(ColumnName.USERS_ID))
                .setRole(Role.valueOf(resultSet.getString(ColumnName.USERS_ROLE).toUpperCase()))
                .setLogin(resultSet.getString(ColumnName.USERS_LOGIN))
                .setPassword(resultSet.getString(ColumnName.USERS_PASSWORD))
                .setFirstName(resultSet.getString(ColumnName.USERS_FIRST_NAME))
                .setLastName(resultSet.getString(ColumnName.USERS_LAST_NAME))
                .setDataBirthday(Date.valueOf((resultSet.getString(ColumnName.USERS_DATA_BIRTHDAY))))
                .setAddress(resultSet.getString(ColumnName.USERS_ADDRESS))
                .setPhoneNumber(resultSet.getString(ColumnName.USERS_PHONE_NUMBER))
                .setEmail(resultSet.getString(ColumnName.USERS_EMAIL))
                .buildUser());
    }
}