package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Application;
import by.tms.project.model.entity.Payer;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.entity.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProtocolService {

    List<Protocol> findAll() throws ServiceException;

    List<Protocol> findByPayer(Payer payer) throws ServiceException;

    List<Protocol> findByData(LocalDate protocolData) throws ServiceException;

    List<Protocol> findByPatient(Long patientId) throws ServiceException;

    List<Protocol> findByDoctor(Long doctorId) throws ServiceException;

    boolean registerProtocol(Map<String, String> protocolCheck) throws ServiceException;

    boolean updateProtocolCost(Long protocolCost, Long protocolId) throws ServiceException;

    boolean updateProtocolApplication(Long protocolId, Application application) throws ServiceException;

    boolean updateProtocolStatus(Long protocolId, Status status) throws ServiceException;

    boolean takeProtocolCost(long protocolId) throws  ServiceException;
}
