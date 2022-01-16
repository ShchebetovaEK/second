package by.tms.project.model.service;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAll() throws ServiceException;

    Optional<Patient> findPatientByLogin(String login) throws ServiceException;

    BigDecimal takePatientMoneyAccount(String login) throws ServiceException;

    boolean createPatient(Patient patient, HttpServletRequest request) throws ServiceException;

    boolean toUpBalance(String login, BigDecimal sumForUp, HttpSession session) throws ServiceException;

}
