package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.DoctorDao;
import by.tms.project.model.dao.impl.DoctorDaoImpl;
import by.tms.project.model.entity.*;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.util.security.PasswordHash;
import by.tms.project.model.validator.DoctorValidator;
import by.tms.project.model.validator.impl.DoctorValidatorImpl;
import by.tms.project.model.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static by.tms.project.controller.command.RequestParameter.*;
import static by.tms.project.controller.command.RequestParameter.EMAIL;

public class DoctorServiceImpl implements DoctorService {
    private static final Logger logger = LogManager.getLogger();
    private static DoctorServiceImpl instance;
    private DoctorDao doctorDao = DoctorDaoImpl.getInstance();
    private DoctorValidator doctorValidator = DoctorValidatorImpl.getInstance();

    private DoctorServiceImpl() {
    }

    public static DoctorServiceImpl getInstance() {
        if (instance == null) {
            instance = new DoctorServiceImpl();
        }
        return instance;
    }

    /**
     * find  all doctor.
     *
     * @return the doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findAll() throws ServiceException {
        List<Doctor> doctorList;
        try {
            doctorList = doctorDao.findAll();
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findAll", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findAll", e);
        }
        return doctorList;
    }

    /**
     * find doctor by login.
     *
     * @param login
     * @return optionalDoctor.
     * @throws ServiceException
     */
    @Override
    public Optional<Doctor> findDoctorByLogin(String login) throws ServiceException {
        Optional<Doctor> optionalDoctor;
        try {
            optionalDoctor = doctorDao.findDoctorByLogin(login);
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorByLogin", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorByLogin", e);
        }
        return optionalDoctor;
    }

    /**
     * find doctor by category.
     *
     * @param category
     * @return doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findDoctorByCategory(Category category) throws ServiceException {
        List<Doctor> doctorList = new ArrayList<>();
        try {
            if (doctorValidator.isCategoryValid(category.name())) {
                doctorList = doctorDao.findByCategory(category);
            }
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorByCategory", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorByCategory", e);
        }
        return doctorList;
    }

    /**
     * find doctor by experience.
     *
     * @param experience
     * @return doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findDoctorByExperience(Experience experience) throws ServiceException {
        List<Doctor> doctorList = new ArrayList<>();
        try {
            if (doctorValidator.isExperienceValid(experience.name())) {
                doctorList = doctorDao.findByExperience(experience);
            }
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorByExperience", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorByExperience", e);
        }
        return doctorList;
    }

    /**
     * find doctor by category.
     *
     * @param speciality
     * @return doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findDoctorBySpeciality(Speciality speciality) throws ServiceException {
        List<Doctor> doctorList;
        try {
            doctorList = doctorDao.findBySpeciality(speciality);
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorBySpeciality ", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorBySpeciality ", e);
        }
        return doctorList;
    }

    /**
     * register New Doctor
     *
     * @param userCheck
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean registerNewDoctor(Map<String, String> userCheck) throws ServiceException {
        boolean resultOne;
        boolean resultTwo;
        Map<String, String> mapUserCheck = new HashMap<>();
        Map<String, String> mapDoctorCheck = new HashMap<>();
        String login = userCheck.get(LOGIN);
        String password = userCheck.get(PASSWORD);
        String firstName = userCheck.get(FIRST_NAME);
        String lastName = userCheck.get(LAST_NAME);
        String strData = userCheck.get(DATA_BIRTHDAY);
        Date dataBirthday = java.sql.Date.valueOf(strData);
        String address = userCheck.get(ADDRESS);
        String phoneNumber = userCheck.get(PHONE_NUMBER);
        String email = userCheck.get(EMAIL);
        String strCategory = userCheck.get(CATEGORY);
        Category category = Category.valueOf(strCategory.toUpperCase());
        String strExperience = userCheck.get(EXPERIENCE);
        Experience experience = Experience.valueOf(strExperience.toUpperCase());
        String strSpeciality = userCheck.get(SPECIALITY);
        Speciality speciality = Speciality.valueOf(strSpeciality.toUpperCase());

        mapUserCheck.put(LOGIN, login);
        mapUserCheck.put(PASSWORD, password);
        mapUserCheck.put(FIRST_NAME, firstName);
        mapUserCheck.put(LAST_NAME, lastName);
        mapUserCheck.put(DATA_BIRTHDAY, strData);
        mapUserCheck.put(ADDRESS, address);
        mapUserCheck.put(PHONE_NUMBER, phoneNumber);
        mapUserCheck.put(EMAIL, email);
        mapDoctorCheck.put(CATEGORY, String.valueOf(category));
        mapDoctorCheck.put(EXPERIENCE, String.valueOf(experience));
        mapDoctorCheck.put(SPECIALITY, String.valueOf(strSpeciality));


        try {
            resultOne = UserValidatorImpl.getInstance().checkUserData(mapUserCheck);
            resultTwo = DoctorValidatorImpl.getInstance().checkUserDoctorData(mapDoctorCheck);
            if (resultOne && resultTwo) {
                AccessRole role = AccessRole.DOCTOR;
                String passwordHash = PasswordHash.encrypt(password);
                Doctor doctor = new Doctor(role, login, passwordHash, firstName, lastName, dataBirthday,
                        address, phoneNumber, email, category, experience, speciality);
                doctorDao.create(doctor);
            }

        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method registerNewDoctor", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method registerNewDoctor", e);
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException at DoctorServiceImpl in registerNewDoctor ", e);
            return false;
        }
        return true;
    }

    /**
     * update  doctor's Category
     *
     * @param id
     * @param category
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateCategory(long id, Category category) throws ServiceException {
        try {
            return DoctorValidatorImpl.getInstance().isCategoryValid(category.name())
                    && doctorDao.updateCategory(id, category);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateCategory", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateCategory", e);
        }
    }

    /**
     * update  doctor's Experience
     *
     * @param id
     * @param experience
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateExperience(long id, Experience experience) throws ServiceException {
        try {
            return DoctorValidatorImpl.getInstance().isExperienceValid(experience.name())
                    && doctorDao.updateExperience(id, experience);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateExperience", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateExperience", e);
        }
    }

    /**
     * update  doctor's Speciality
     *
     * @param id
     * @param speciality
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean updateSpeciality(long id, Speciality speciality) throws ServiceException {
        try {
            return DoctorValidatorImpl.getInstance().isSpecialityValid(speciality.name())
                    && doctorDao.updateSpeciality(id, speciality);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method updateExperience", e);
            throw new ServiceException("Failed at UserServiceImpl at method updateExperience ", e);
        }
    }

    /**
     * delete Doctor
     *
     * @param id
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean deleteDoctor(long id) throws ServiceException {
        try {
            return doctorDao.deleteDoctor(id);
        } catch (DaoException e) {
            logger.error("Failed at UserServiceImpl at method deleteDoctor", e);
            throw new ServiceException("Failed at UserServiceImpl at method deleteDoctor", e);
        }
    }

    /**
     * archiv Doctor
     *
     * @param id
     * @return the boolean
     * @throws ServiceException
     */
    @Override
    public boolean archivDoctor(long id) throws ServiceException {
        try {
            return doctorDao.archivDoctor(id);
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at archivDoctor ", e);
            throw new ServiceException("Failed at DoctorServiceImpl at archivDoctor", e);
        }
    }
}

