package by.tms.project.model.validator;

import by.tms.project.exception.ValidatorException;

public interface LocaleValidator {

    boolean isLocaleExist(String locale) throws ValidatorException;
}
