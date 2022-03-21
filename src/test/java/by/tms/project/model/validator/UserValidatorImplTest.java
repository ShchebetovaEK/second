package by.tms.project.model.validator;

import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

class UserValidatorImplTest {

    @DataProvider(name = "loginData")
    public Object[][] createInvalidLogin() {
        String[][] data = {{"1root"}, {"ro<o>t"}, {"main root"}, {"A"}, {"mainRootMainRootRoot1"}};
        return data;
    }

    @DataProvider(name = "passwordData")
    public Object[][] createInvalidPassword() {
        String[][] data = {{"<script>alert(\"123\")</script>"}, {"33333333"}, {"9999999"}, {"333333DD"}, {"popovDGG"}
                , {"-33333Dd"}, {"33333<>Dg"}};
        return data;
    }

    @DataProvider(name = "nameData")
    public Object[][] createInvalidName() {
        String[][] data = {{""}, {" "}, {"I"}, {"DeN$s"}, {"Den<i>s"}, {"Den1s"}, {"LenaLenaLenaLenaLenaLenaLenaLenaLena"}};
        return data;
    }

    @DataProvider(name = "emailData")
    public Object[][] createInvalidEmail() {
        String[][] data = {{"Lena-mail.ru"}, {"@mail.ru"}, {"Le<n>a@mail.ru"}, {"LenaLenaLenaLenaLenaLenaLenaLenaLenaLenaLenaLenaLena@mail.ru"}};
        return data;
    }

    @DataProvider(name = "mobileNumberData")
    public Object[][] createInvalidMobileNumber() {
        String[][] data = {{"80447181933"}, {"80257181933"}, {"80297181933"}, {"+375337181933"}};
        return data;
    }


    @Test
    void isLoginValid() {
    }

    @Test
    void isPasswordValid() {
    }

    @Test
    void isFirstNameValid() {
    }

    @Test
    void isLastNameValid() {
    }

    @Test
    void isDataBirthdayValid() {
    }

    @Test
    void isAddressValid() {
    }

    @Test
    void isEmailValid() {
    }

    @Test
    void isPhoneNumberValid() {
    }
}