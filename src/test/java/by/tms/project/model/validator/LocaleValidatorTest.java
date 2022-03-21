package by.tms.project.model.validator;

import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.*;

 class LocaleValidatorTest {
    @DataProvider(name = "validLocale")
    public Object[][] createCities() {
        String[][] cities = {{"ru_RU"}, {"en_US"}};
        return cities;
    }

    @Test
    public void testIsLocaleExistWithTrueCondition(String locale) {
        boolean condition = LocaleValidator.getInstance().isLocaleExist(locale);
        assertTrue(condition, "Locale " + locale + " doesn't exist in this application");
    }

    @Test
    public void testIsLocaleExistWithFalseCondition() {
        String data = "de_DE";
        boolean condition = LocaleValidator.getInstance().isLocaleExist(data);
        assertFalse(condition);
    }

    @Test
    public void testIsLocaleExistWithNullCondition() {
        String data = null;
        boolean condition = LocaleValidator.getInstance().isLocaleExist(data);
        assertFalse(condition);
    }
}