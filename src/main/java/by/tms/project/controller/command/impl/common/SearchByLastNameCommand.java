package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

public class SearchByLastNameCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String lastName = request.getParameter(RequestParameter.LAST_NAME);
        if (lastName.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {

            List<User> userList = userService.searchByLastName(lastName);
            request.setAttribute(USER_LIST, userList);
            if (userList.isEmpty()) {
                router.setPage(NO_MATCH_PAGE);
            } else {
                router.setPage(SEARCH_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at SearchByLastNameCommand", e);
            throw new CommandException("Failed at SearchByLastNameCommand", e);
        }
        return router;
    }
}
