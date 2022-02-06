package by.tms.project.controller.command.impl.admin.create;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.REGISTRATION_PAGE;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestParameter.*;
import static by.tms.project.controller.command.RequestParameter.EMAIL;

/**
 * @author ShchebetovaEK
 *
 * class AdminRegisterDoctorCommand
 *
 */
public class AdminRegisterDoctorCommand  implements Command {

    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
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
        Map<String, String> checkData = new HashMap<>();
        checkData.put(LOGIN, request.getParameter(LOGIN));
        checkData.put(PASSWORD, request.getParameter(PASSWORD));
//        checkData.put(CONFIRMED_PASSWORD,request.getParameter(CONFIRM_PASSWORD));
        checkData.put(FIRST_NAME, request.getParameter(FIRST_NAME));
        checkData.put(LAST_NAME, request.getParameter(LAST_NAME));
        checkData.put(DATA_BIRTHDAY, request.getParameter(DATA_BIRTHDAY));
        checkData.put(ADDRESS, request.getParameter(ADDRESS));
        checkData.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
        checkData.put(EMAIL, request.getParameter(EMAIL));
        checkData.put(CATEGORY,request.getParameter(CATEGORY));
        checkData.put(EXPERIENCE,request.getParameter(EXPERIENCE));
        checkData.put(SPECIALITY,request.getParameter(SPECIALITY));

        try {
            boolean registration = doctorService.registerNewDoctor(checkData);
            router.setPage(registration ? USER_MANAGER_PAGE : REGISTRATION_PAGE);
            return router;
        } catch (ServiceException e) {
            logger.error("Failed at AdminRegisterDoctorCommand", e);
            throw new CommandException("Failed at AdminRegisterDoctorCommand", e);
        }
    }
}
