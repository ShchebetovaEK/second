package by.tms.project.controller.command.impl.admin.delete;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_PATIENT;
import static by.tms.project.controller.command.RequestParameter.USERS_ID;

/**
 * @author ShchebetovaEK
 *
 * class AdminArchivPatientCommand
 */
public class AdminArchivPatientCommand  implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strId = request.getParameter(USERS_ID);
        if (strId == null) {
            throw new CommandException("Failed at AdminArchivPatientCommand");
        }
        Long id = Long.valueOf(strId);
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute(SESSION_PATIENT);
        try {
            patientService.archivPatient(id);
            router.setPage(SUCCESS_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminArchivPatientCommand", e);
            throw new CommandException("Failed at AdminArchivPatientCommand", e);
        }
        return router;
    }
}