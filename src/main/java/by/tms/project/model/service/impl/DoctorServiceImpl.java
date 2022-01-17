package by.tms.project.model.service.impl;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.dao.DoctorDao;
import by.tms.project.model.dao.impl.DoctorDaoImpl;
import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;
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

    @Override
    public List<Doctor> findAll() throws ServiceException {
        // TODO: 17.01.2022
        return null;
    }

    @Override
    public Optional<Doctor> findDoctorByLogin(String login) throws ServiceException {
        // TODO: 17.01.2022
        return Optional.empty();
    }

    @Override
    public List<Doctor> findDoctorByCategory(Category category) throws ServiceException {
        // TODO: 17.01.2022
        return null;
    }

    @Override
    public List<Doctor> findDoctorByExperience(Experience experience) throws ServiceException {
        // TODO: 17.01.2022
        return null;
    }

    @Override
    public List<Doctor> findDoctorBySpeciality(Speciality speciality) throws ServiceException {
        // TODO: 17.01.2022
        return null;
    }
}
