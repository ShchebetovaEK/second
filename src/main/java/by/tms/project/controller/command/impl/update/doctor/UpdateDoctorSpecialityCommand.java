package by.tms.project.controller.command.impl.update.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;

public class UpdateDoctorSpecialityCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String speciality = request.getParameter(SPECIALITY).toUpperCase();
        Long id = Long.valueOf(request.getParameter(USERS_ID));
        HttpSession session = request.getSession();
        Doctor doctor = (Doctor) session.getAttribute(SESSION_USER);
        try {
            doctorService.updateSpeciality(id, Speciality.valueOf(speciality));
        } catch (ServiceException e) {
            logger.error("Failed at UpdateDoctorSpecialityCommand", e);
            throw new CommandException("Failed at UpdateDoctorSpecialityCommand", e);
        }

        return router;
    }
}
