package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.UserDao;
import by.tms.project.model.dao.impl.UserDaoImpl;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.util.security.PasswordEncryptor;
import by.tms.project.model.util.security.PasswordHash;
import by.tms.project.model.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.Instant;
import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;
import static java.lang.Boolean.parseBoolean;

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
                String passwordSalt = PasswordEncryptor.encrypt(password);
                optionalUser = userDao.findByLoginAndPassword(login, passwordSalt);
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
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findByLogin(login);
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
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findById(id);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findUserById", e);
            throw new ServiceException("Failed at UserServiceImpl at method findUserById", e);
        }
        return optionalUser;
    }

    @Override
    public List<User> findByFirstName(String firstName) throws ServiceException {
        List<User> userList;
        try {
            userList = userDao.findByFirstName(firstName);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByFirstName", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByFirstName", e);
        }
        return userList;
    }

    @Override
    public List<User> findByLastName(String lastName) throws ServiceException {
        List<User> userList;
        try {
            userList = userDao.findByLastName(lastName);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByLastName", e);
            throw new ServiceException("Failed at UserServiceImpl at method  findByLastName", e);
        }
        return userList;
    }

//    @Override
//    public List<User> findByDataBirthday(Date dataBirthday) throws ServiceException {
//        List<User> userList;
//        try {
//            userList = userDao.findByDataBirthday(dataBirthday);
//        } catch (DaoException e) {
//            logger.error("Failed at UserServiceImpl at method findByDataBirthday", e);
//            throw new ServiceException("Failed at UserServiceImpl at method  findByDataBirthday", e);
//        }
//        return userList;
//    }

    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findByEmail(email);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByEmail", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByEmail", e);
        }
        return optionalUser;
    }


    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) throws ServiceException {
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findByPhoneNumber(phoneNumber);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method findByPhoneNumber", e);
            throw new ServiceException("Failed at UserServiceImpl at method findByPhoneNumber", e);
        }
        return optionalUser;
    }

    @Override
    public boolean checkIfUserValidForRegistration(String login, String email) throws ServiceException {
        // TODO: 17.01.2022  
        return false;
    }

    @Override
    public boolean registrationUser(String login, String password, String email) throws ServiceException {
        // TODO: 17.01.2022  
        return false;
    }

    @Override
    public void sendMessageRegistrationOnUserEmail(String login, String email, String currentLocale) throws ServiceException {
// TODO: 17.01.2022  
    }

    @Override
    public void setUserNewLogin(String login, String newLogin) throws ServiceException {
        // TODO: 17.01.2022  
    }

    @Override
    public void setUserNewPassword(String login, String newPassword) throws ServiceException {
        // TODO: 17.01.2022  
    }

    @Override
    public boolean registerNewUser(Map<String, String> userCheck) throws ServiceException {
        // TODO
        boolean result;
        Map<String, String> mapUserCheck = new HashMap<>();
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
//        String confirmPassword = userCheck.get(CONFIRM_PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String strData = userCheck.get(DATA_BIRTHDAY);//"2011-11-11";//"userCheck.get(DATA_BIRTHDAY)";
        Instant instant = Instant.parse(strData + "T00:00:00.00Z");
        Date dataBirthday = Date.from(instant);
        //   java.sql.Date dataBirthday = new java.sql.Date(today.getTime());//
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);

//        mapUserCheck.put(LOGIN,login);
//        mapUserCheck.put(PASSWORD,password);
//        mapUserCheck.put(FIRST_NAME,firstName);
//        mapUserCheck.put(LAST_NAME,lastName);
//        mapUserCheck.put(DATA_BIRTHDAY,strData);
//        mapUserCheck.put(ADDRESS, address);
//        mapUserCheck.put(PHONE_NUMBER,phoneNumber);
//        mapUserCheck.put(EMAIL,email);




        try {
//            String loginCheckResult = UserValidatorImpl.getInstance().isLoginValid(login)
//                    ? (!userDao.ifExistByLogin(login) ? TRUE : NOT_UNIQUE_LOGIN_RESULT)
//                    : INVALID_LOGIN_RESULT;
//            result = parseBoolean(loginCheckResult) ;

            boolean loginValid = UserValidatorImpl.getInstance().isLoginValid(login);
//            boolean passwordValid = UserValidatorImpl.getInstance().isPasswordValid(password);
//            boolean firstNameValid = UserValidatorImpl.getInstance().isFirstNameValid(firstName);
//            boolean lastNameValid = UserValidatorImpl.getInstance().isLastNameValid(lastName);
//            boolean strDateValid = UserValidatorImpl.getInstance().isDataBirthdayValid(strData);
//            boolean addressValid = UserValidatorImpl.getInstance().isAddressValid(address);
            boolean phoneNumberValid = UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber);
//            boolean emailValid = UserValidatorImpl.getInstance().isEmailValid(email);

//            mapUserCheck = UserValidatorImpl.getInstance().checkUserData(userCheck);
//           String phoneNumberResult = UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber) ? TRUE : FALSE;
//            boolean phoneNumberCheckResult = UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber);
//            boolean emailCheckResult = UserValidatorImpl.getInstance().isEmailValid(email);
//            boolean result = parseBoolean(phoneNumberResult);
//            boolean phoneRes = UserValidatorImpl.getInstance().isPhoneNumberValid(phoneNumber);
//

            if (phoneNumberValid) {

                Role role = Role.DOCTOR;
                String passwordHash = PasswordHash.encrypt(password);
                User user = new User(role, login, passwordHash, firstName, lastName, dataBirthday, address, phoneNumber, email);
                userDao.create(user);
//                return true;
//            return  false;
//                result = true;

//            } else {
//                logger.debug(" fallll");
            }

        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method registerNewUser", e);
            throw new ServiceException("Failed at UserServiceImpl at method registerNewUser", e);
        }
        catch (IllegalArgumentException e ){
            logger.error("",e);
            return false;
        }
        return true;
    }

//    }
//            String loginCheckResult = UserValidatorImpl.getInstance().isLoginValid(login)
//                    ? (!userDao.ifExistByLogin(login) ? TRUE : NOT_UNIQUE_LOGIN_RESULT)
//                    : INVALID_LOGIN_RESULT;
//            String passwordCheckResult = UserValidatorImpl.getInstance().isPasswordValid(password)
//                    ? (!password.equals(confirmPassword)? TRUE : PASSWORD_MISMATCH)
//                    : INVALID_PASSPORT_RESULT;


//            if(result){
//                Role role = Role.PATIENT;
//                String passwordHash = PasswordHash.encrypt(password);
//                User user = new User(role,login,passwordHash,email,phoneNumber);
//                userDao.create(user);
//            }
//                if (mapUserCheck.isEmpty()) {
//                Role role = Role.PATIENT;
//                String passwordHash = PasswordHash.encrypt(password);
//                User user = new User(role,login, passwordHash, firstName, lastName, dataBirthday, address, phoneNumber, email);
//                userDao.create(user);
//            }

//        } catch (DaoException e) {
//            logger.log(Level.ERROR, " ", e);
//            throw new ServiceException(" ", e);
//
//        }

//    }

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
            return UserValidatorImpl.getInstance().isLastNameValid(phoneNumber)
                    && userDao.updateLastNameById(id, phoneNumber);
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
            return UserValidatorImpl.getInstance().isLastNameValid(address)
                    && userDao.updateLastNameById(id, address);
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
            return UserValidatorImpl.getInstance().isLastNameValid(email)
                    && userDao.updateLastNameById(id, email);
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
            return UserValidatorImpl.getInstance().isLastNameValid(dataBirthday)
                    && userDao.updateLastNameById(id, dataBirthday);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateDataBirthdayById", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateDataBirthdayById", e);
        }
    }
}