package by.tms.project.model.validator.impl;

import by.tms.project.exception.ServiceException;
import by.tms.project.model.entity.User;
import by.tms.project.model.util.property.PropertyLoader;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Properties;

import static by.tms.project.controller.command.MessageAttributeName.*;
import static by.tms.project.controller.command.MessageAttributeValue.*;
import static by.tms.project.controller.command.RequestParameter.*;

public class SignUpValidatorImpl {
    private static final UserValidatorImpl DATA_VALIDATOR = UserValidatorImpl.getInstance();
    private static final String PROPERTY_PATH = "message.properties";
    private static final Properties property = PropertyLoader.getProperty(PROPERTY_PATH);
    private static SignUpValidatorImpl instance;

    private SignUpValidatorImpl() {
    }

    public static SignUpValidatorImpl getInstance() {
        if (instance == null) {
            instance = new SignUpValidatorImpl();
        }

        return instance;
    }

    public boolean isFormSighUpFormValid(User userForm, HttpServletRequest request) throws ServiceException{
        HttpSession session = request.getSession();
        int count = 0;
        String login = userForm.getLogin();
        if(!DATA_VALIDATOR.isLoginValid(login)){
            userForm.setLogin(EMPTY_STRING);
            session.setAttribute(PASSWORD,EMPTY_STRING);
            session.setAttribute(CONFIRMED_PASSWORD,EMPTY_STRING);
            session.setAttribute(INCORRECT_LOGIN,property.getProperty(MESSAGE_INCORRECT_LOGIN));
            ++count;
        }
        if (!DATA_VALIDATOR.isPasswordValid(request.getParameter(PASSWORD))){
            session.setAttribute(PASSWORD,EMPTY_STRING);
            session.setAttribute(CONFIRMED_PASSWORD,EMPTY_STRING);
            session.setAttribute(INCORRECT_PASSWORD,property.getProperty(MESSAGE_INCORRECT_PASSWORD));
            ++count;
        }
       else if (!request.getParameter(CONFIRMED_PASSWORD).equals(request.getParameter(PASSWORD))){
           session.setAttribute(PASSWORD,EMPTY_STRING);
           session.setAttribute(CONFIRMED_PASSWORD,EMPTY_STRING);
           session.setAttribute(NOT_SAME_PASSWORD,property.getProperty(MESSAGE_NOT_SAME_PASSWORD));
            ++count;
       }
       String email = userForm.getEmail();
       if (!DATA_VALIDATOR.isEmailValid(email)){
           userForm.setEmail(EMPTY_STRING);
           session.setAttribute(PASSWORD,EMPTY_STRING);
           session.setAttribute(CONFIRMED_PASSWORD,EMPTY_STRING);
           session.setAttribute(INCORRECT_EMAIL,property.getProperty(MESSAGE_INCORRECT_EMAIL));
           ++count;
       }

       String phoneNumber = userForm.getPhoneNumber();
       if(!DATA_VALIDATOR.isPhoneNumberValid(phoneNumber)){
           userForm.setPhoneNumber(phoneNumber);
           session.setAttribute(PASSWORD,EMPTY_STRING);
           session.setAttribute(CONFIRMED_PASSWORD,EMPTY_STRING);
           session.setAttribute(INCORRECT_PHONE_NUMBER,property.getProperty(MESSAGE_INCORRECT_PHONE_NUMBER));
           ++count;
       }
       if(count ==0){

       }

        return count == 0;
    }
}
