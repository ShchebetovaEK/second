package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.LOGIN;
import static by.tms.project.controller.command.RequestParameter.PASSWORD;
import static by.tms.project.controller.command.SessionAttribute.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class LogInCommand
 */
public class LogInCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
    UserServiceImpl userService = UserServiceImpl.getInstance();

    /**
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
                switch (optionalUser.get().getRole()) {
                    case ADMIN -> {
                        session.setAttribute(ADMIN, Boolean.TRUE);
                        router.setPage(ADMIN_PAGE);
                    }
                    case DOCTOR -> {
                        session.setAttribute(DOCTOR, Boolean.TRUE);
                        router.setPage(DOCTOR_PAGE);
                    }
                    case PATIENT -> {
                        session.setAttribute(PATIENT, Boolean.TRUE);
                        router.setPage(WELCOME_PAGE);
                    }
                    default -> router.setPage(LOGIN_PAGE);
                }

            } else {
                session.setAttribute("authFailed", Boolean.TRUE);
                request.setAttribute("loginFail",Boolean.TRUE);
                //session
                request.setAttribute("passwordFail",Boolean.TRUE);
                router.setPage(SIGN_IN_PAGE);
            }

        } catch (ServiceException e) {
            logger.error("Failed at LogInCommand", e);
            throw new CommandException("Failed at LogInCommand", e);
        }
        return router;
    }
}
