package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.PatientDao;
import by.tms.project.model.dao.impl.PatientDaoImpl;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.validator.PatientValidator;
import by.tms.project.model.validator.UserValidator;
import by.tms.project.model.validator.impl.PatientValidatorImpl;
import by.tms.project.model.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 *
 * class PatientServiceImpl
 */
public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LogManager.getLogger();
    private PatientDao patientDao = PatientDaoImpl.getInstance();
    private PatientValidator patientValidator = PatientValidatorImpl.getInstance();
    private UserValidator userValidator = UserValidatorImpl.getInstance();
    private static PatientServiceImpl instance;


    private PatientServiceImpl() {
    }

    public static PatientServiceImpl getInstance() {
        if (instance == null) {
            instance = new PatientServiceImpl();
        }
        return instance;
    }

    /**
     * find all patient.
     *
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
     *
     * @param login
     * @return optionalPatient.
     * @throws ServiceException
     */
    @Override
    public Optional<Patient> findPatientByLogin(String login) throws ServiceException {
        Optional<Patient> optionalPatient = Optional.empty();
        try {
            if (userValidator.isLoginValid(login)) {
                optionalPatient = patientDao.findPatientByLogin(login);
            }
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findPatientByLogin", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findPatientByLogin", e);
        }
        return optionalPatient;
    }

    /**
     * find patient by insurance.
     *
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
    public List<Patient> findByMoneyAccount(BigDecimal moneyAccount) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findByMoneyAccount(moneyAccount);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findByMinimumMoneyAccount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findByMinimumMoneyAccount", e);
        }
        return patientList;
    }

    /**
     * find patient with discount.
     *
     * @param discount
     * @return patientList.
     * @throws ServiceException
     */
    @Override
    public List<Patient> findByDiscount(Integer discount) throws ServiceException {
        List<Patient> patientList = new ArrayList<>();
        try {
            if (patientValidator.isDiscount(discount)) {
                patientList = patientDao.findByDiscount(discount);
            }
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method findByDiscount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method findByDiscount", e);
        }
        return patientList;
    }

    /**
     * create patient
     * @param userCheck
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean create(Map<String, String> userCheck) throws ServiceException {
        boolean resultOne;

        Map<String, String> mapPatientCheck = new HashMap<>();
        String strInsurance = userCheck.get(INSURANCE);
        Boolean insurance = Boolean.valueOf(strInsurance);
        String strMoney = userCheck.get(MONEY_ACCOUNT);
        BigDecimal moneyAccount = BigDecimal.valueOf(Long.parseLong(strMoney));
        String strDiscount = userCheck.get(DISCOUNT);
        Integer discount = Integer.valueOf(strDiscount);
        mapPatientCheck.put(INSURANCE, String.valueOf(insurance));
        mapPatientCheck.put(MONEY_ACCOUNT, String.valueOf(moneyAccount));
        mapPatientCheck.put(DISCOUNT, String.valueOf(discount));

        try {
            resultOne = PatientValidatorImpl.getInstance().checkUserPatientData(mapPatientCheck);
            if (resultOne) {
                Patient patient = new Patient(insurance,
                        moneyAccount,discount);
                patientDao.create(patient);
            }

        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method create", e);
            throw new ServiceException("Failed at PatientServiceImpl at method create", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at PatientServiceImpl in create ", e);
            return false;
        }
        return true;
    }

    /**
     * update insurance
     * @param id
     * @param insurance
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateInsurance(long id, Boolean insurance) throws ServiceException {
        try {
            return patientDao.updateInsurance(id, insurance);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl  at method updateInsurance", e);
            throw new ServiceException("Failed at PatientServiceImpl at method updateInsurance ", e);
        }
    }

    /**
     * update discount
     * @param id
     * @param discount
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateDiscount(long id, Integer discount) throws ServiceException {
        try {
            return PatientValidatorImpl.getInstance().isDiscount(discount)
                    && patientDao.updateDiscount(id, discount);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method updateDiscount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method updateDiscount", e);
        }
    }

    /**
     * update money account
     * @param id
     * @param moneyAccount
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateMoneyAccount(long id, BigDecimal moneyAccount) throws ServiceException {
        try {
            return PatientValidatorImpl.getInstance().isMoneyAccount(moneyAccount)
                    && patientDao.updateMoneyAccount(id, moneyAccount);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method updateDiscount", e);
            throw new ServiceException("Failed at PatientServiceImpl at method updateDiscount", e);
        }
    }

    /**
     * delete patient
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean deletePatient(long id) throws ServiceException {
        try {
            return patientDao.deletePatient(id);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method deletePatient", e);
            throw new ServiceException("Failed at PatientServiceImpl at  method deletePatient", e);
        }
    }

    /**
     * archiv Patient by id
     *
     * @param id
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean archivPatient(long id) throws ServiceException {
        try {
            return patientDao.archivPatient(id);
        } catch (DaoException e) {
            logger.error("Failed at PatientServiceImpl at method archivPatient", e);
            throw new ServiceException("Failed at PatientServiceImpl at method archivPatient", e);
        }
    }
}
