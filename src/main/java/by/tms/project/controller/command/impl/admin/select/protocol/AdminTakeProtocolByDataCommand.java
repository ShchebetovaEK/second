package by.tms.project.controller.command.impl.admin.select.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.PROTOCOL_PAGE;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL;
import static by.tms.project.controller.command.RequestAttribute.PROTOCOL_LIST;
import static by.tms.project.controller.command.RequestParameter.PROTOCOL_DATA;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeProtocolByDataCommand
 */
public class AdminTakeProtocolByDataCommand implements Command {

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
        String strData = request.getParameter(PROTOCOL_DATA);
        LocalDate protocolData = null;
        if (strData.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        protocolData = LocalDate.parse(strData);
        try {
            if (protocolData != null) {
                List<Protocol> protocolList = protocolService.findByData(protocolData);
                request.setAttribute(PROTOCOL_LIST, protocolList);
                request.setAttribute(PROTOCOL, Boolean.TRUE);
                router.setPage(PROTOCOL_PAGE);
            }
            else {
                router.setPage(FAIL_PAGE);

            }        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeProtocolByDataCommand");
            throw new CommandException("Failed at AdminTakeProtocolByDataCommand", e);
        }
        return router;
    }
}
