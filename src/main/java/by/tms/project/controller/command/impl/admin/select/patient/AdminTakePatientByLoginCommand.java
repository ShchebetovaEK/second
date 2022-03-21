package by.tms.project.controller.command.impl.admin.select.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.validator.UserValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SELECT_PATIENT_PAGE;
import static by.tms.project.controller.command.RequestAttribute.PATIENT_REQ;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class  AdminTakePatientByLoginCommand
 */
public class AdminTakePatientByLoginCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String login = request.getParameter(RequestParameter.LOGIN);
        if (login.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Patient patient;
        try {
            if (userValidator.isLoginValid(login)) {
                Optional<Patient> optionalUser = patientService.findPatientByLogin(login);
                if (optionalUser.isPresent()) {
                    patient = optionalUser.get();
                    List<Patient> userList = new ArrayList<>();
                    userList.add(patient);
                    request.setAttribute(USER_LIST, userList);
                    request.setAttribute(PATIENT_REQ, Boolean.TRUE);
                    router.setPage(SELECT_PATIENT_PAGE);
                }
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakePatientByLoginCommand ", e);
            throw new CommandException("Failed at AdminTakePatientByLoginCommand", e);
        }
        return router;
    }
}