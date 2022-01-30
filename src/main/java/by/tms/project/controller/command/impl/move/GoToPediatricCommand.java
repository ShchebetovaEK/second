package by.tms.project.controller.command.impl.move;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static by.tms.project.controller.command.PagePath.PEDIATRIC_PAGE;

public class GoToPediatricCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        router.setPage(PEDIATRIC_PAGE);
        return router;
    }
}
