package by.tms.project.controller.command.impl.common;

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

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.ACCOUNT_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;
import static by.tms.project.controller.command.SessionAttribute.LOGIN;

public class ChangeAccountCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
     private UserService userService = UserServiceImpl.getInstance();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        String login = user.getLogin();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String dataBirthday = String.valueOf(user.getDataBirthday());
        String address = user.getAddress();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();

        Map<String, String> checkData = new HashMap<>();
        checkData.put(LOGIN, request.getParameter(LOGIN));
        checkData.put(PASSWORD, request.getParameter(PASSWORD));
        checkData.put(FIRST_NAME, request.getParameter(FIRST_NAME));
        checkData.put(LAST_NAME, request.getParameter(LAST_NAME));
        checkData.put(DATA_BIRTHDAY, request.getParameter(DATA_BIRTHDAY));
        checkData.put(ADDRESS, request.getParameter(ADDRESS));
        checkData.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
        checkData.put(EMAIL, request.getParameter(EMAIL));


        try {
            if (!login.equals(checkData.get(LOGIN))) {
                userService.setLogin(user, checkData.get(LOGIN));
            }
            if (!firstName.equals(checkData.get(FIRST_NAME))) {
                userService.updateFirstNameById(user.getId(), checkData.get(FIRST_NAME));
            }
            if (!lastName.equals(checkData.get(LAST_NAME))) {
                userService.updateLastNameById(user.getId(), checkData.get(LAST_NAME));
            }
            if (!dataBirthday.equals(checkData.get(DATA_BIRTHDAY))) {
                userService.updateDataBirthdayById(user.getId(), checkData.get(DATA_BIRTHDAY));
            }
            if (!address.equals(checkData.get(ADDRESS))) {
                userService.updateAddressById(user.getId(), checkData.get(ADDRESS));
            }
            if (!email.equals(checkData.get(EMAIL))) {
                userService.updateEmailById(user.getId(), checkData.get(EMAIL));
            }
            if (!phoneNumber.equals(checkData.get(PHONE_NUMBER))) {
                userService.updatePhoneNumberById(user.getId(), checkData.get(PHONE_NUMBER));
            }


            session.removeAttribute(SESSION_USER);
            session.setAttribute(SESSION_USER, userService.findUserById(user.getId()).get());

            router.setPage(ACCOUNT_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Failed at ChangeAccountCommand", e);
        }
        return router;
    }
}
