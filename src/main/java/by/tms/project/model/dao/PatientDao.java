package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.entity.Speciality;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PatientDao extends BaseDao<Long,Patient>{

    List<Patient> findByInsurance(Boolean insurance) throws DaoException;

    List<Patient> findByMinimumMoneyAccount (BigDecimal moneyAccount) throws DaoException;

    List<Patient> findByMaxDiscount(Integer discount) throws DaoException;

    Optional<Patient> findPatientByLogin(String login) throws DaoException;

    boolean updateInsurance(long id, Boolean insurance) throws DaoException;

    boolean updateDiscount(long id, Integer discount) throws DaoException;

    boolean updateMoneyAccount(long id, BigDecimal moneyAccount) throws DaoException;

    boolean deletePatient(long id) throws DaoException;

    boolean archivPatient(long id) throws DaoException;
}
