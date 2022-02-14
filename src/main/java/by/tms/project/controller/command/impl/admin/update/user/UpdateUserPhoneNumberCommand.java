package by.tms.project.controller.command.impl.admin.update.user;

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

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.ID;
import static by.tms.project.controller.command.RequestParameter.PHONE_NUMBER;

/**
 * @author ShchebetovaEK
 * <p>
 * class  UpdateUserPhoneNumberCommand
 */
public class UpdateUserPhoneNumberCommand implements Command {
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
        String upPhoneNumber = request.getParameter(PHONE_NUMBER);
        String strId = request.getParameter(ID);
        if (upPhoneNumber.isEmpty() && strId.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Long id = Long.valueOf(strId);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        try {
            if (upPhoneNumber != null && strId != null) {
                userService.updatePhoneNumberById(id, upPhoneNumber);
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at UpdateUserPhoneNumberCommand", e);
            throw new CommandException("Failed at UpdateUserPhoneNumberCommand", e);
        }

        return router;
    }
}
