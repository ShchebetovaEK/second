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

    /**
     * find patient by insurance.
     * @param insurance
     * @return patientList.
     * @throws ServiceException
     */
    @Override
    public List<Patient> findByInsurance(Boolean insurance) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findByInsurance(insurance);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findByInsurance", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findByInsurance", e);
        }
        return patientList;
    }

    @Override
    public List<Patient> findByMinimumMoneyAccount(BigDecimal moneyAccount) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findByMinimumMoneyAccount(moneyAccount);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findByMinimumMoneyAccount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findByMinimumMoneyAccount", e);
        }
        return patientList;
    }

    /**
     * find patient with max discount.
     * @param discount
     * @return patientList.
     * @throws ServiceException
     */
    @Override
    public List<Patient> findByMaxDiscount(Integer discount) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findByMaxDiscount(discount);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findByMaxDiscount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findByMaxDiscount", e);
        }
        return patientList;
    }

    @Override
    public boolean toUpBalance(String login, BigDecimal sumForUp, HttpSession session) throws ServiceException {
        // TODO: 17.01.2022
        return false;

    }
}
