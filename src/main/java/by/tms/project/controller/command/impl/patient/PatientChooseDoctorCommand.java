package by.tms.project.controller.command.impl.patient;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.RequestParameter;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.Doctor;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.service.DoctorService;
import by.tms.project.model.service.PatientService;
import by.tms.project.model.service.ProtocolService;
import by.tms.project.model.service.impl.DoctorServiceImpl;
import by.tms.project.model.service.impl.PatientServiceImpl;
import by.tms.project.model.service.impl.ProtocolServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.tms.project.controller.command.PagePath.CHOOSE_DOCTOR;
import static by.tms.project.controller.command.RequestAttribute.USER_LIST;
import static by.tms.project.controller.command.SessionAttribute.DOCTOR;

/**
 * @author ShchebetovaEK
 * <p>
 * class PatientChooseDoctorCommand
 */
public class PatientChooseDoctorCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private ProtocolService protocolService = ProtocolServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        String strSpeciality = request.getParameter(RequestParameter.SPECIALITY);
        if (strSpeciality == null) {
            throw new CommandException("Failed at PatientChooseDoctorCommand ");
        }
        try {
            String speciality = strSpeciality.toUpperCase();
            List<Doctor> chooseDoctor = doctorService.findDoctorBySpeciality(Speciality.valueOf(speciality));
            request.setAttribute(USER_LIST, chooseDoctor);
            request.setAttribute(DOCTOR, Boolean.TRUE);
            router.setPage(CHOOSE_DOCTOR);
        } catch (ServiceException e) {
            logger.error("Failed at PatientChooseDoctorCommand", e);
            throw new CommandException("Failed at PatientChooseDoctorCommand", e);
        }
        return router;
    }
}
