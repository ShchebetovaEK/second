package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.LOGIN;
import static by.tms.project.controller.command.RequestParameter.PASSWORD;

/**
 * @author ShchebetovaEK
 *
 *  class LogInCommand
 */
public class LogInCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
    UserServiceImpl userService = UserServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Router router = new Router();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        try {
            Optional<User> optionalUser = userService.findUserByLoginAndPassword(login, password);
            if (optionalUser.isPresent()) {
                session.setAttribute(SESSION_USER, optionalUser.get());

                if (optionalUser.get().getRole().equals(Role.ADMIN)) {
                    session.setAttribute(ADMIN, Boolean.TRUE);
                    router.setPage(USER_MANAGER_PAGE);
                }
                if (optionalUser.get().getRole().equals(Role.DOCTOR)) {
                    session.setAttribute(DOCTOR, Boolean.TRUE);
                    router.setPage(DOCTORS);
                }
                if (optionalUser.get().getRole().equals(Role.PATIENT)) {
                    session.setAttribute(PATIENT, Boolean.TRUE);
                    router.setPage(WELCOME_PAGE);
                }
            } else {
                router.setPage(LOGIN_PAGE);
            }

        } catch (ServiceException e) {
            logger.error("Failed at RegistrationCommand", e);
            throw new CommandException("Failed at RegistrationCommand", e);
        }
        return router;
    }
}
