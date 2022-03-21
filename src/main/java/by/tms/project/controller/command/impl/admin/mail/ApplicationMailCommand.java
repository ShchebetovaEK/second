package by.tms.project.controller.command.impl.admin.mail;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Application;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_APPLICATION;

public class ApplicationMailCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String SUBJECT = "APPLICATION APPROVED";
    private static final String APPROVED = "APPROVED";
    private UserService userService = UserServiceImpl.getInstance();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        try {
            List<Protocol> protocolList = protocolService.findByApplication(Application.valueOf(APPROVED));
            if (!protocolList.isEmpty()) {
                for (int i = 0; i < protocolList.size(); i++) {
                    Protocol protocol = protocolList.get(i);
                    Long patientId = protocol.getPatientsUsersId();
                    Optional<User> patient = userService.findUserById(patientId);
                    if (patient.isPresent()) {
                        String patientLogin = patient.get().getLogin();
                        userService.sendMessage(SUBJECT, patientLogin);
                    }
                    router.setPage(SUCCESS_PAGE);
                }
            } else {
                router.setPage(NO_MATCH_PAGE);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }
}