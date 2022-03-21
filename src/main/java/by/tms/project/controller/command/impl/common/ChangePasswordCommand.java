package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import by.tms.project.model.util.security.PasswordHash;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.RequestParameter.LOGIN;

public class ChangePasswordCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String SUBJECT = "CHANGE PASSWORD";
    private UserService userService = UserServiceImpl.getInstance();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);

        String password = request.getParameter(PASSWORD);
        String newPassword = request.getParameter(NEW_PASSWORD);
        String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
        try {
            String passwordHash = PasswordHash.encrypt(password);

            if (passwordHash.equals(user.getPassword())) {

                if (newPassword.equals(confirmPassword)) {
                    boolean change = userService.setPassword(user, newPassword);
                    router.setPage(change ? SUCCESS_PAGE : FAIL_PAGE);
                    if (change) {
                        session.setAttribute(LOGIN, user.getLogin());
                        userService.sendMessage(SUBJECT,user.getLogin());
                    }
                }
            } else {
                router.setPage(FAIL_PAGE);
            }

            session.removeAttribute(SESSION_USER);
            session.setAttribute(SESSION_USER, userService.findUserById(user.getId()).get());

        } catch (ServiceException e) {
            throw new CommandException("Failed at ChangeAccountCommand", e);
        }

        return router;
    }
}
