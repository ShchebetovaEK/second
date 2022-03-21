package by.tms.project.controller.command.impl.admin.create;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.ADMIN_PAGE;
import static by.tms.project.controller.command.PagePath.REGISTRATION_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;

public class AdminRegisterPatientCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private PatientService patientService = PatientServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();



        Map<String, String> checkData = new HashMap<>();
//        Map<String, String> checkData = new HashMap<>();
//        checkData.put(LOGIN, request.getParameter(LOGIN));
//        checkData.put(PASSWORD, request.getParameter(PASSWORD));
//        checkData.put(FIRST_NAME, request.getParameter(FIRST_NAME));
//        checkData.put(LAST_NAME, request.getParameter(LAST_NAME));
//        checkData.put(DATA_BIRTHDAY, request.getParameter(DATA_BIRTHDAY));
//        checkData.put(ADDRESS, request.getParameter(ADDRESS));
//        checkData.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
//        checkData.put(EMAIL, request.getParameter(EMAIL));
        checkData.put(INSURANCE, request.getParameter(INSURANCE));
        checkData.put(MONEY_ACCOUNT, request.getParameter(MONEY_ACCOUNT));
        checkData.put(DISCOUNT, request.getParameter(DISCOUNT));

        try {
//            boolean registration = patientService.create(checkData);
            boolean registration = patientService.create(checkData);
            router.setPage(registration ? ADMIN_PAGE : REGISTRATION_PAGE);

            return router;
        } catch (ServiceException e) {
            logger.error("Failed at AdminRegisterPatientCommand", e);
            throw new CommandException("Failed at AdminRegisterPatientCommand", e);
        }
    }
}
