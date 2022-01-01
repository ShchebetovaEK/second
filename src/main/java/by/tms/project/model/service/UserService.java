package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll() throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

}
