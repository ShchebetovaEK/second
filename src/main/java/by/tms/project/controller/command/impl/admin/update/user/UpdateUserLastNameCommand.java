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
import static by.tms.project.controller.command.RequestParameter.LAST_NAME;

/**
 * @author ShchebetovaEK
 * <p>
 * class  UpdateUserLastNameCommand
 */
public class UpdateUserLastNameCommand implements Command {
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
        String upLastName = request.getParameter(LAST_NAME);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        Long userId = user.getId();
//        String strId = request.getParameter(ID);
//        if (upLastName.isEmpty() && strId.isEmpty()) {
        if (upLastName.isEmpty() ) {
            router.setPage(FAIL_PAGE);
            return router;
        }
//        Long id = Long.valueOf(strId);
        Long id = Long.valueOf(userId);
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute(SESSION_USER);
        try {
//            if (upLastName != null && strId != null) {
            if (upLastName != null ) {
                userService.updateLastNameById(id, upLastName);
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at UpdateUserLastNameCommand", e);
            throw new CommandException("Failed at UpdateUserLastNameCommand", e);
        }

        return router;
    }
}
