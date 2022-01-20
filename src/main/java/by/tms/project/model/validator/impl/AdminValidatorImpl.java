package by.tms.project.model.validator.impl;

import by.tms.project.model.util.property.PropertyLoader;
import jakarta.servlet.http.HttpSession;

import java.util.Map;
import java.util.Properties;

import static by.tms.project.controller.command.MessageAttributeName.INCORRECT_CREATE_CONTRACT_LOGIN;
import static by.tms.project.controller.command.RequestParameter.EMPTY_STRING;
import static by.tms.project.controller.command.RequestParameter.LOGIN;

public class AdminValidatorImpl {

    private static final String PROPERTY_PATH = "message.properties";
    private static final Properties property = PropertyLoader.getProperty(PROPERTY_PATH);
    private static AdminValidatorImpl instance;

    private AdminValidatorImpl(){

    }

    public static AdminValidatorImpl getInstance(){
        if(instance == null){
            instance = new AdminValidatorImpl();
        }
        return instance;
    }

    public boolean isCreateProtocolFormValid(Map<String, String> formData, HttpSession session){
        UserValidatorImpl dataValidator = UserValidatorImpl.getInstance();
        int count = 0;
        resetIncorrectCreateProtocol(session);
        String login = formData.get(LOGIN);
        if(!dataValidator.isLoginValid(login)){
            formData.put(LOGIN,EMPTY_STRING);
            session.setAttribute(INCORRECT_CREATE_CONTRACT_LOGIN,property);
            ++count;
        }
      return  count == 0;
    }

    private void resetIncorrectCreateProtocol(HttpSession session) {

    }
}
