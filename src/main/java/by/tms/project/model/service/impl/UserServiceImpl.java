package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.UserDao;
import by.tms.project.model.dao.impl.UserDaoImpl;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

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
    public boolean checkIfUserValidForRegistration(String login, String email) throws ServiceException {


        return false;
    }

    @Override
    public boolean registrationUser(String login, String password, String email) throws ServiceException {
        return false;
    }

    @Override
    public void sendMessageRegistrationOnUserEmail(String login, String email, String currentLocale) throws ServiceException {

    }

    @Override
    public void setUserNewLogin(String login, String newLogin) throws ServiceException {

    }

    @Override
    public void setUserNewPassword(String login, String newPassword) throws ServiceException {

    }
}
