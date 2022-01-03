package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;

import java.util.List;

public interface DoctorDao extends BaseDao<Long, Doctor>{

    List<Doctor> findByCategory(Category category) throws DaoException;

    List<Doctor> findByExperience(Experience experience) throws DaoException;

    List<Doctor> findBySpeciality (Speciality speciality) throws DaoException;




}
