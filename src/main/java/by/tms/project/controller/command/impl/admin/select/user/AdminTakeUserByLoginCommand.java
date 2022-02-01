package by.tms.project.controller.command.impl.admin.select.user;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.OPTIONAL_USER;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

public class AdminTakeUserByLoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        User user;
        String login = request.getParameter(RequestParameter.LOGIN);
        try {
            Optional<User> optionalUser = userService.findByLogin(login);
            if (optionalUser.isPresent()) {
                 user = optionalUser.get();
                 List<User> userList = new ArrayList<>();
                 userList.add(user);
                request.setAttribute(USER_LIST, userList);
                router.setPage(USER_MANAGER_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeUserByLoginCommand",e);
            throw new CommandException("Failed at AdminTakeUserByLoginCommand", e);
        }
        return router;
    }
}
