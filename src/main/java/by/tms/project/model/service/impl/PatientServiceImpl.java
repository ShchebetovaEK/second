package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.PatientDao;
import by.tms.project.model.dao.impl.PatientDaoImpl;
import by.tms.project.model.entity.*;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.util.security.PasswordHash;
import by.tms.project.model.validator.DoctorValidator;
import by.tms.project.model.validator.PatientValidator;
import by.tms.project.model.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class PatientServiceImpl
 */
public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LogManager.getLogger();
    private PatientDao patientDao = PatientDaoImpl.getInstance();
    private PatientValidator patientValidator = PatientValidator.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();
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
            throw new ServiceException("Failed at PatientServiceImpl at method findPatientByLogin", e);
        }
        return optionalPatient;
    }

    @Override
    public Optional<Patient> findBalance(long id) throws ServiceException {
        Optional<Patient> optionalPatient = Optional.empty();
        try {
            optionalPatient = patientDao.findPatientById(id);
        } catch (DaoException e) {
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
            throw new ServiceException("Failed at PatientServiceImpl at method findByInsurance", e);
        }
        return patientList;
    }

    @Override
    public List<Patient> findByMoneyAccount(long firstRange, long secondRange) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findByMoneyAccount(firstRange, secondRange);
        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method findByMinimumMoneyAccount", e);
        }
        return patientList;
    }

    @Override
    public List<Patient> findMinBalance(int minBalance) throws ServiceException {
        List<Patient> patientList;
        try {
            patientList = patientDao.findMinBalance(minBalance);
        } catch (DaoException e) {
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
            throw new ServiceException("Failed at PatientServiceImpl at method findByDiscount", e);
        }
        return patientList;
    }

    /**
     * create patient
     *
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
            resultOne = PatientValidator.getInstance().checkUserPatientData(mapPatientCheck);
            if (resultOne) {
                Patient patient = new Patient(insurance,
                        moneyAccount, discount);
                patientDao.create(patient);
            }

        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method create", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at PatientServiceImpl in create ", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean registerNewPatient(Map<String, String> userCheck) throws ServiceException {
        boolean resultOne;
        boolean resultTwo;
        Map<String, String> mapUserCheck = new HashMap<>();
        Map<String, String> mapPatientCheck = new HashMap<>();
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String strData = userCheck.get(DATA_BIRTHDAY);
        Date dataBirthday = java.sql.Date.valueOf(strData);
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);
        String strInsurance = userCheck.get(INSURANCE);
        Boolean insurance = Boolean.valueOf(strInsurance);
        String strMoneyAccount = userCheck.get(MONEY_ACCOUNT);
        BigDecimal moneyAccount = BigDecimal.valueOf(Integer.valueOf(strMoneyAccount));
        String strDiscount = userCheck.get(DISCOUNT);
        Integer discount = Integer.valueOf(strDiscount);

        mapUserCheck.put(LOGIN, login);
        mapUserCheck.put(PASSWORD, password);
        mapUserCheck.put(FIRST_NAME, firstName);
        mapUserCheck.put(LAST_NAME, lastName);
        mapUserCheck.put(DATA_BIRTHDAY, strData);
        mapUserCheck.put(ADDRESS, address);
        mapUserCheck.put(PHONE_NUMBER, phoneNumber);
        mapUserCheck.put(EMAIL, email);

        mapPatientCheck.put(INSURANCE, String.valueOf(insurance));
        mapPatientCheck.put(MONEY_ACCOUNT, String.valueOf(moneyAccount));
        mapPatientCheck.put(DISCOUNT, String.valueOf(discount));


        try {
            resultOne = UserValidator.getInstance().checkUserData(mapUserCheck);
            resultTwo = PatientValidator.getInstance().checkUserPatientData(mapPatientCheck);
            if (resultOne && resultTwo) {
                Role role = Role.PATIENT;
                String passwordHash = PasswordHash.encrypt(password);
                Patient patient = new Patient(role,login,passwordHash,firstName,lastName,dataBirthday,
                        address,phoneNumber,email,insurance,moneyAccount,discount);
                patientDao.create(patient);
            }

        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method registerNewPatient", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at PatientServiceImpl in registerNewPatient", e);
        }
        return true;
    }

    /**
     * update insurance
     *
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
            throw new ServiceException("Failed at PatientServiceImpl at method updateInsurance ", e);
        }
    }

    /**
     * update discount
     *
     * @param id
     * @param discount
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateDiscount(long id, Integer discount) throws ServiceException {
        try {
            return PatientValidator.getInstance().isDiscount(discount)
                    && patientDao.updateDiscount(id, discount);
        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method updateDiscount", e);
        }
    }

    /**
     * update money account
     *
     * @param id
     * @param moneyAccount
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateMoneyAccount(long id, BigDecimal moneyAccount) throws ServiceException {
        try {
            return PatientValidator.getInstance().isMoneyAccount(moneyAccount)
                    && patientDao.updateMoneyAccount(id, moneyAccount);
        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method updateDiscount", e);
        }
    }

    @Override
    public boolean updateBalance(long id, BigDecimal balance) throws ServiceException {
        try {

            return patientDao.updateBalance(id, balance);
        } catch (DaoException e) {
            throw new ServiceException("Failed at PatientServiceImpl at method updateDiscount", e);
        }
    }

    /**
     * delete patient
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean deletePatient(long id) throws ServiceException {
        try {
            return patientDao.deletePatient(id);
        } catch (DaoException e) {
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
            throw new ServiceException("Failed at PatientServiceImpl at method archivPatient", e);
        }
    }
}
