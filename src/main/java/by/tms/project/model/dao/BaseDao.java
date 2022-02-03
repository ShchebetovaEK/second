package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface BaseDao<K, T extends Entity> {

    List<T> findAll() throws DaoException;

    Optional<T> findById(K id) throws DaoException;

    boolean create(T entity) throws DaoException;

    boolean update(T entity) throws DaoException;

    boolean delete(K entity) throws DaoException;

    boolean delete(T entity) throws DaoException;

}
