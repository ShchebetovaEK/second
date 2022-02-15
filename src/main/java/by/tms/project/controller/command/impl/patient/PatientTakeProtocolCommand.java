package by.tms.project.controller.command.impl.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.PATIENT_REQ;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 * <p>
 * class PatientTakeProtocolCommand
 */
public class PatientTakeProtocolCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String INACTIV = "inactiv";
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
        String strArchiv = String.valueOf(user.getArchiv());
        String archiv = strArchiv.toLowerCase();
        if (archiv.equals(INACTIV)) {
            router.setPage(IMPOSSIBLE_PAGE);
        } else {
            Long patientId = user.getId();
            String strDoctorId = request.getParameter(USERS_ID);
            if (strDoctorId == null) {
                throw new CommandException("Failed at PatientTakeProtocolCommand");
            }
            Long doctorId = Long.valueOf(strDoctorId);
            Map<String, String> checkData = new HashMap<>();
            checkData.put(PROTOCOL_DATA, request.getParameter(PROTOCOL_DATA));
            checkData.put(PROTOCOL_PAYER, request.getParameter(PROTOCOL_PAYER));
            checkData.put(PROTOCOL_DOCTOR_USERS_ID, strDoctorId);
            checkData.put(PROTOCOL_PATIENTS_USERS_ID, String.valueOf(patientId));
            try {
                boolean registerProtocol = protocolService.patientApplicationProtocol(checkData);
                request.setAttribute(PATIENT_REQ, Boolean.TRUE);
                router.setRouterType(Router.RouteType.REDIRECT);
                router.setPage(registerProtocol ? SUCCESS_PAGE : CHOOSE_DOCTOR);
            } catch (ServiceException e) {
                logger.error("Failed at PatientTakeProtocolCommand ", e);
                throw new CommandException("Failed at PatientTakeProtocolCommand", e);
            }
        }
        return router;
    }
}
