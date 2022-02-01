package by.tms.project.model.validator.impl;

import by.tms.project.model.validator.LocaleValidator;

/**
 * @author SchebetovaEk
 *
 * class LocaleValidatorImpl
 */
public class LocaleValidatorImpl  implements LocaleValidator {
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String RUSSIAN_LOCALE = "ru_RU";
    private static LocaleValidatorImpl instance;

    private LocaleValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static LocaleValidatorImpl getInstance() {
        if (instance == null) {
            instance = new LocaleValidatorImpl();
        }

        return instance;
    }

    public  boolean isLocaleExist(String locale) {
        return locale != null && locale.matches(ENGLISH_LOCALE + "|" + RUSSIAN_LOCALE);
    }
}
