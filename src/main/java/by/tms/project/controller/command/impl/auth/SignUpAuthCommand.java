package by.tms.project.controller.command.impl.auth;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.impl.UIServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import by.tms.project.model.validator.SignUpValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SignUpAuthCommand implements Command {
    private final SignUpValidator signUpValidator = SignUpValidator.getInstance();
    private final UserServiceImpl userService;
    private final UIServiceImpl uiService;

    public SignUpAuthCommand(UserServiceImpl userService, UIServiceImpl uiService) {
        this.userService = userService;
        this.uiService = uiService;
    }

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
// TODO: 12.01.2022  
        return router;
    }
}

