package by.tms.project.controller.command.impl.move;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static by.tms.project.controller.command.PagePath.REGISTRATION_PAGE;

/**
 * @author ShchebetovaEK
 * <p>
 * class GoToRegistrationCommand
 */
public class GoToRegistrationCommand implements Command {

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        router.setPage(REGISTRATION_PAGE);
        return router;
    }
}
