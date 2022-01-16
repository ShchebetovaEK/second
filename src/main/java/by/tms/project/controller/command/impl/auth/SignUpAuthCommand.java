package by.tms.project.controller.command.impl.auth;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.impl.UIServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import by.tms.project.model.validator.SignUpValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static by.tms.project.controller.command.RequestParameter.LOGIN;
import static by.tms.project.controller.command.RequestParameter.PASSWORD;

public class SignUpAuthCommand implements Command {
   private static final Logger logger = LogManager.getLogger();
    private final SignUpValidator signUpValidator = SignUpValidator.getInstance();
    private final UserServiceImpl userService;


    public SignUpAuthCommand(UserServiceImpl userService) {
        this.userService = userService;

    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password =request.getParameter(PASSWORD);
        try{
            Optional<User> optionalUser = userService.findUserByLoginAndPassword(login,password);
            if (optionalUser.isPresent()){
                User user = optionalUser.get();

        }
//            else {
//                request.setAttribute(AUT,Boolean.FALSE);
//            }
//            router.setPage(WELCOME);
//            router.setRedirect(REdirect);
        return router;
    } catch (ServiceException e) {
            logger.error("",e);
            throw new CommandException("",e);
        }
    }
}

