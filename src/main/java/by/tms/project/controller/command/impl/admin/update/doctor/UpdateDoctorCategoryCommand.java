package by.tms.project.controller.command.impl.admin.update.doctor;

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
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_DOCTOR;
import static by.tms.project.controller.command.RequestParameter.CATEGORY;
import static by.tms.project.controller.command.RequestParameter.USERS_ID;

/**
 * @author ShchebetovaEK
 * <p>
 * class UpdateDoctorCategoryCommand
 */
public class UpdateDoctorCategoryCommand implements Command {
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
        String category = request.getParameter(CATEGORY).toUpperCase();
        String strId = request.getParameter(USERS_ID);
        if (category.isEmpty() && strId.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Long id = Long.valueOf(strId);
        HttpSession session = request.getSession();
        Doctor doctor = (Doctor) session.getAttribute(SESSION_DOCTOR);
        try {
            if (category != null && doctorValidator.isCategoryValid(category)) {
                doctorService.updateCategory(id, Category.valueOf(category));
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at UpdateDoctorCategoryCommand", e);
            throw new CommandException("Failed at UpdateDoctorCategoryCommand", e);
        }

        return router;
    }
}
