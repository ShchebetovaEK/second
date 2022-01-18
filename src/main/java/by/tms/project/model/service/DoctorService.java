package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.*;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAll() throws ServiceException;

    Optional<Doctor> findDoctorByLogin(String login) throws ServiceException;

    List<Doctor> findDoctorByCategory(Category category) throws ServiceException;

    List<Doctor> findDoctorByExperience(Experience experience) throws ServiceException;

    List<Doctor> findDoctorBySpeciality(Speciality speciality) throws ServiceException;
}
