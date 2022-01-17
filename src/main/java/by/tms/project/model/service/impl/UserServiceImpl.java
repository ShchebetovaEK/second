package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.UserDao;
import by.tms.project.model.dao.impl.UserDaoImpl;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.util.security.PasswordEncryptor;
import by.tms.project.model.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    @Override
    public List<User> findAll() throws ServiceException {
        List<User> userList;
        try {
            userList = userDao.findAll();
        } catch (DaoException e) {
            logger.error("", e);
            throw new ServiceException("", e);
        }
        return userList;
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException {
        Optional<User> optionalUser = Optional.empty();
        try{
            if (UserValidator.getInstance().isLoginValid(login) && UserValidator.getInstance().isPasswordValid(password)){
                String passwordSalt = PasswordEncryptor.encrypt(password);
                optionalUser = userDao.findByLoginAndPassword(login,passwordSalt);
            }
        } catch (DaoException e){
            logger.error("",e);
            throw  new ServiceException ("",e);
        } return optionalUser;
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findByLogin(login);
        } catch (DaoException e) {
            logger.error("", e);
            throw new ServiceException("", e);
        }
        return optionalUser;
    }

    @Override
    public Optional<User> findUserById(long id) throws ServiceException {
        Optional<User> optionalUser;
        try {
            optionalUser = userDao.findById(id);
        } catch (DaoException e) {
            logger.error("", e);
            throw new ServiceException("", e);
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
        boolean result = false;
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
        String confirmPassword = userCheck.get(CONFIRM_PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String DataBirthday = userCheck.get(DATA_BIRTHDAY);
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);
        String roleStr = userCheck.get(ROLE);

        try {
            String loginCheck = UserValidator.getInstance().isLoginValid(login)
                    ? (!userDao.ifExistByLogin(login) ? TRUE : NOT_VALID_LOGIN) : INVALID_LOGIN;
            String passwordCheck = UserValidator.getInstance().isPasswordValid(password)
                    ? (password.equals(confirmPassword) ? TRUE : PASSWORD_MISMATCH) : INVALID_PASSWORD;
            String emailCheck = UserValidator.getInstance().isEmailValid(email)
                    ? (!userDao.ifExistByEmail(email) ? TRUE : NOT_VALID_EMAIL) : INVALID_EMAIL;
//            String phoneNumberCheck = DataValidator.getInstance().isPhoneNumberValid(phoneNumber)
//                    ? (!userDao.ifExistByEmail())

            result = parseBoolean(loginCheck) && parseBoolean(passwordCheck)
                    && parseBoolean(emailCheck);

            if (result) {
                Role role = roleStr != null ? Role.valueOf(roleStr.toUpperCase()) : Role.PATIENT;
//todo

            }
        } catch (DaoException e) {
            logger.log(Level.ERROR, " ", e);
            throw new ServiceException(" ", e);


        }
        return result;
    }

    @Override
    public boolean updateFirstNameById(long id, String firstName) throws ServiceException {
        try{
            return UserValidator.getInstance().isFirstNameValid(firstName)
                    && userDao.updateFirstNameById(id, firstName);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }

    @Override
    public boolean updateLastNameById(long id, String lastName) throws ServiceException {
        try{
            return UserValidator.getInstance().isLastNameValid(lastName)
                    && userDao.updateLastNameById(id,lastName);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }

    @Override
    public boolean updatePhoneNumberById(long id, String phoneNumber) throws ServiceException {
        try{
            return UserValidator.getInstance().isLastNameValid(phoneNumber)
                    && userDao.updateLastNameById(id,phoneNumber);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }

    @Override
    public boolean updateAddressById(long id, String address) throws ServiceException {
        try{
            return UserValidator.getInstance().isLastNameValid(address)
                    && userDao.updateLastNameById(id,address);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }

    @Override
    public boolean updateEmailById(long id, String email) throws ServiceException {
        try{
            return UserValidator.getInstance().isLastNameValid(email)
                    && userDao.updateLastNameById(id,email);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }

    @Override
    public boolean updateDataBirthdayById(long id, String dataBirthday) throws ServiceException {
        try{
            return UserValidator.getInstance().isLastNameValid(dataBirthday)
                    && userDao.updateLastNameById(id,dataBirthday);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
    }
}
