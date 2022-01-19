package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Protocol;
import com.oracle.wls.shaded.org.apache.bcel.generic.ATHROW;

import java.time.LocalDate;
import java.util.List;

public interface ProtocolDao {

    List<Protocol> findAll() throws DaoException;

    List<Protocol> findByData(LocalDate protocolData) throws DaoException;

    List<Protocol> findByPatient() throws DaoException;

    List<Protocol> findByDoctor() throws DaoException;
}
