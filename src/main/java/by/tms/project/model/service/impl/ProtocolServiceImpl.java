package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.ProtocolDao;
import by.tms.project.model.dao.impl.ProtocolDaoImpl;
import by.tms.project.model.entity.*;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.validator.ProtocolValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class ProtocolServiceImpl
 */
public class ProtocolServiceImpl implements ProtocolService {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolDao protocolDao = ProtocolDaoImpl.getInstance();
    private ProtocolValidator protocolValidator = ProtocolValidator.getInstance();
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
            throw new ServiceException("Failed at ProtocolServiceImpl at method findAll", e);
        }
        return protocolList;
    }

    /**
     * find by payer
     *
     * @param payer
     * @return protocolList
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByPayer(Payer payer) throws ServiceException {
        List<Protocol> protocolList = new ArrayList<>();
        try {
            if (protocolValidator.isPayerValid(payer.name())) {
                protocolList = protocolDao.findByPayer(payer);
            }
        } catch (DaoException e) {
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
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByData", e);
        }
        return protocolList;
    }

    /**
     * find By Application
     *
     * @param application
     * @return protocolList
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByApplication(Application application) throws ServiceException {
        List<Protocol> protocolList = new ArrayList<>();
        try {
            if (protocolValidator.isApplicationValid(application.name())) {
                protocolList = protocolDao.findByApplication(application);
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByApplication", e);
        }
        return protocolList;
    }

    /**
     * find By Status
     *
     * @param status
     * @return protocolList
     * @throws ServiceException
     */
    @Override
    public List<Protocol> findByStatus(Status status) throws ServiceException {
        List<Protocol> protocolList = new ArrayList<>();
        try {
            if (protocolValidator.isStatusValid(status.name())) {
                protocolList = protocolDao.findByStatus(status);
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByStatus", e);
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
    public List<Protocol> findByPatient(long patientId) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByPatient(patientId);
        } catch (DaoException e) {
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
    public List<Protocol> findByDoctor(long doctorId) throws ServiceException {
        List<Protocol> protocolList;
        try {
            protocolList = protocolDao.findByDoctor(doctorId);
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl at method findByDoctor", e);
        }
        return protocolList;
    }

    /**
     * patient Application Protocol
     *
     * @param protocolCheck
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean patientApplicationProtocol(Map<String, String> protocolCheck) throws ServiceException {
        boolean result;
        Map<String, String> mapProtocolCheck = new HashMap<>();
        String strProtocolData = protocolCheck.get(PROTOCOL_DATA);
        Date protocolData = java.sql.Date.valueOf(strProtocolData);
        String strProtocolPayer = protocolCheck.get(PROTOCOL_PAYER);
        Payer protocolPayer = Payer.valueOf(strProtocolPayer.toUpperCase());
        String strPatientsUsersId = protocolCheck.get(PROTOCOL_PATIENTS_USERS_ID);
        Long patientsUsersId = Long.valueOf(strPatientsUsersId);
        String strDoctorsUsersId = protocolCheck.get(PROTOCOL_DOCTOR_USERS_ID);
        Long doctorsUsersId = Long.valueOf(strDoctorsUsersId);

        mapProtocolCheck.put(PROTOCOL_DATA, String.valueOf(protocolData));
        mapProtocolCheck.put(PROTOCOL_PAYER, String.valueOf(protocolPayer));
        mapProtocolCheck.put(PROTOCOL_DOCTOR_USERS_ID, String.valueOf(doctorsUsersId));
        mapProtocolCheck.put(PROTOCOL_PATIENTS_USERS_ID, String.valueOf(patientsUsersId));

        try {
            result = ProtocolValidator.getInstance().isPayerValid(protocolPayer.name());
            if (result) {
                Protocol protocol = new Protocol(protocolData, protocolPayer, patientsUsersId, doctorsUsersId);
                protocolDao.create(protocol);
            }

        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl at method registerProtocol ", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at ProtocolServiceImpl at  registerProtocol", e);
            return false;
        }
        return true;
    }

    /**
     * admin Registration Protocol
     *
     * @param protocolCheck
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean adminRegistrationProtocol(Map<String, String> protocolCheck) throws ServiceException {
        boolean result;
        Map<String, String> mapProtocolCheck = new HashMap<>();
        String strProtocolData = protocolCheck.get(PROTOCOL_DATA);
        Date protocolData = java.sql.Date.valueOf(strProtocolData);
        String strProtocolPayer = protocolCheck.get(PROTOCOL_PAYER);
        Payer protocolPayer = Payer.valueOf(strProtocolPayer.toUpperCase());
        String strProtocolCost = protocolCheck.get(PROTOCOL_COST);
        Long protocolCost = Long.valueOf(strProtocolCost);
        String strPatientsUsersId = protocolCheck.get(PROTOCOL_PATIENTS_USERS_ID);
        Long patientsUsersId = Long.valueOf(strPatientsUsersId);
        String strDoctorsUsersId = protocolCheck.get(PROTOCOL_DOCTOR_USERS_ID);
        Long doctorsUsersId = Long.valueOf(strDoctorsUsersId);
        String strProtocolApplication = protocolCheck.get(PROTOCOL_APPLICATION);
        Application protocolApplication = Application.valueOf(strProtocolApplication.toUpperCase());

        mapProtocolCheck.put(PROTOCOL_DATA, String.valueOf(protocolData));
        mapProtocolCheck.put(PROTOCOL_PAYER, String.valueOf(protocolPayer));
        mapProtocolCheck.put(PROTOCOL_COST, String.valueOf(protocolCost));
        mapProtocolCheck.put(PROTOCOL_DOCTOR_USERS_ID, String.valueOf(doctorsUsersId));
        mapProtocolCheck.put(PROTOCOL_PATIENTS_USERS_ID, String.valueOf(patientsUsersId));
        mapProtocolCheck.put(PROTOCOL_APPLICATION, String.valueOf(protocolApplication));

        try {
            result = ProtocolValidator.getInstance().isPayerValid(protocolPayer.name());
            if (result) {
                Protocol protocol = new Protocol(protocolData, protocolPayer,
                        protocolCost, patientsUsersId, doctorsUsersId, protocolApplication);
                protocolDao.createProtocolByAdmin(protocol);
            }

        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl at method adminRegistrationProtocol ", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at ProtocolServiceImpl at  adminRegistrationProtocol", e);
            return false;
        }
        return true;
    }

    /**
     * admin update Protocol Cost
     *
     * @param protocolCost
     * @param protocolId
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateProtocolCost(long protocolCost, long protocolId) throws ServiceException {
        try {
            return protocolDao.updateProtocolCost(protocolCost, protocolId);
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl  at method updateProtocolCost ", e);
        }
    }

    /**
     * admin update Protocol Application
     *
     * @param protocolId
     * @param application
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean updateProtocolApplication(long protocolId, Application application) throws ServiceException {
        try {
            return protocolDao.updateProtocolApplication(protocolId, application);
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl  at method updateProtocolApplication", e);
        }
    }

    /**
     * admin update Protocol Status
     *
     * @param protocolId
     * @param status
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateProtocolStatus(long protocolId, Status status) throws ServiceException {
        try {
            return protocolDao.updateProtocolStatus(protocolId, status);
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl  at method updateProtocolStatus", e);
        }
    }

    /**
     * admin take Protocol Cost
     *
     * @param protocolId
     * @return
     * @throws ServiceException
     */
    @Override
    public long takeProtocolCost(long protocolId) throws ServiceException {
        try {
            return protocolDao.takeProtocolCost(protocolId);
        } catch (DaoException e) {
            throw new ServiceException("Failed at ProtocolServiceImpl  at method takeProtocolCost ", e);
        }
    }
}
