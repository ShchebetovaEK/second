package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.*;

import java.time.LocalDate;
import java.util.List;

public interface ProtocolDao extends BaseDao<Long, Protocol> {

    List<Protocol> findAll() throws DaoException;

    List<Protocol> findByPayer(Payer payer) throws DaoException;

    List<Protocol> findByData(LocalDate protocolData) throws DaoException;

    List<Protocol> findByApplication(Application application) throws DaoException;

    List<Protocol> findByStatus(Status status) throws DaoException;

    List<Protocol> findByPatient(long patientId) throws DaoException;

    List<Protocol> findByDoctor(long doctorId) throws DaoException;

    boolean updateProtocolCost( long protocolCost,long protocolId) throws DaoException;

    boolean updateProtocolApplication(long protocolId, Application application) throws DaoException;

    boolean updateProtocolStatus(long protocolId, Status status) throws DaoException;

    long takeProtocolCost(long protocolId) throws DaoException;

    boolean createProtocolByAdmin(Protocol entity) throws DaoException;
}
