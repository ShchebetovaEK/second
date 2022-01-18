package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static by.tms.project.controller.command.PagePath.MAIN_PAGE;
import static by.tms.project.controller.command.PagePath.WELCOME;

public class GoToWelcome implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        router.setPage(WELCOME);
        return router;
    }
}