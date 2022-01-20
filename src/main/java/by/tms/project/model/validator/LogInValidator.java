package by.tms.project.model.validator;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface LogInValidator {

    boolean isFormValid(Map<String ,String> formData, HttpServletRequest request);
}
