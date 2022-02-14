package by.tms.project.controller.command.impl.admin.select.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Payer;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import by.tms.project.model.validator.ProtocolValidator;
import by.tms.project.model.validator.impl.ProtocolValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeProtocolByPayerCommand
 */
public class AdminTakeProtocolByPayerCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private UserService userService = UserServiceImpl.getInstance();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private ProtocolValidator protocolValidator = ProtocolValidatorImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strPayer = request.getParameter(RequestParameter.PROTOCOL_PAYER);
        if (strPayer.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        String payer = strPayer.toUpperCase();
        try {
            if (protocolValidator.isPayerValid(payer)) {
                List<Protocol> protocolList = protocolService.findByPayer(Payer.valueOf(payer));
                request.setAttribute(PROTOCOL_LIST, protocolList);
                request.setAttribute(PROTOCOL, Boolean.TRUE);
                router.setPage(PROTOCOL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeProtocolByPayerCommand");
            throw new CommandException("Failed at AdminTakeProtocolByPayerCommand", e);
        }
        return router;
    }
}
