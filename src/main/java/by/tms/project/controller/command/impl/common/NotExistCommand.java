package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static by.tms.project.controller.command.PagePath.ERROR_400_PAGE;
import static by.tms.project.controller.command.RequestAttribute.WRONG_COMMAND;

public class NotExistCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
       Router router = new Router();
       request.setAttribute(WRONG_COMMAND,Boolean.TRUE);
       router.setPage(ERROR_400_PAGE);
        return null;
    }
}
