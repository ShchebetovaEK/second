package by.tms.project.controller.command.impl.admin.update.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Application;
import by.tms.project.model.entity.Status;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestParameter.*;

public class AdminUpdateProtocolStatusCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strProtocolId = request.getParameter(PROTOCOL_ID);
        Long protocolId = Long.valueOf(strProtocolId);
        String protocolStatus = request.getParameter(PROTOCOL_STATUS).toUpperCase();

        try {
            protocolService.updateProtocolStatus(protocolId, Status.valueOf(protocolStatus));
        } catch (ServiceException e) {
            logger.error("Failed at AdminUpdateProtocolStatusCommand ", e);
            throw new CommandException("Failed at AdminUpdateProtocolStatusCommand", e);
        }

        return router;
    }
}
