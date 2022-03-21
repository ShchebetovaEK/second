package by.tms.project.model.validator;

/**
 * @author SchebetovaEk
 *
 * class LocaleValidatorImpl
 */
public class LocaleValidator {
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String RUSSIAN_LOCALE = "ru_RU";
    private static LocaleValidator instance;

    private LocaleValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static LocaleValidator getInstance() {
        if (instance == null) {
            instance = new LocaleValidator();
        }

        return instance;
    }

    public  boolean isLocaleExist(String locale) {
        return locale != null && locale.matches(ENGLISH_LOCALE + "|" + RUSSIAN_LOCALE);
    }
}
