package by.tms.project.controller.command.impl.admin.select.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.validator.DoctorValidator;
import by.tms.project.model.validator.impl.DoctorValidatorImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SELECT_DOCTOR_PAGE;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR_REQ;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeDoctorBySpecialityCommand
 */
public class AdminTakeDoctorBySpecialityCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();
    private DoctorValidator doctorValidator = DoctorValidatorImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strSpeciality = request.getParameter(RequestParameter.SPECIALITY);
        if (strSpeciality.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {
            String speciality =strSpeciality.toUpperCase();
            if (doctorValidator.isSpecialityValid(speciality)) {
                List<Doctor> userList = doctorService.findDoctorBySpeciality(Speciality.valueOf(speciality));
                request.setAttribute(USER_LIST, userList);
                request.setAttribute(DOCTOR_REQ, Boolean.TRUE);
                router.setPage(SELECT_DOCTOR_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeDoctorBySpecialityCommand ", e);
            throw new CommandException("Failed at AdminTakeDoctorBySpecialityCommand", e);
        }
        return router;
    }
}
