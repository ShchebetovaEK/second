package by.tms.project.controller.command.impl.admin.create;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.PROTOCOL_PAGE;
import static by.tms.project.controller.command.PagePath.PROTOCOL_REGISTRATION;
import static by.tms.project.controller.command.RequestParameter.*;

public class AdminRegisterProtocolCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        Map<String, String> checkData = new HashMap<>();
        checkData.put(PROTOCOL_DATA,request.getParameter(PROTOCOL_DATA));
        checkData.put(PROTOCOL_PAYER,request.getParameter(PROTOCOL_PAYER));
        checkData.put(PROTOCOL_COST,request.getParameter(PROTOCOL_COST));
        checkData.put(PROTOCOL_PATIENTS_USERS_ID,request.getParameter(PROTOCOL_PATIENTS_USERS_ID));
        checkData.put(PROTOCOL_DOCTOR_USERS_ID,request.getParameter(PROTOCOL_DOCTOR_USERS_ID));


        try {
            boolean registration = protocolService.registerProtocol(checkData);

            router.setPage(registration ? PROTOCOL_PAGE : PROTOCOL_REGISTRATION);
            return router;
        } catch (ServiceException e) {
            logger.error("Failed at AdminRegisterProtocolCommand", e);
            throw new CommandException("Failed at AdminRegisterProtocolCommand", e);
        }
    }
}
