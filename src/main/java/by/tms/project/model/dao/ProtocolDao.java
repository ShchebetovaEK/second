package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Protocol;

import java.util.List;

public interface ProtocolDao {

    List<Protocol> findAll() throws DaoException;
}
