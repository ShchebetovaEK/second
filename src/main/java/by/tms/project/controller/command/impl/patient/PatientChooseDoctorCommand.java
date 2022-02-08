package by.tms.project.controller.command.impl.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.*;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.CHOOSE_DOCTOR;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.*;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_PATIENTS_USERS_ID;
import static by.tms.project.controller.command.SessionAttribute.*;

public class PatientChooseDoctorCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return  the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String category = request.getParameter(RequestParameter.CATEGORY);
        String experience = request.getParameter(RequestParameter.EXPERIENCE);
        String speciality = request.getParameter(RequestParameter.SPECIALITY);
        // todo



        try {
            List<Doctor> chooseDoctor = doctorService.chooseDoctor(Category.valueOf(category.toUpperCase()),
                    Experience.valueOf(experience.toUpperCase()), Speciality.valueOf(speciality.toUpperCase()));
            request.setAttribute(USER_LIST, chooseDoctor);
            request.setAttribute(DOCTOR, Boolean.TRUE);
            router.setPage(CHOOSE_DOCTOR);
        } catch (ServiceException e) {
            logger.error("Failed at PatientChooseDoctorCommand ", e);
            throw new CommandException("Failed at PatientChooseDoctorCommand", e);
        }
        return router;
    }
}
