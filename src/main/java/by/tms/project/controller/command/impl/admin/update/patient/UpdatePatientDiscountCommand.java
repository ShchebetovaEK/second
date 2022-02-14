package by.tms.project.controller.command.impl.admin.update.patient;

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

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_PATIENT;
import static by.tms.project.controller.command.RequestParameter.DISCOUNT;
import static by.tms.project.controller.command.RequestParameter.USERS_ID;

/**
 * @author ShchebetovaEK
 * <p>
 * class UpdatePatientDiscountCommand
 */
public class UpdatePatientDiscountCommand implements Command {
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
        String strDiscount = request.getParameter(DISCOUNT);
        Integer discount = null;
        String strId = request.getParameter(USERS_ID);
        if (strDiscount.isEmpty() && strId.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Long id = Long.valueOf(strId);
        discount = Integer.valueOf(strDiscount);
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute(SESSION_PATIENT);
        try {
            if (discount != null) {
                patientService.updateDiscount(id, discount);
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }

        } catch (ServiceException e) {
            logger.error("Failed at UpdatePatientDiscountCommand ", e);
            throw new CommandException("Failed at UpdatePatientDiscountCommand", e);
        }
        return router;
    }
}
