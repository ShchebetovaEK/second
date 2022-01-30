package by.tms.project.controller.command.impl.user;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.*;

public class ChangeUserPersonalCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        String type = request.getParameter(TYPE);
        String value = request.getParameter(VALUE);

        try {
            type = type != null ? type : EMPTY;
            boolean result = switch (type) {
                case FIRST_NAME -> {
                    boolean changePersonalData = userService.updateFirstNameById(user.getId(), value);
                    request.setAttribute(FIRST_NAME_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                case LAST_NAME -> {
                    boolean changePersonalData = userService.updateLastNameById(user.getId(), value);
                    request.setAttribute(LAST_NAME_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                case ADDRESS -> {
                    boolean changePersonalData = userService.updateAddressById(user.getId(), value);
                    request.setAttribute(ADDRESS_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                case EMAIL -> {
                    boolean changePersonalData = userService.updateEmailById(user.getId(), value);
                    request.setAttribute(EMAIL_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                case PHONE_NUMBER -> {
                    boolean changePersonalData = userService.updatePhoneNumberById(user.getId(), value);
                    request.setAttribute(PHONE_NUMBER_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                case DATA_BIRTHDAY -> {
                    boolean changePersonalData = userService.updateDataBirthdayById(user.getId(), value);
                    request.setAttribute(DATA_BIRTHDAY_CHANGE, changePersonalData);
                    yield changePersonalData;
                }
                default -> {
                    logger.log(Level.WARN, "Unexpected value: " + type);
                    yield false;
                }
            };
            return router;

        } catch (ServiceException e) {
            logger.log(Level.ERROR, "", e);
            throw new CommandException("", e);
        }
    }
}

