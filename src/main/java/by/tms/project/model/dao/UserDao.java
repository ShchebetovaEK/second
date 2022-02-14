package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.AccessRole;
import by.tms.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<Long, User> {

     Optional<User> findByLoginAndPassword(String login,String passwordHash) throws DaoException;

     Optional<User> findByLogin(String login) throws DaoException;

     List<User> findByFirstName(String firstName) throws DaoException;

     List<User> findByLastName(String lastName) throws DaoException;

     List<User> searchByLastName(String lastName) throws DaoException;

     List<User> findByRole(AccessRole role) throws DaoException;

     List<User> findByFirstNameAndRole(String firstName, AccessRole role) throws DaoException;

     List<User> findByLastNameAndRole(String lastName, AccessRole role) throws  DaoException;

     Optional <User> findByEmail(String email) throws DaoException;

     Optional<User> findByPhoneNumber(String phoneNumber) throws DaoException;

     boolean ifExistByLogin(String login) throws DaoException;

     boolean ifExistByEmail(String email) throws DaoException;

     boolean ifExistByPhoneNumber(String phoneNumber) throws DaoException;

     boolean setLogin(User user, String login) throws DaoException;

     boolean setPassword(User user, String password) throws DaoException;

     boolean checkUserLogin(String login) throws DaoException;

     Optional<User> findUserByLoginAndPassword(String login, String passwordSalt)  throws DaoException;

     boolean updateFirstNameById(long id, String firstName) throws DaoException;

     boolean updateLastNameById(long id, String lastName) throws DaoException;

     boolean updatePhoneNumberById(long id, String phoneNumber) throws DaoException;

     boolean updateAddressById(long id, String address) throws DaoException;

     boolean  updateEmailById(long id, String email) throws DaoException;

     boolean  updateDataBirthdayById(long id, String dataBirthday) throws DaoException;

     boolean archivUser(long id) throws DaoException;
}
