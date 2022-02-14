package by.tms.project.controller.command.impl.admin.select.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.validator.DoctorValidator;
import by.tms.project.model.validator.impl.DoctorValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR_REQ;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeDoctorByExperienceCommand
 */
public class AdminTakeDoctorByExperienceCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();
    private DoctorValidator doctorValidator = DoctorValidatorImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strExperience = request.getParameter(RequestParameter.EXPERIENCE);
        if (strExperience.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {
            String experience = strExperience.toUpperCase();
            if (doctorValidator.isExperienceValid(experience)) {
                List<Doctor> userList = doctorService.findDoctorByExperience(Experience.valueOf(experience));
                request.setAttribute(USER_LIST, userList);
                request.setAttribute(DOCTOR_REQ, Boolean.TRUE);
                router.setPage(SELECT_DOCTOR_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeDoctorByExperienceCommand ", e);
            throw new CommandException("Failed at AdminTakeDoctorByExperienceCommand", e);
        }
        return router;
    }
}