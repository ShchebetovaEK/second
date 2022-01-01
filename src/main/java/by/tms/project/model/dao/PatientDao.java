package by.tms.project.model.dao;

import by.tms.project.exception.DaoException;
import by.tms.project.model.entity.Patient;

import java.math.BigDecimal;
import java.util.Optional;

public interface PatientDao extends BaseDao<Long,Patient>{

    Optional<Patient> findByInsurance(Boolean insurance) throws DaoException;

    Optional<Patient> findByMinimumMoneyAccount (BigDecimal moneyAccount) throws DaoException;

    Optional<Patient> findByMaxDiscount(Integer discount) throws DaoException;
}
