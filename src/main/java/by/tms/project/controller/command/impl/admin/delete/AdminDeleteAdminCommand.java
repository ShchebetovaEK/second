package by.tms.project.controller.command.impl.admin.delete;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.USERS_ID;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminDeleteAdminCommand
 */
public class AdminDeleteAdminCommand implements Command {
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
        String strId = request.getParameter(USERS_ID);
        if (strId.isEmpty()) {
           router.setPage(FAIL_PAGE);
           return router;
        }
        Long id = Long.valueOf(strId);

        try {
         Optional<User> userOptional =  userService.findUserById(id);
         Role userRole = userOptional.get().getRole();
         if (userRole == Role.ADMIN){
             userService.delete(id);
             router.setPage(SUCCESS_PAGE);
         }
         else {
             router.setPage(FAIL_PAGE);
         }
        } catch (ServiceException e) {
            logger.error("Failed at AdminDeleteAdminCommand", e);
            throw new CommandException("Failed at AdminDeleteAdminCommand", e);
        }
        return router;
    }
}
