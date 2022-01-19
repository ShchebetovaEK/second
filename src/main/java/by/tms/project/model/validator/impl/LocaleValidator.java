package by.tms.project.model.validator.impl;

public final class LocaleValidator {

    private static final String ENGLISH_LOCALE = "en_US";
    private static final String RUSSIAN_LOCALE = "ru_RU";

    private LocaleValidator() {
    }


    public static boolean isLocaleExist(String locale) {
        return locale != null && locale.matches(ENGLISH_LOCALE + "|" + RUSSIAN_LOCALE);
    }
}
