package by.tms.project.model.service;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAll() throws ServiceException;

    Optional<Doctor> findDoctorByLogin(String login) throws ServiceException;

    List<Doctor> findDoctorByCategory(Category category) throws ServiceException;

    List<Doctor> findDoctorByExperience(Experience experience) throws ServiceException;

    List<Doctor> findDoctorBySpeciality(Speciality speciality) throws ServiceException;

    boolean registerNewDoctor(Map<String, String> userCheck) throws ServiceException;

    boolean updateCategory(long id, Category category) throws ServiceException;

    boolean updateExperience(long id, Experience experience) throws ServiceException;

    boolean updateSpeciality(long id, Speciality speciality) throws ServiceException;

    boolean deleteDoctor(long id) throws ServiceException;

    boolean archivDoctor(long id) throws ServiceException;

}
