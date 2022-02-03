package by.tms.project.controller.command.impl.select.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.USER_MANAGER_PAGE;
import static by.tms.project.controller.command.RequestAttribute.PATIENT;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 *
 * class AdminTakePatientByInsuranceCommand
 */
public class AdminTakePatientByInsuranceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return  the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String insurance = request.getParameter(RequestParameter.INSURANCE);

        try {
            List<Patient> userList = patientService.findByInsurance(Boolean.valueOf(insurance));
            request.setAttribute(USER_LIST, userList);
            request.setAttribute(PATIENT, Boolean.TRUE);
            router.setPage(USER_MANAGER_PAGE);
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakePatientByInsuranceCommand ", e);
            throw new CommandException("Failed at AdminTakePatientByInsuranceCommand", e);
        }
        return router;
    }
}
