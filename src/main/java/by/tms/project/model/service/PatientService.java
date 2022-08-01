package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAll() throws ServiceException;

    Optional<Patient> findPatientByLogin(String login) throws ServiceException;

    Optional<Patient> findBalance(long id) throws ServiceException;

    List<Patient> findByInsurance(Boolean insurance) throws ServiceException;

    List<Patient> findByMoneyAccount(long firstRange, long secondRange) throws ServiceException;

    List<Patient> findMinBalance(int minBalance) throws ServiceException;

    List<Patient> findByDiscount(Integer discount) throws ServiceException;

    boolean create(Map<String, String> userCheck) throws ServiceException;

    boolean registerNewPatient(Map<String, String> userCheck) throws ServiceException;

    boolean updateInsurance(long id, Boolean insurance) throws ServiceException;

    boolean updateDiscount(long id, Integer discount) throws ServiceException;

    boolean updateMoneyAccount(long id, BigDecimal moneyAccount) throws ServiceException;

    boolean updateBalance(long id, BigDecimal balance) throws ServiceException;

    boolean deletePatient(long id) throws ServiceException;

    boolean archivPatient(long id) throws ServiceException;
}
