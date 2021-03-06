package by.tms.project.model.service;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;

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

    List<User> findByDataBirthday(String dataBirthday) throws ServiceException;

    List<User> searchByLastName(String lastName) throws ServiceException;

    Optional <User> findByEmail(String email) throws ServiceException;

    Optional<User> findByPhoneNumber(String phoneNumber) throws ServiceException;

    boolean registerNewUser(Map<String, String> userCheck) throws ServiceException;

    boolean registerNewAdmin(Map<String, String> userCheck) throws ServiceException;

    boolean setLogin(User user, String login) throws ServiceException;

    void sendMessage(String subject,String login) throws ServiceException;

    boolean setPassword(User user, String password) throws ServiceException;

    boolean updateFirstNameById(long id, String firstName) throws ServiceException;

    boolean updateLastNameById(long id, String lastName) throws ServiceException;

    boolean updatePhoneNumberById(long id, String phoneNumber) throws ServiceException;

    boolean updateAddressById(long id, String address) throws ServiceException;

    boolean  updateEmailById(long id, String email) throws ServiceException;

    boolean  updateDataBirthdayById(long id, String dataBirthday) throws ServiceException;

    boolean delete(long id) throws ServiceException;

    boolean archivUser(long id) throws ServiceException;
}