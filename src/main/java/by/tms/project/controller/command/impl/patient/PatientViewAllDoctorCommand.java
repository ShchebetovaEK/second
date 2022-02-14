package by.tms.project.controller.command.impl.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.VIEW_ALL_DOCTOR;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR_REQ;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class PatientViewAllDoctorCommand
 */
public class PatientViewAllDoctorCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        try {
            List<Doctor> userList = doctorService.findAll();
            request.setAttribute(USER_LIST, userList);
            request.setAttribute(DOCTOR_REQ, Boolean.TRUE);
            router.setPage(VIEW_ALL_DOCTOR);
        } catch (ServiceException e) {
            logger.error("Failed at PatientViewAllDoctorCommand", e);
            throw new CommandException("Failed at PatientViewAllDoctorCommand", e);
        }
        return router;
    }
}
