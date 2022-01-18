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
        try {
            boolean registration = userService.registerNewUser(checkData);
            String currentPage = (String) request.getSession().getAttribute(CURRENT_PAGE);

            if (currentPage.equals(USER_MANAGER_PAGE)) {
                request.setAttribute(USER_LIST, userService.findAll());
                router.setPage(USER_MANAGER_PAGE);
            } else {
                if (registration) {
                    router.setPage(ACCOUNT_PAGE);
                } else {
                    router.setPage(REGISTRATION_PAGE);
                }
            }
            if (!registration) {
                for (String key : checkData.keySet()) {
                    String validation = checkData.get(key);
                    if (Boolean.parseBoolean(validation)){
                        switch (key){
                            case LOGIN -> request.setAttribute(VALID_LOGIN,request.getParameter(LOGIN));

                        }
                    }
                }

            }
            request.setAttribute(REGISTRATION, registration);
            return router;
        } catch (ServiceException e) {
            logger.error("", e);
            throw new CommandException("", e);
        }
    }
}
