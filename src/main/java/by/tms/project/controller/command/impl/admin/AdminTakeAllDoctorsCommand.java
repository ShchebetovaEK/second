package by.tms.project.controller.command.impl.admin;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.ADMIN_PAGE;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.DOCTORS_LIST;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

public class AdminTakeAllDoctorsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();

        try {
            List<Doctor> doctorList = doctorService.findAll();
            request.setAttribute(DOCTORS_LIST, doctorList);
            router.setPage(ADMIN_PAGE);

        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeAllDoctorsCommand",e);
            throw new CommandException("Failed at AdminTakeAllDoctorsCommand", e);
        }
        return router;
    }
}
