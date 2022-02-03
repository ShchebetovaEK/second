package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.*;

import java.util.List;
import java.util.Optional;

public interface DoctorDao extends BaseDao<Long, Doctor>{

    List<Doctor> findByCategory(Category category) throws DaoException;

    List<Doctor> findByExperience(Experience experience) throws DaoException;

    List<Doctor> findBySpeciality (Speciality speciality) throws DaoException;

    Optional<Doctor> findDoctorByLogin(String login) throws DaoException;

    boolean updateCategory(long id, Category category) throws DaoException;

    boolean updateExperience(long id, Experience experience) throws DaoException;

    boolean updateSpeciality(long id, Speciality speciality) throws DaoException;

    boolean deleteDoctor(long id) throws DaoException;




}
