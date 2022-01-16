package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<Long, User> {

     Optional<User> findByLoginAndPassword(String login,String password) throws DaoException;

     Optional<User> findByLogin(String login) throws DaoException;

     List<User> findByFirstName(String firstName) throws DaoException;

     List<User> findByLastName(String lastName) throws DaoException;

     List<User> findByRole(Role role) throws DaoException;

     List<User> findByFirstNameAndRole(String firstName, Role role) throws DaoException;

     List<User> findByLastNameAndRole(String lastName, Role role) throws  DaoException;

     List<User> findByDataBirthday(LocalDate dataBirthday) throws DaoException;

     Optional <User> findByEmail(String email) throws DaoException;

     Optional<User> findByPhoneNumber(String phoneNumber) throws DaoException;

     boolean ifExistByLogin(String login) throws DaoException;

     boolean ifExistByEmail(String email) throws DaoException;

     boolean setLogin(User user, String login) throws DaoException;

     boolean setPassword(User user, String password) throws DaoException;

     boolean checkOldPassword(User user, String oldPassword) throws DaoException;

     boolean checkUserLogin(String login) throws DaoException;
}
