package by.tms.project.model.dao;

import by.tms.project.model.dao.impl.DoctorDaoImpl;
import by.tms.project.model.dao.impl.PatientDaoImpl;
import by.tms.project.model.dao.impl.ProtocolDaoImpl;
import by.tms.project.model.dao.impl.UserDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
    private UserDao userDao = UserDaoImpl.getInstance();
    private DoctorDao doctorDao = DoctorDaoImpl.getInstance();
    private PatientDao patientDao = PatientDaoImpl.getInstance();
    private ProtocolDao protocolDao = ProtocolDaoImpl.getInstance();

    private DaoProvider() {

    }

    private static DaoProvider getInstance() {
        return DaoProvider.instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public ProtocolDao getProtocolDao() {
        return protocolDao;
    }
}
