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
    private final UserDao userDao = UserDaoImpl.getInstance();
    private static UserServiceImpl instance;

    private UserServiceImpl(){}

    public static UserService getInstance(){
        if(instance ==null){
            instance =new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> findAll() throws ServiceException {
       List<User> userList;
       try{
           userList = userDao.findAll();
       } catch (DaoException e) {
           logger.error("",e);
           throw new ServiceException("",e);
       }
        return userList;
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        Optional<User> optionalUser;
        try {
            optionalUser =userDao.findByLogin(login);
        } catch (DaoException e) {
            logger.error("",e);
            throw new ServiceException("",e);
        }
        return optionalUser;
    }
}
