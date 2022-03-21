package by.tms.project.controller.command.impl.admin.update.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Patient;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.validator.PatientValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.FAIL_PAGE;
import static by.tms.project.controller.command.PagePath.SUCCESS_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_PATIENT;
import static by.tms.project.controller.command.RequestParameter.*;

public class UpdatePatientBalanceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private PatientValidator patientValidator = PatientValidator.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strMoney = request.getParameter(BALANCE);
        String strId = request.getParameter(USERS_ID);
        if (strMoney.isEmpty() && strId.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        Long id = Long.valueOf(strId);
        BigDecimal  moneyAccount = BigDecimal.valueOf(Integer.valueOf(strMoney));
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute(SESSION_PATIENT);
        try {
            if (moneyAccount != null ) {
             Optional<Patient> patientOptional = patientService.findBalance(id);
             BigDecimal patientBalance = patientOptional.get().getMoneyAccount();
             BigDecimal moneyAccount1;
             moneyAccount1 = patientBalance.add(moneyAccount);
                patientService.updateMoneyAccount(id, moneyAccount1);
                router.setPage(SUCCESS_PAGE);
            } else {
                router.setPage(FAIL_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at  UpdatePatientMoneyAccountCommand", e);
            throw new CommandException("Failed at UpdatePatientMoneyAccountCommand", e);
        }
        return router;
    }
}
