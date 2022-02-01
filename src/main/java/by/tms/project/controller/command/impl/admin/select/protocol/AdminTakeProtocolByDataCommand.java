package by.tms.project.controller.command.impl.admin.select.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author ShchebetovaEK
 *
 *  class AdminTakeProtocolByDataCommand
 */
public class AdminTakeProtocolByDataCommand implements Command {


    /**
     *
     * @param request the request
     * @return  the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        //todo
        return router;
    }
}
