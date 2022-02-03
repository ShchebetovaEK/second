package by.tms.project.model.service;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> findAll() throws ServiceException;

    Optional<User> findUserByLoginAndPassword(String login, String password) throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

    Optional<User> findUserById(long id) throws ServiceException;

    List<User> findByFirstName(String firstName) throws ServiceException;

    List<User> findByLastName(String lastName) throws ServiceException;

//    List<User> findByDataBirthday(Date dataBirthday) throws ServiceException;

    Optional <User> findByEmail(String email) throws ServiceException;

    Optional<User> findByPhoneNumber(String phoneNumber) throws ServiceException;

    boolean checkIfUserValidForRegistration(String login, String email) throws ServiceException;

    boolean registrationUser(String login, String password, String email) throws ServiceException;

    void sendMessageRegistrationOnUserEmail(String login, String email, String currentLocale) throws ServiceException;

    void setUserNewLogin(String login, String newLogin) throws ServiceException;

    void setUserNewPassword(String login, String newPassword) throws ServiceException;

    boolean registerNewUser(Map<String, String> userCheck) throws ServiceException;

    boolean registerNewAdmin(Map<String, String> userCheck) throws ServiceException;

    boolean updateFirstNameById(long id, String firstName) throws ServiceException;

    boolean updateLastNameById(long id, String lastName) throws ServiceException;

    boolean updatePhoneNumberById(long id, String phoneNumber) throws ServiceException;

    boolean updateAddressById(long id, String address) throws ServiceException;

    boolean  updateEmailById(long id, String email) throws ServiceException;

    boolean  updateDataBirthdayById(long id, String dataBirthday) throws ServiceException;

    boolean verify(long userId) throws ServiceException;

}