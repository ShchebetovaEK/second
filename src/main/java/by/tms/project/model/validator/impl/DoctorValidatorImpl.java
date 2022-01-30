package by.tms.project.model.validator.impl;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.validator.DoctorValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoctorValidatorImpl implements DoctorValidator {
    private static final Logger logger = LogManager.getLogger();
    private static DoctorValidatorImpl instance;


    private DoctorValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DoctorValidatorImpl getInstance() {
        if (instance == null) {
            instance = new DoctorValidatorImpl();
        }

        return instance;
    }


    public boolean isCategoryValid(String category) {
        boolean match = true;
        try {
            Category.valueOf(category);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    //todo
    @Override
    public boolean isExperienceValid(String experience) {
        boolean match = true;
        try {
            Experience.valueOf(experience);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    //todo
    @Override
    public boolean isSpecialityValid(String speciality) {
        boolean match = true;
        try {
            Speciality.valueOf(speciality);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }
}
