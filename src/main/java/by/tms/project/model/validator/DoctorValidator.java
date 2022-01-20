package by.tms.project.model.validator;

import by.tms.project.model.entity.Category;
import by.tms.project.model.entity.Experience;
import by.tms.project.model.entity.Speciality;

public interface DoctorValidator {

    boolean isCategoryValid(Category category);

    boolean isExperienceValid(Experience experience);

    boolean isSpecialityValid(Speciality speciality);
}
