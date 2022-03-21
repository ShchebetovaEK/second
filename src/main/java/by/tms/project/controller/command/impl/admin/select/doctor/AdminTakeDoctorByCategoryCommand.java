package by.tms.project.controller.command.impl.admin.select.doctor;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.validator.DoctorValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.DOCTOR_REQ;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;
import static by.tms.project.controller.command.RequestParameter.CATEGORY;

/**
 * @author ShchebetovaEK
 * <p>
 * class AdminTakeDoctorByCategoryCommand
 */
public class AdminTakeDoctorByCategoryCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();
    private DoctorValidator doctorValidator = DoctorValidator.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strCategory = request.getParameter(CATEGORY);
        if (strCategory.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {
            String category = strCategory.toUpperCase();
            if (doctorValidator.isCategoryValid(category)) {
                List<Doctor> userList = doctorService.findDoctorByCategory(Category.valueOf(category));
                request.setAttribute(USER_LIST, userList);
                request.setAttribute(DOCTOR_REQ, Boolean.TRUE);
                router.setPage(SELECT_DOCTOR_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at AdminTakeDoctorByCategoryCommand ", e);
            throw new CommandException("Failed at AdminTakeDoctorByCategoryCommand", e);
        }
        return router;

    }
}
