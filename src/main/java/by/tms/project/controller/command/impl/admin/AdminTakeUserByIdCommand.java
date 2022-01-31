package by.tms.project.controller.command.impl.admin;

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

import java.util.Optional;

import static by.tms.project.controller.command.RequestAttribute.OPTIONAL_USER;

public class AdminTakeUserByIdCommand implements Command {

        private static final Logger logger = LogManager.getLogger();
        private UserService userService = UserServiceImpl.getInstance();

        @Override
        public Router execute(HttpServletRequest request) throws CommandException {
            Router router = new Router();
            User user;
            //todo
            Long id = Long.valueOf(request.getParameter(RequestParameter.ID));
            try {
                Optional<User> optionalUser = userService.findUserById(id);
                if (optionalUser.isPresent()) {
                    user = optionalUser.get();
                    request.setAttribute(OPTIONAL_USER, optionalUser);
                }
            } catch (ServiceException e) {
                logger.error("Failed at AdminTakeUserByLoginCommand",e);
                throw new CommandException("Failed at AdminTakeUserByLoginCommand", e);
            }
            return router;
        }
    }
