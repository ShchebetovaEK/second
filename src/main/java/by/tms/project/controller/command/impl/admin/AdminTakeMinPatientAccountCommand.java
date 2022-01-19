package by.tms.project.controller.command.impl.admin;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.impl.PatientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminTakeMinPatientAccountCommand implements Command {
    public static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        return router;
    }

}

