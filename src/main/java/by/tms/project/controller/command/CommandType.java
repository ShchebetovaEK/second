package by.tms.project.controller.command;

import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeAllDoctorsCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorByCategoryCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorByExperienceCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorBySpecialityCommand;
import by.tms.project.controller.command.impl.admin.select.patient.AdminTakeAllPatientsCommand;
import by.tms.project.controller.command.impl.admin.select.protocol.AdminTakeAllProtocolsCommand;
import by.tms.project.controller.command.impl.admin.select.protocol.AdminTakeProtocolByDataCommand;
import by.tms.project.controller.command.impl.admin.select.protocol.AdminTakeProtocolByPayerCommand;
import by.tms.project.controller.command.impl.admin.select.user.*;
import by.tms.project.controller.command.impl.common.*;
import by.tms.project.controller.command.impl.move.*;
import by.tms.project.controller.command.impl.user.ChangeUserPersonalCommand;
import by.tms.project.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

import static by.tms.project.model.entity.Role.*;

public enum CommandType {
    /* move */
    GO_TO_ABOUT_PAGE_COMMAND(new GoToAboutCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_DOCTORS_COMMAND(new GoToDoctorsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_MAIN(new GotoMainCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_PEDIATRIC_COMMAND(new GoToPediatricCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_PRICE_COMMAND(new GoToPriceCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    REGISTRATION_PAGE(new GoToRegistrationCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_WELCOME(new GoToWelcomeCommand(), List.of(ADMIN, PATIENT, DOCTOR)),

    /* admin */
    ADMIN_PAGE_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_ALL_DOCTORS_COMMAND(new AdminTakeAllDoctorsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_CATEGORY_COMMAND(new AdminTakeDoctorByCategoryCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_EXPERIENCE_COMMAND(new AdminTakeDoctorByExperienceCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_SPECIALITY_COMMAND(new AdminTakeDoctorBySpecialityCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_ALL_PATIENTS_COMMAND(new AdminTakeAllPatientsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_ALL_USERS_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_ALL_PROTOCOLS_COMMAND(new AdminTakeAllProtocolsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_DATA_COMMAND(new AdminTakeProtocolByDataCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_PAYER_COMMAND(new AdminTakeProtocolByPayerCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_USER_BY_BIRTHDAY_COMMAND(new AdminTakeUserByBirthdayCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_USER_BY_EMAIL_COMMAND(new AdminTakeUserByEmailCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_USER_BY_FIRST_NAME_COMMAND(new AdminTakeUserByFirstNameCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_USER_BY_LAST_NAME_COMMAND(new AdminTakeUserByLastNameCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_USER_BY_ID_COMMAND(new AdminTakeUserByIdCommand(), List.of(ADMIN, DOCTOR, PATIENT)),
    ADMIN_TAKE_USER_BY_LOGIN_COMMAND(new AdminTakeUserByLoginCommand(), List.of(ADMIN, DOCTOR, PATIENT)),

    MANAGER_PAGE_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    /* common */
    AUTHENTICATION_COMMAND(new AuthenticationCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    LOG_IN_COMMAND(new LogInCommand(),List.of(ADMIN, PATIENT, DOCTOR)),
    LOG_OUT_PAGE(new LogOutCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    CHANGE_LOCALE(new ChangeLocaleCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    NOT_EXIST_COMMAND(new NotExistCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    CHANGE_USER_PERSONAL_DATA(new ChangeUserPersonalCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    REGISTRATION_COMMAND(new RegistrationCommand(), List.of(PATIENT, ADMIN, DOCTOR));


    private final Command command;
    private final List<Role> roleList;

    CommandType(Command command) {
        this.command = command;
        this.roleList = new ArrayList<>();
    }

    CommandType(Command command, List<Role> roleList) {
        this.command = command;
        this.roleList = roleList;
    }

    public Command getCommand() {
        return command;
    }

    public List<Role> getRoleList() {
        return roleList;
    }
}
