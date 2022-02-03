package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.dao.impl.ProtocolDaoImpl;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.ProtocolService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class ProtocolServiceImpl implements ProtocolService {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolDao protocolDao = ProtocolDaoImpl.getInstance();
    private static ProtocolServiceImpl instance;

    private ProtocolServiceImpl() {
    }

    public static ProtocolServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProtocolServiceImpl();
        }
        return instance;
    }

    /**
     * find all protocols.
     *
     * @return protocolList.
     * @throws ServiceException
     */
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

    @Override
    public List<Protocol> findByPayer(String payer) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByPayer(payer);
        } catch (DaoException e) {
            logger.error("Failed at ProtocolServiceImpl at method findByPayer ", e);
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByPayer", e);
        }
        return protocolList;
    }

    /**
     * find all protocol by data.
     *
     * @return protocolList.
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByData(LocalDate protocolData) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByData(protocolData);
        } catch (DaoException e) {
            logger.error("Failed at ProtocolServiceImpl at method findByData", e);
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByData", e);
        }
        return protocolList;
    }

    /**
     * find all protocol by patient.
     *
     * @return protocolList.
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByPatient(Long patientId) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByPatient(patientId);
        } catch (DaoException e) {
            logger.error("Failed at ProtocolServiceImpl at method findByPatient", e);
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByPatient", e);
        }
        return protocolList;
    }

    /**
     * find all protocol by doctor.
     *
     * @return protocolList.
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByDoctor(Long doctorId) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByDoctor(doctorId);
        } catch (DaoException e) {
            logger.error("Failed at ProtocolServiceImpl at method findByDoctor", e);
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByDoctor", e);
        }
        return protocolList;
    }
}
