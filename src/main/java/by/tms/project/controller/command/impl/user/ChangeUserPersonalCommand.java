package by.tms.project.controller.command.impl.user;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.TYPE;
import static by.tms.project.controller.command.RequestParameter.VALUE;

public class ChangeUserPersonalCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        User user =(User) request.getSession().getAttribute(SESSION_USER);
        String type = request.getParameter(TYPE);
        String value = request.getParameter(VALUE);









        return router;
    }
}
