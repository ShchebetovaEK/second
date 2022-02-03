package by.tms.project.controller.command.impl.update.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.UserService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.*;

public class UpdatePatientInsuranceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();

    /**
     *
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        Boolean upInsurance = Boolean.valueOf(request.getParameter(INSURANCE));
        Long id = Long.valueOf(request.getParameter(USERS_ID));
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute(SESSION_USER);
        try {
            patientService.updateInsurance(id, upInsurance);
        } catch (ServiceException e) {
            logger.error("Failed at UpdatePatientInsuranceCommand", e);
            throw new CommandException("Failed at UpdatePatientInsuranceCommand", e);
        }

        return router;
    }
}
