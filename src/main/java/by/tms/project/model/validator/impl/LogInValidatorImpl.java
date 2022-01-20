package by.tms.project.model.validator.impl;

import by.tms.project.model.util.property.PropertyLoader;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.Properties;

import static by.tms.project.controller.command.MessageAttributeName.LOG_IN_ERROR;
import static by.tms.project.controller.command.MessageAttributeValue.MESSAGE_LOG_IN_ERROR;
import static by.tms.project.controller.command.RequestParameter.*;

public  final class LogInValidatorImpl {
    private static final UserValidatorImpl DATA_VALIDATOR = UserValidatorImpl.getInstance();
    private static final String PROPERTY_PATH = "message.properties";
    private static final Properties property = PropertyLoader.getProperty(PROPERTY_PATH);
    private static LogInValidatorImpl instance;

    private LogInValidatorImpl() {}

    public static LogInValidatorImpl getInstance() {
        if (instance == null) {
            instance = new LogInValidatorImpl();
        }
        return instance;
    }

    public boolean isFormValid(Map<String ,String> formData, HttpServletRequest request){
        int count = 0;
        String login = formData.get(LOGIN);
        String password = formData.get(PASSWORD);
        if (!DATA_VALIDATOR.isLoginValid(login) || !DATA_VALIDATOR.isPasswordValid(password)){
            formData.put(PASSWORD,EMPTY_STRING);
            request.setAttribute(LOG_IN_ERROR, property.getProperty(MESSAGE_LOG_IN_ERROR));
            ++count;
        }
        return count ==0 ;
    }
}
