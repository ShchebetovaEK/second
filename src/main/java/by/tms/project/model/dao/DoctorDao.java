package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DoctorDao extends BaseDao<Long, Doctor>{

    List<Doctor> findByCategory(Category category) throws DaoException;

    List<Doctor> findBySpeciality (Speciality speciality) throws DaoException;

    Optional<Doctor> findDoctorByLogin(String login) throws DaoException;

    boolean updateCategory(long id, Category category) throws DaoException;

    boolean updateSpeciality(long id, Speciality speciality) throws DaoException;

    boolean deleteDoctor(long id) throws DaoException;

    boolean archivDoctor(long id) throws DaoException;


}
