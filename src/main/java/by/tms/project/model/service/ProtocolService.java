package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;

import java.util.List;

public interface ProtocolService {

    List<Protocol> findAll() throws ServiceException;


}
