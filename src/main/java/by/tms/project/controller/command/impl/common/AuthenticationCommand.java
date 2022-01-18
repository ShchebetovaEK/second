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

import java.util.Optional;

import static by.tms.project.controller.command.PagePath.AUTHENTICATION_PAGE;
import static by.tms.project.controller.command.PagePath.MAIN_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.LOGIN;
import static by.tms.project.controller.command.RequestParameter.PASSWORD;
import static by.tms.project.controller.command.Router.RouterType.REDIRECT;

public class AuthenticationCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        try {
            Optional<User> optionalUser = userService.findUserByLoginAndPassword(login, password);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                switch (user.getRole()) {
                    case ADMIN -> {
                        session.setAttribute(SESSION_USER, user);
                        request.setAttribute(AUTHENTICATION_PAGE, Boolean.TRUE);
                    }
                    case DOCTOR -> {
                        session.setAttribute(SESSION_DOCTOR, user);
                        request.setAttribute(AUTHENTICATION_PAGE, Boolean.TRUE);
                    }
                    case PATIENT -> {
                        session.setAttribute(SESSION_PATIENT, user);
                        request.setAttribute(AUTHENTICATION, Boolean.TRUE);
                    }
                    default -> {
                        request.setAttribute(MAIN_PAGE, Boolean.FALSE);
                    }
                }
            }
            router.setPage(MAIN_PAGE);
            router.setRouterType(REDIRECT);
            return router;
        } catch (ServiceException e) {
            logger.error("", e);
            throw new CommandException("", e);
        }
    }
}
