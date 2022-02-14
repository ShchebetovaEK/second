package by.tms.project.controller.command.impl.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.PatientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.VIEW_ALL_DOCTOR;
import static by.tms.project.controller.command.PagePath.VIEW_ALL_PATIENT_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;

/**
 * @author ShchebetovaEK
 *
 * class DoctorViewAllPatientCommand
 */
public class DoctorViewAllPatientCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        try {
            List<Patient> userList = patientService.findAll();
            request.setAttribute(USER_LIST, userList);
            request.setAttribute(PATIENT_REQ, Boolean.TRUE);
            router.setPage(VIEW_ALL_PATIENT_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at DoctorViewAllPatientCommand", e);
            throw new CommandException("Failed at DoctorViewAllPatientCommand ", e);
        }
        return router;
    }
}
