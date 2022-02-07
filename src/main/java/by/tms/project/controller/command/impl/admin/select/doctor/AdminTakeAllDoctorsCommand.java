package by.tms.project.controller.command.impl.admin.select.doctor;

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

import static by.tms.project.controller.command.PagePath.SELECT_DOCTOR_PAGE;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 *
 * class AdminTakeAllDoctorsCommand
 */
public class AdminTakeAllDoctorsCommand implements Command {
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
            request.setAttribute(DOCTOR, Boolean.TRUE);
            router.setPage(SELECT_DOCTOR_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeAllDoctorsCommand", e);
            throw new CommandException("Failed at AdminTakeAllDoctorsCommand", e);
        }
        return router;
    }
}
