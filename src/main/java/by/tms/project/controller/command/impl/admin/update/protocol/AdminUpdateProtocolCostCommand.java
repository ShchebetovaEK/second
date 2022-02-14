package by.tms.project.controller.command.impl.admin.update.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_COST;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_ID;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminUpdateProtocolCostCommand
 */
public class AdminUpdateProtocolCostCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strProtocolCost = request.getParameter(PROTOCOL_COST);
        String strProtocolId = request.getParameter(PROTOCOL_ID);
        if (strProtocolCost.isEmpty() && strProtocolId.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Long protocolCost = Long.valueOf(strProtocolCost);
        Long protocolId = Long.valueOf(strProtocolId);
        try {
            if (protocolCost != null && protocolId != null) {
                protocolService.updateProtocolCost(protocolCost, protocolId);
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at  AdminUpdateProtocolCommand", e);
            throw new CommandException("Failed at AdminUpdateProtocolCommand", e);
        }

        return router;
    }
}
