package by.tms.project.controller.command.impl;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.model.dao.ColumnName;
import by.tms.project.model.entity.Protocol;
import by.tms.project.model.entity.User;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LogInCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        PatientServiceImpl patientService = PatientServiceImpl.getInstance();
        DoctorServiceImpl doctorService = DoctorServiceImpl.getInstance();
        User user;
        Router router = new Router();
        List<Protocol> protocolList = new ArrayList<>();
        BigDecimal total = new BigDecimal(0);
        String login = request.getParameter(ColumnName.USERS_LOGIN);
        String password = request.getParameter(ColumnName.USERS_PASSWORD);

        return router;
    }
}
