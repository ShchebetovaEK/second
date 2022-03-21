package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class RegistrationCommand
 */
public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String SUBJECT = "REGISTRATION";
    private UserService userService = UserServiceImpl.getInstance();

    /**
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
        checkData.put(FIRST_NAME, request.getParameter(FIRST_NAME));
        checkData.put(LAST_NAME, request.getParameter(LAST_NAME));
        checkData.put(DATA_BIRTHDAY, request.getParameter(DATA_BIRTHDAY));
        checkData.put(ADDRESS, request.getParameter(ADDRESS));
        checkData.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
        checkData.put(EMAIL, request.getParameter(EMAIL));

        try {
            boolean registration = userService.registerNewUser(checkData);
            router.setPage(registration ? SIGN_IN_PAGE : REGISTRATION_PAGE);


//            if (!registration) {
//                for (String key : checkData.keySet()) {
//                    String validationResult = checkData.get(key);
//                    if (Boolean.parseBoolean(validationResult)) {
//                        switch (key) {
//                        }
//                    }
//                }
//            }
            if (registration) {
                HttpSession session = request.getSession();
                session.setAttribute(LOGIN,checkData.get(LOGIN));
                userService.sendMessage(SUBJECT,checkData.get(LOGIN));
            }
        } catch (ServiceException e) {
            throw new CommandException("Failed at RegistrationCommand", e);
        }
        return router;
    }
}
