package by.tms.project.controller.command.impl.user;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import com.sun.mail.imap.protocol.ID;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static by.tms.project.controller.command.PagePath.ACCOUNT_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;
import static by.tms.project.controller.command.SessionAttribute.*;
import static by.tms.project.controller.command.SessionAttribute.LOGIN;

public class AccountUserCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        String id = request.getParameter(RequestParameter.ID);
        String login = request.getParameter(LOGIN);

        try {
            Optional<User> userList = userService.findByLogin(login);
            request.setAttribute(PATIENT_REQ, Boolean.TRUE);
            router.setPage(ACCOUNT_PAGE);

        } catch (ServiceException e) {
            logger.error("Failed at PatientViewMyProtocolCommand");
            throw new CommandException("Failed at PatientViewMyProtocolCommand", e);
        }
        return router;
    }
}