package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.dao.impl.ProtocolDaoImpl;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.ProtocolService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProtocolServiceImpl implements ProtocolService {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolDao protocolDao = ProtocolDaoImpl.getInstance();
    private static ProtocolServiceImpl instance;

    private ProtocolServiceImpl(){}

    public static ProtocolServiceImpl getInstance( ){
        if(instance == null){
            instance = new ProtocolServiceImpl();
        }
        return instance;
    }


    @Override
    public List<Protocol> findAll() throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findAll();
        } catch (DaoException e) {
            logger.error("Failed at ProtocolServiceImpl at method findAll", e);
            throw new ServiceException("Failed at ProtocolServiceImpl at method findAll", e);
        }
        return protocolList;
    }
}

