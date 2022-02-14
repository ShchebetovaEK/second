package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.MAIN_PAGE;
import static by.tms.project.controller.command.SessionAttribute.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class LogOutCommand
 */
public class LogOutCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        session.removeAttribute(DOCTOR);
        session.removeAttribute(PATIENT);
        session.removeAttribute(ADMIN);
        session.invalidate();
        logger.debug("Session has finished");
        router.setPage(MAIN_PAGE);

        return router;
    }
}
