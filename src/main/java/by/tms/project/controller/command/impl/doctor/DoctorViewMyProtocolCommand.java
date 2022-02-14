package by.tms.project.controller.command.impl.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.VIEW_PROTOCOL_PAGE;
import static by.tms.project.controller.command.RequestAttribute.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class DoctorViewMyProtocolCommand
 */
public class DoctorViewMyProtocolCommand implements Command {
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SESSION_USER);
        Long doctorId = user.getId();
        try {
            List<Protocol> protocolList = protocolService.findByDoctor(doctorId);
            request.setAttribute(PROTOCOL_LIST, protocolList);
            request.setAttribute(PROTOCOL, Boolean.TRUE);
            router.setPage(VIEW_PROTOCOL_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at DoctorViewMyProtocolCommand");
            throw new CommandException("Failed at DoctorViewMyProtocolCommand", e);
        }
        return router;
    }
}
