package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.PatientDao;
import by.tms.project.model.dao.impl.PatientDaoImpl;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LogManager.getLogger();
    private PatientDao patientDao = PatientDaoImpl.getInstance();
    private static PatientServiceImpl instance;

    private PatientServiceImpl(){}

    public static PatientServiceImpl getInstance( ){
        if(instance == null){
            instance = new PatientServiceImpl();
        }
        return instance;
    }

    /**
     * find all patient.
     * @return patientList.
     * @throws ServiceException
     */
    @Override
    public List<Patient> findAll() throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findAll();
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findAll", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findAll", e);
        }
        return patientList;
    }

    /**
     * find patient by login.
     * @param login
     * @return optionalPatient.
     * @throws ServiceException
     */
    @Override
    public Optional<Patient> findPatientByLogin(String login) throws ServiceException {
        Optional<Patient> optionalPatient;
        try {
            optionalPatient = patientDao.findPatientByLogin(login);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findPatientByLogin", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findPatientByLogin", e);
        }
        return optionalPatient;
    }


    @Override
    public BigDecimal takePatientMoneyAccount(String login) throws ServiceException {
        // TODO: 17.01.2022
        return null;
    }

    @Override
    public boolean createPatient(Patient patient, HttpServletRequest request) throws ServiceException {
        // TODO: 17.01.2022
        return false;
    }

    @Override
    public boolean toUpBalance(String login, BigDecimal sumForUp, HttpSession session) throws ServiceException {
        // TODO: 17.01.2022
        return false;

    }
}
