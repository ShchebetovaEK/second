package by.tms.project.controller.command.impl.admin.mail;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestParameter.*;

public class MinBalanceMailCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String SUBJECT = "REPLENISH";
    private UserService userService = UserServiceImpl.getInstance();
    private PatientService patientService = PatientServiceImpl.getInstance();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strMinBalance = request.getParameter(MONEY_ACCOUNT);
        if (strMinBalance.isEmpty()){
            router.setPage(FAIL_PAGE);
        }

        try {
            Integer minBalance = Integer.valueOf(strMinBalance);

            List<Patient> patientList = patientService.findMinBalance(minBalance);
            if (!patientList.isEmpty()) {
                for (int i = 0; i < patientList.size(); i++) {
                    User user = patientList.get(i);
                    String login = user.getLogin();
                    userService.sendMessage(SUBJECT, login);
                }
                router.setPage(SUCCESS_PAGE);

            } else {
                router.setPage(NO_MATCH_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at MinBalanceMailCommand", e);
            throw new CommandException(e);
        }
        return router;
    }
}
