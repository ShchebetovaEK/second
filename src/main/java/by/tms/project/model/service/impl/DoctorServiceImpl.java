package by.tms.project.model.service.impl;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.DoctorDao;
import by.tms.project.model.dao.impl.DoctorDaoImpl;
import by.tms.project.model.entity.*;
import by.tms.project.model.service.DoctorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


public class DoctorServiceImpl implements DoctorService {
    private static final Logger logger = LogManager.getLogger();
    private DoctorDao doctorDao = DoctorDaoImpl.getInstance();
    private static DoctorServiceImpl instance;

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
        return doctorList; }

    /**
     * find doctor by login.
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
     * @param category
     * @return doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findDoctorByCategory(Category category) throws ServiceException {
        List<Doctor> doctorList;
        try {
            doctorList = doctorDao.findByCategory(category);
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorByCategory", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorByCategory", e);
        }
        return doctorList;
    }

    /**
     * find doctor by experience.
     * @param experience
     * @return doctorList.
     * @throws ServiceException
     */
    @Override
    public List<Doctor> findDoctorByExperience(Experience experience) throws ServiceException {
        List<Doctor> doctorList;
        try {
            doctorList = doctorDao.findByExperience(experience);
        } catch (DaoException e) {
            logger.error("Failed at DoctorServiceImpl at method findDoctorByExperience", e);
            throw new ServiceException("Failed at DoctorServiceImpl at method findDoctorByExperience", e);
        }
        return doctorList;
    }

    /**
     * find doctor by category.
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
}
