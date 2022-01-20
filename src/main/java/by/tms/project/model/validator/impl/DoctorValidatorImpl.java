package by.tms.project.model.validator.impl;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;
import by.tms.project.model.validator.DoctorValidator;

public class DoctorValidatorImpl implements DoctorValidator {

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

    @Override
    public boolean isCategoryValid(Category category) {
        return category != null &&
                (category.equals(Category.HIGH) || category.equals(Category.FIRST) || category.equals(Category.SECOND));

    }

    @Override
    public boolean isExperienceValid(Experience experience) {
        //todo
        return false;
    }

    @Override
    public boolean isSpecialityValid(Speciality speciality) {
        //todo
        return false;
    }
}
