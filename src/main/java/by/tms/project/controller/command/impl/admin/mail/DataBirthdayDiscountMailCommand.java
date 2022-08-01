package by.tms.project.controller.command.impl.admin.mail;

import by.tms.project.controller.command.Command;
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

import static by.tms.project.controller.command.PagePath.NO_MATCH_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestParameter.DATA_BIRTHDAY;

public class DataBirthdayDiscountMailCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String SUBJECT = "CONGRATULATIONS";
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String dataBirth = request.getParameter(DATA_BIRTHDAY);
        try {
            List<User> userList = userService.findByDataBirthday(dataBirth);
            if (!userList.isEmpty()) {
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.get(i);
                    String login = user.getLogin();
                    userService.sendMessage(SUBJECT, login);
                }
                router.setPage(SUCCESS_PAGE);

            } else {
                router.setPage(NO_MATCH_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at DataBirthdayDiscountMailCommand ", e);
            throw new CommandException(e);
        }
        return router;
    }
}
