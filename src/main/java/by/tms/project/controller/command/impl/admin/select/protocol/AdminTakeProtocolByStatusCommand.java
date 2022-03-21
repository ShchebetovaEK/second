package by.tms.project.controller.command.impl.admin.select.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.entity.Status;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import by.tms.project.model.validator.ProtocolValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.PROTOCOL_PAGE;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeProtocolByStatusCommand
 */
public class AdminTakeProtocolByStatusCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private ProtocolValidator protocolValidator = ProtocolValidator.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strProtocolStatus = request.getParameter(RequestParameter.PROTOCOL_STATUS);
        if (strProtocolStatus.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        } else {
            try {
                String status = strProtocolStatus.toUpperCase();
                if (protocolValidator.isStatusValid(status)) {
                    List<Protocol> protocolList = protocolService.findByStatus(Status.valueOf(status));
                    request.setAttribute(PROTOCOL_LIST, protocolList);
                    request.setAttribute(PROTOCOL, Boolean.TRUE);
                    router.setPage(PROTOCOL_PAGE);
                }
            } catch (ServiceException e) {
                logger.error("Failed at AdminTakeProtocolByStatusCommand");
                throw new CommandException("Failed at AdminTakeProtocolByStatusCommand", e);
            }
        }
        return router;
    }
}
