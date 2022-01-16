package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll() throws ServiceException;

    Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

    boolean checkIfUserValidForRegistration(String login, String email) throws ServiceException;

    boolean registrationUser(String login,String password,String email) throws ServiceException;

    void sendMessageRegistrationOnUserEmail (String login,String  email, String currentLocale) throws ServiceException;

    void setUserNewLogin (String login, String newLogin) throws ServiceException;

    void setUserNewPassword(String login,String newPassword) throws ServiceException;





}
