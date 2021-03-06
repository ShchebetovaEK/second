package by.tms.project.controller.command.impl.admin;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_ID_SUM;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeProtocolCostCommand
 */
public class AdminTakeProtocolCostCommand implements Command {
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
        String strProtocolId = request.getParameter(PROTOCOL_ID_SUM);
        Long protocolId = Long.valueOf(strProtocolId);
        try {
            protocolService.takeProtocolCost(protocolId);
            router.setPage(SUCCESS_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeProtocolCostCommand");
            throw new CommandException("Failed at AdminTakeProtocolCostCommand", e);
        }
        return router;
    }
}
