package by.tms.project.controller.command.impl.admin.select.user;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeUserByFirstNameCommand
 */
public class AdminTakeUserByFirstNameCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        User user;
        String firstName = request.getParameter(RequestParameter.FIRST_NAME);
        if (firstName.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {
            List<User> userList = userService.findByFirstName(firstName);
            request.setAttribute(USER_LIST, userList);
            router.setPage(USER_MANAGER_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeUserByLastName", e);
            throw new CommandException("Failed at AdminTakeUserByLastName", e);
        }
        return router;
    }
}
