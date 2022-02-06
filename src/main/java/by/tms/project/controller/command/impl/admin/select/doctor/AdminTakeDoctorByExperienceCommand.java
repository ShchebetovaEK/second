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
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.SELECT_DOCTOR;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 *
 *  class AdminTakeDoctorByExperienceCommand
 */
public class AdminTakeDoctorByExperienceCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
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
        String experience = request.getParameter(RequestParameter.EXPERIENCE);

        try {
            List<Doctor> userList = doctorService.findDoctorByExperience(Experience.valueOf(experience.toUpperCase()));
            request.setAttribute(USER_LIST, userList);
            request.setAttribute(DOCTOR, Boolean.TRUE);
            router.setPage(SELECT_DOCTOR);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeDoctorByExperienceCommand ", e);
            throw new CommandException("Failed at AdminTakeDoctorByExperienceCommand", e);
        }
        return router;
    }
}