package by.tms.project.model.validator;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;

public interface DoctorValidator {

    boolean isCategoryValid(String category);

    boolean isExperienceValid(String experience);

    boolean isSpecialityValid(String speciality);
}
