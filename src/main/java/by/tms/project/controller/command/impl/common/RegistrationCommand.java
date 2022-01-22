package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.*;
import static by.tms.project.controller.command.RequestParameter.LOGIN;
import static by.tms.project.controller.command.RequestParameter.PASSWORD;

public class RegistrationCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

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
        checkData.put(ROLE, request.getParameter(ROLE));
        try {            boolean registration = userService.registerNewUser(checkData);
            router.setPage(registration ? ACCOUNT_PAGE : REGISTRATION_PAGE);
            if (!registration) {
                for (String key : checkData.keySet()) {
                    String validation = checkData.get(key);
                    if (Boolean.parseBoolean(validation)) {
                        switch (key) {
                            case LOGIN -> request.setAttribute(VALID_LOGIN, request.getParameter(LOGIN));
                            case EMAIL -> request.setAttribute(VALID_EMAIL, request.getParameter(EMAIL));
                            case PHONE_NUMBER -> request.setAttribute(VALID_PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
                        }
                    } else {
                        switch (validation) {
                            case INVALID_LOGIN -> request.setAttribute(INVALID_LOGIN, INVALID_MESSAGE);
                            case NOT_VALID_LOGIN ->  request.setAttribute(INVALID_LOGIN, NOT_UNIQUE_MESSAGE);
                            case INVALID_EMAIL -> request.setAttribute(INVALID_EMAIL, INVALID_MESSAGE);
                            case NOT_VALID_EMAIL  -> request.setAttribute(INVALID_EMAIL, NOT_UNIQUE_MESSAGE);
                            case INVALID_PHONE_NUMBER  -> request.setAttribute(INVALID_PHONE_NUMBER, INVALID_MESSAGE);
                            case NOT_VALID_PHONE_NUMBER -> request.setAttribute(INVALID_PHONE_NUMBER, NOT_UNIQUE_MESSAGE);
                        }
                        logger.debug("validation result" + key + "-" + validation);
                    }
                }
            }
            request.setAttribute(REGISTRATION, registration);
            return router;
        } catch (
                ServiceException e) {
            logger.error("", e);
            throw new CommandException("", e);
        }
    }
}
