package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.ERROR_404_PAGE;
import static by.tms.project.controller.command.PagePath.WELCOME_PAGE;
import static by.tms.project.controller.command.RequestParameter.ID;


public class VerificationAuthCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String page;
        long id = Long.parseLong(request.getParameter(ID));
        try {
            if (userService.verify(id)) {
                page = WELCOME_PAGE;
            } else {
                page = ERROR_404_PAGE;
            }
            router.setPage(request.getContextPath() + page);
           // router.setRedirect();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return router;
    }
}