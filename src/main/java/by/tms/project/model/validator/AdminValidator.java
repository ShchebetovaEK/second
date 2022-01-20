package by.tms.project.model.validator;

import jakarta.servlet.http.HttpSession;

import java.util.Map;

public interface AdminValidator {

     boolean isCreateProtocolFormValid(Map<String, String> formData, HttpSession session);

}
