package by.tms.project.controller.command.impl.move;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static by.tms.project.controller.command.PagePath.OUR_DOCTORS_PAGE;

/**
 * @author ShchebetovaEK
 *
 *  class GoToDoctorsCommand
 */
public class GoToOurDoctorsCommand implements Command {

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        router.setPage(OUR_DOCTORS_PAGE);
        return router;
    }
}
