package by.tms.project.model.service;

import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;

public class ServiceProvider {
    public  static  final ServiceProvider instance = new ServiceProvider();
    private UserService userService = UserServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private ServiceProvider(){

    }

    public static ServiceProvider getInstance(){
        return ServiceProvider.instance;

    }

    public UserService getUserService(){
        return userService;
    }

    public DoctorService getDoctorService(){
        return doctorService;
    }

    public PatientService getPatientService(){
        return patientService;
    }

    public ProtocolService getProtocolService(){
        return protocolService;
    }
}
