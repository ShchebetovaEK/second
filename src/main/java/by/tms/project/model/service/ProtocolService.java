package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;

import java.time.LocalDate;
import java.util.List;

public interface ProtocolService {

    List<Protocol> findAll() throws ServiceException;

    List<Protocol> findByPayer(String payer) throws ServiceException;

    List<Protocol> findByData(LocalDate protocolData) throws ServiceException;

    List<Protocol> findByPatient() throws ServiceException;

    List<Protocol> findByDoctor() throws ServiceException ;
}
