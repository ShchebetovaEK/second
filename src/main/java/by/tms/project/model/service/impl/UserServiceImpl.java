package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.UserDao;
import by.tms.project.model.dao.impl.UserDaoImpl;
import by.tms.project.model.entity.AccessRole;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.util.security.PasswordHash;
import by.tms.project.model.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private UserDao userDao = UserDaoImpl.getInstance();
    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    /**
     * find all user.
     *
     * @return userList.
     * @throws ServiceException
     */
    @Override
    public List<User> findAll() throws ServiceException {
        List<User> userList;
        try {
            userList = userDao.findAll();
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findAll", e);
            throw new ServiceException("Failed at UserServiceImpl at method findAll", e);
        }
        return userList;
    }

    /**
     * find user by login and password.
     *
     * @param login
     * @param password
     * @return optionalUser.
     * @throws ServiceException
     */
    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try {
            if (UserValidatorImpl.getInstance().isLoginValid(login) && UserValidatorImpl.getInstance().isPasswordValid(password)) {
                String passwordHash = PasswordHash.encrypt(password);
                optionalUser = userDao.findByLoginAndPassword(login, passwordHash);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findUserByLoginAndPassword", e);
            throw new ServiceException("Failed at UserServiceImpl at method findUserByLoginAndPassword", e);
        }
        return optionalUser;
    }

    /**
     * find user by login.
     *
     * @param login
     * @return optionalUser.
     * @throws ServiceException
     */
    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try {
            if (UserValidatorImpl.getInstance().isLoginValid(login)) {
                optionalUser = userDao.findByLogin(login);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByLogin", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByLogin", e);
        }
        return optionalUser;
    }

    /**
     * find user by id.
     *
     * @param id
     * @return optionalUser.
     * @throws ServiceException
     */
    @Override
    public Optional<User> findUserById(long id) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try {
            optionalUser = userDao.findById(id);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findUserById", e);
            throw new ServiceException("Failed at UserServiceImpl at method findUserById", e);
        }
        return optionalUser;
    }

    /**
     * find user by first name.
     *
     * @param firstName
     * @return userList
     * @throws ServiceException
     */
    @Override
    public List<User> findByFirstName(String firstName) throws ServiceException {
        List<User> userList = new ArrayList<>();
        try {
            if (UserValidatorImpl.getInstance().isFirstNameValid(firstName)) {
                userList = userDao.findByFirstName(firstName);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByFirstName", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByFirstName", e);
        }
        return userList;
    }

    /**
     * find user by last name
     *
     * @param lastName
     * @return userList.
     * @throws ServiceException
     */
    @Override
    public List<User> findByLastName(String lastName) throws ServiceException {
        List<User> userList = new ArrayList<>();
        try {
            if (UserValidatorImpl.getInstance().isLastNameValid(lastName)) {
                userList = userDao.findByLastName(lastName);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByLastName", e);
            throw new ServiceException("Failed at UserServiceImpl at method  findByLastName", e);
        }
        return userList;
    }

    @Override
    public List<User> searchByLastName(String lastName) throws ServiceException {
        List<User> userList = new ArrayList<>();
        try {
            if (UserValidatorImpl.getInstance().isLastNameValid(lastName)) {
                userList = userDao.searchByLastName(lastName);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method searchByLastName", e);
            throw new ServiceException("Failed at UserServiceImpl at method  searchByLastName", e);
        }
        return userList;
    }

    /**
     * find user by email
     *
     * @param email
     * @return optionalUser.
     * @throws ServiceException
     */
    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try {
            if (UserValidatorImpl.getInstance().isEmailValid(email)) {
                optionalUser = userDao.findByEmail(email);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByEmail", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByEmail", e);
        }
        return optionalUser;
    }


    /**
     * find user by phone number
     *
     * @param phoneNumber
     * @return optionalUser.
     * @throws ServiceException
     */
    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try {
            if (UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber)) {
                optionalUser = userDao.findByPhoneNumber(phoneNumber);
            }
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByPhoneNumber", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByPhoneNumber", e);
        }
        return optionalUser;
    }

    /**
     * register New user
     * @param userCheck
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean registerNewUser(Map<String, String> userCheck) throws ServiceException {
        boolean result;
        Map<String, String> mapUserCheck = new HashMap<>();
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String strData = userCheck.get(DATA_BIRTHDAY);
        Date dataBirthday = java.sql.Date.valueOf(strData);
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);

        mapUserCheck.put(LOGIN, login);
        mapUserCheck.put(PASSWORD, password);
        mapUserCheck.put(FIRST_NAME, firstName);
        mapUserCheck.put(LAST_NAME, lastName);
        mapUserCheck.put(DATA_BIRTHDAY, strData);
        mapUserCheck.put(ADDRESS, address);
        mapUserCheck.put(PHONE_NUMBER, phoneNumber);
        mapUserCheck.put(EMAIL, email);

        try {
            result = UserValidatorImpl.getInstance().checkUserData(mapUserCheck);
            if (result) {
                AccessRole role = AccessRole.PATIENT;
                String passwordHash = PasswordHash.encrypt(password);
                User user = new User(role, login, passwordHash, firstName, lastName, dataBirthday, address, phoneNumber, email);
                userDao.create(user);
            }

        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method registerNewUser", e);
            throw new ServiceException("Failed at UserServiceImpl at method registerNewUser", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at UserServiceImpl in registerNewUser ", e);
            return false;
        }
        return true;
    }

    /**
     * register New Admin
     * @param userCheck
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean registerNewAdmin(Map<String, String> userCheck) throws ServiceException {
        boolean result;
        Map<String, String> mapUserCheck = new HashMap<>();
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String strData = userCheck.get(DATA_BIRTHDAY);
        Date dataBirthday = java.sql.Date.valueOf(strData);
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);

        mapUserCheck.put(LOGIN, login);
        mapUserCheck.put(PASSWORD, password);
        mapUserCheck.put(FIRST_NAME, firstName);
        mapUserCheck.put(LAST_NAME, lastName);
        mapUserCheck.put(DATA_BIRTHDAY, strData);
        mapUserCheck.put(ADDRESS, address);
        mapUserCheck.put(PHONE_NUMBER, phoneNumber);
        mapUserCheck.put(EMAIL, email);

        try {
            result = UserValidatorImpl.getInstance().checkUserData(mapUserCheck);
            if (result) {
                AccessRole role = AccessRole.ADMIN;
                String passwordHash = PasswordHash.encrypt(password);
                User user = new User(role, login, passwordHash, firstName, lastName, dataBirthday, address, phoneNumber, email);
                userDao.create(user);
                //mail
            }

        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method registerNewAdmin", e);
            throw new ServiceException("Failed at UserServiceImpl at method registerNewAdmin", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at UserServiceImpl in registerNewAdmin ", e);
            return false;
        }
        return true;
    }

    /**
     * update user's first name by id.
     *
     * @param id
     * @param firstName
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updateFirstNameById(long id, String firstName) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isFirstNameValid(firstName)
                    && userDao.updateFirstNameById(id, firstName);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateFirstNameById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateFirstNameById", e);
        }
    }

    /**
     * update user's last name by id.
     *
     * @param id
     * @param lastName
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updateLastNameById(long id, String lastName) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isLastNameValid(lastName)
                    && userDao.updateLastNameById(id, lastName);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateLastNameById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateLastNameById", e);
        }
    }

    /**
     * update user's phoneNumber by id.
     *
     * @param id
     * @param phoneNumber
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updatePhoneNumberById(long id, String phoneNumber) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber)
                    && userDao.updatePhoneNumberById(id, phoneNumber);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updatePhoneNumberById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updatePhoneNumberById", e);
        }
    }

    /**
     * update user's address by id.
     *
     * @param id
     * @param address
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updateAddressById(long id, String address) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isAddressValid(address)
                    && userDao.updateAddressById(id, address);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateAddressById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateAddressById", e);
        }
    }

    /**
     * update user's address by id.
     *
     * @param id
     * @param email
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updateEmailById(long id, String email) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isEmailValid(email)
                    && userDao.updateEmailById(id, email);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateEmailById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateEmailById", e);
        }
    }

    /**
     * update user's dataBirthday by id.
     *
     * @param id
     * @param dataBirthday
     * @return the boolean.
     * @throws ServiceException
     */
    @Override
    public boolean updateDataBirthdayById(long id, String dataBirthday) throws ServiceException {
        try {
            return UserValidatorImpl.getInstance().isDataBirthdayValid(dataBirthday)
                    && userDao.updateDataBirthdayById(id, dataBirthday);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateDataBirthdayById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateDataBirthdayById", e);
        }
    }

    /**
     * delete user from database
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean delete(long id) throws ServiceException {
        try {
            return userDao.delete(id);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method delete", e);
            throw new ServiceException("Failed at UserServiceImpl at method delete", e);
        }
    }

    /**
     * input user in archiv
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean archivUser(long id) throws ServiceException {
        try {
            return userDao.archivUser(id);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method archivUser", e);
            throw new ServiceException("Failed at UserServiceImpl at method archivUser", e);
        }
    }
}