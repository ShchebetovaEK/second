package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.*;
import com.oracle.wls.shaded.org.apache.bcel.generic.ATHROW;

import java.time.LocalDate;
import java.util.List;

public interface ProtocolDao extends BaseDao<Long, Protocol> {

    List<Protocol> findAll() throws DaoException;

    List<Protocol> findByPayer(Payer payer) throws DaoException;

    List<Protocol> findByData(LocalDate protocolData) throws DaoException;

    List<Protocol> findByPatient(Long patientId) throws DaoException;

    List<Protocol> findByDoctor(Long doctorId) throws DaoException;

    boolean updateProtocolCost(Long protocolCost, Long protocolId) throws DaoException;

    boolean updateProtocolApplication(Long protocolId, Application application) throws DaoException;

    boolean updateProtocolStatus(Long protocolId, Status status) throws DaoException;

    boolean takeProtocolCost(Long protocolId) throws DaoException;
}
