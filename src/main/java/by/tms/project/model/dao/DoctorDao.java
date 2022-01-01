package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.dao.impl.DoctorDaoImpl;
import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;

import java.util.Optional;

public interface DoctorDao extends BaseDao<Long, Doctor>{

    Optional<Doctor> findByCategory(Category category) throws DaoException;

    Optional<Doctor> findByExperience(Experience experience) throws DaoException;

    Optional<Doctor> findBySpeciality (Speciality speciality) throws DaoException;




}
