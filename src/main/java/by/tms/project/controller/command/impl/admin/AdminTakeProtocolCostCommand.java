package by.tms.project.controller.command.impl.admin;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.PROTOCOL_PAGE;
import static by.tms.project.controller.command.PagePath.WELCOME_PAGE;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL_LIST;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_ID;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_ID_SUM;

public class AdminTakeProtocolCostCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return  the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strProtocolId = request.getParameter(PROTOCOL_ID_SUM);
        Long protocolId = Long.valueOf(strProtocolId);
        try {
          protocolService.takeProtocolCost(protocolId);

            router.setPage(WELCOME_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeProtocolCostCommand");
            throw new CommandException("Failed at AdminTakeProtocolCostCommand", e);
        }
        return router;
    }
}
