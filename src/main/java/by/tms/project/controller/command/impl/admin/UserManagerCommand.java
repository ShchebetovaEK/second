package by.tms.project.controller.command.impl.admin;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 *
 *  class UserManagerCommand
 */
public class UserManagerCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
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
            HttpSession session = request.getSession();
            try {
                List<User> userList = userService.findAll();
                session.setAttribute(USER_LIST, userList);
                router.setPage(USER_MANAGER_PAGE);
                return router;
            } catch (ServiceException e) {
                logger.error( "Users cannot be found:", e);
                throw new CommandException("Users cannot be found:", e);
            }
    }
}
