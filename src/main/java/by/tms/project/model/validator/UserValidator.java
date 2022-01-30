package by.tms.project.model.validator;

import java.util.Map;

public interface UserValidator {

    boolean isLoginValid(String login);

    boolean isPasswordValid(String password);

    boolean isFirstNameValid(String firstName);

    boolean isLastNameValid(String lastName);

    boolean isDataBirthdayValid(String dataBirthday);

    boolean isAddressValid(String address);

    boolean isEmailValid(String email);

    boolean isPhoneNumberValid(String phoneNumber);

    Map<String, String> checkUserData(Map<String, String> userData);
}
