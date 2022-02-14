package by.tms.project.controller.command.impl.admin.select.protocol;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.PROTOCOL_PAGE;
import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeAllProtocolsCommand
 */
public class AdminTakeAllProtocolsCommand implements Command {
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
        try {
            List<Protocol> protocolList = protocolService.findAll();
            request.setAttribute(PROTOCOL_LIST, protocolList);
            request.setAttribute(PROTOCOL, Boolean.TRUE);
            router.setPage(PROTOCOL_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeAllProtocolCommand");
            throw new CommandException("Failed at AdminTakeAllProtocolCommand", e);
        }
        return router;
    }
}
