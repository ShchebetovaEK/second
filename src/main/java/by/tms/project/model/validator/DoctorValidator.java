package by.tms.project.model.validator;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Speciality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static by.tms.project.controller.command.RequestParameter.*;

public class DoctorValidator {
    private static final Logger logger = LogManager.getLogger();
    private static DoctorValidator instance;


    private DoctorValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DoctorValidator getInstance() {
        if (instance == null) {
            instance = new DoctorValidator();
        }

        return instance;
    }

    /**
     * Is category valid
     * @param category
     * @return the boolean
     */
    public boolean isCategoryValid(String category) {
        boolean match = true;
        try {
            Category.valueOf(category);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    /**
     * is speciality valid
     * @param speciality
     * @return the boolean
     */

    public boolean isSpecialityValid(String speciality) {
        boolean match = true;
        try {
            Speciality.valueOf(speciality);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    /**
     * check Doctor Data
     * @param userData
     * @return the boolean
     */
    public boolean checkUserDoctorData(Map<String, String> userData) {
        boolean isValid = true;
        if (!isCategoryValid(userData.get(CATEGORY))) {
            userData.put(CATEGORY, INVALID_CATEGORY);
            isValid = false;
        }
        if (!isSpecialityValid(userData.get(SPECIALITY))) {
            userData.put(SPECIALITY, INVALID_SPECIALITY);
            isValid = false;
        }
        return isValid;
    }
}
