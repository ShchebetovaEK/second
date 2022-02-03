package by.tms.project.model.validator.impl;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.validator.DoctorValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static by.tms.project.controller.command.RequestParameter.*;

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

    public boolean checkUserDoctorData(Map<String, String> userData) {
        boolean isValid = true;
        if (!isCategoryValid(userData.get(CATEGORY))) {
            userData.put(CATEGORY, INVALID_CATEGORY);
            isValid = false;
        }
        if (!isExperienceValid(userData.get(EXPERIENCE))) {
            userData.put(EXPERIENCE, INVALID_EXPERIENCE);
            isValid = false;
        }
        if (!isSpecialityValid(userData.get(SPECIALITY))) {
            userData.put(SPECIALITY, INVALID_SPECIALITY);
            isValid = false;
        }
        return isValid;
    }
}
