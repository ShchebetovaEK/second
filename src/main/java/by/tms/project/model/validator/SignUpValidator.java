package by.tms.project.model.validator;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface SignUpValidator {
    boolean isFormSighUpFormValid(User userForm, HttpServletRequest request) throws ServiceException;//todo


}
