package by.tms.project.model.validator;

import by.tms.project.exception.ValidatorException;

public interface UserValidator {

    boolean isLoginValid(String login) throws ValidatorException;

    boolean isPasswordValid(String password) throws ValidatorException;

    boolean isFirstNameValid(String firstName) throws ValidatorException;

    boolean isLastNameValid(String lastName) throws ValidatorException;

    boolean isDataBirthdayValid(String dataBirthday) throws ValidatorException;

    boolean isAddressValid(String address) throws ValidatorException;

    boolean isEmailValid(String email) throws ValidatorException;

    boolean isPhoneNumberValid(String phoneNumber) throws ValidatorException;
}
