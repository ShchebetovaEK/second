package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface BaseDao <K,T extends Entity>{

    public List<T> findAll() throws DaoException;

    public Optional<T> findById (K id) throws DaoException;

    public  boolean create(T entity) throws DaoException;

    public  boolean update(T entity) throws DaoException;

    public  boolean delete(K entity) throws DaoException;

    public  boolean delete(T entity) throws DaoException;



}
