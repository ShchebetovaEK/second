package by.tms.project.model.validator.impl;

import by.tms.project.model.validator.PatientValidator;

public class PatientValidatorImpl implements PatientValidator {

    private static PatientValidatorImpl instance;

    private PatientValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PatientValidatorImpl getInstance() {
        if (instance == null) {
            instance = new PatientValidatorImpl();
        }

        return instance;
    }
}
