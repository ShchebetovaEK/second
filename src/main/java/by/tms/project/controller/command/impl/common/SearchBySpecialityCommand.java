package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;

public class SearchBySpecialityCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
       String strSpeciality = request.getParameter(RequestParameter.SPECIALITY);
        if (strSpeciality.isEmpty()) {
            router.setPage(FAIL_PAGE);
            return router;
        }
        try {
            String speciality = strSpeciality.toUpperCase();
            List<Doctor> doctorList = doctorService.findDoctorBySpeciality(Speciality.valueOf(speciality));
            request.setAttribute(USER_LIST,doctorList);

            if (doctorList.isEmpty()) {
                router.setPage(NO_MATCH_PAGE);
            } else {
                router.setPage(SEARCH_PAGE);
            }
        } catch (ServiceException e) {
            logger.error("Failed at SearchBySpecialityCommand", e);
            throw new CommandException("Failed at SearchBySpecialityCommand", e);
        }

        return router;
    }
}
