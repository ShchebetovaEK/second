package by.tms.project.controller.command;

import by.tms.project.controller.command.impl.admin.AdminTakeProtocolCostCommand;
import by.tms.project.controller.command.impl.admin.delete.AdminArchivPatientCommand;
import by.tms.project.controller.command.impl.admin.delete.AdminArchivUserCommand;
import by.tms.project.controller.command.impl.admin.select.protocol.*;
import by.tms.project.controller.command.impl.admin.select.user.*;
import by.tms.project.controller.command.impl.admin.update.protocol.AdminUpdateProtocolApplicationCommand;
import by.tms.project.controller.command.impl.admin.update.protocol.AdminUpdateProtocolCommand;
import by.tms.project.controller.command.impl.admin.update.protocol.AdminUpdateProtocolStatusCommand;
import by.tms.project.controller.command.impl.admin.update.user.*;
import by.tms.project.controller.command.impl.patient.PatientChooseDoctorCommand;
import by.tms.project.controller.command.impl.admin.create.AdminRegisterProtocolCommand;
import by.tms.project.controller.command.impl.admin.delete.AdminDeletePatientCommand;
import by.tms.project.controller.command.impl.admin.create.AdminRegisterAdminCommand;
import by.tms.project.controller.command.impl.admin.create.AdminRegisterDoctorCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeAllDoctorsCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorByCategoryCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorByExperienceCommand;
import by.tms.project.controller.command.impl.admin.select.doctor.AdminTakeDoctorBySpecialityCommand;
import by.tms.project.controller.command.impl.admin.select.patient.AdminTakeAllPatientsCommand;
import by.tms.project.controller.command.impl.admin.select.patient.AdminTakePatientByDiscountCommand;
import by.tms.project.controller.command.impl.admin.select.patient.AdminTakePatientByInsuranceCommand;
import by.tms.project.controller.command.impl.admin.select.patient.AdminTakePatientByLoginCommand;
import by.tms.project.controller.command.impl.common.*;
import by.tms.project.controller.command.impl.move.*;
import by.tms.project.controller.command.impl.admin.update.doctor.UpdateDoctorExperienceCommand;
import by.tms.project.controller.command.impl.admin.update.doctor.UpdateDoctorSpecialityCommand;
import by.tms.project.controller.command.impl.admin.update.patient.UpdatePatientDiscountCommand;
import by.tms.project.controller.command.impl.admin.update.patient.UpdatePatientInsuranceCommand;
import by.tms.project.controller.command.impl.admin.update.patient.UpdatePatientMoneyAccountCommand;
import by.tms.project.controller.command.impl.admin.update.doctor.UpdateDoctorCategoryCommand;
import by.tms.project.controller.command.impl.patient.PatientTakeAllDoctorsCommand;
import by.tms.project.controller.command.impl.patient.PatientTakeProtocolCommand;
import by.tms.project.controller.command.impl.user.ChangeUserPersonalCommand;
import by.tms.project.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

import static by.tms.project.model.entity.Role.*;

/**
 * @author ShchbetovaEK
 *
 * enum CommandType
 */
public enum CommandType {
    /* move */
    GO_TO_ABOUT_PAGE_COMMAND(new GoToAboutCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_DOCTORS_COMMAND(new GoToDoctorsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_MAIN(new GotoMainCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_PEDIATRIC_COMMAND(new GoToPediatricCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_PRICE_COMMAND(new GoToPriceCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_REGISTRATION_PAGE(new GoToRegistrationCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_WELCOME(new GoToWelcomeCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    GO_TO_ADMIN_PAGE(new GoToAdminPageCommand(), List.of(ADMIN)),
    GO_TO_DOCTOR_PAGE(new GoToDoctorPageCommand(), List.of(DOCTOR)),
    GO_TO_CHOOSE(new GoToChooseCommand(), List.of(PATIENT)),

    /* admin */
    ADMIN_PAGE_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN)),
    ADMIN_TAKE_ALL_DOCTORS_COMMAND(new AdminTakeAllDoctorsCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_CATEGORY_COMMAND(new AdminTakeDoctorByCategoryCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_EXPERIENCE_COMMAND(new AdminTakeDoctorByExperienceCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_DOCTORS_BY_SPECIALITY_COMMAND(new AdminTakeDoctorBySpecialityCommand(), List.of(ADMIN, PATIENT, DOCTOR)),

    ADMIN_REGISTER_DOCTORS_COMMAND(new AdminRegisterDoctorCommand(), List.of(ADMIN)),
    ADMIN_REGISTER_ADMIN_COMMAND(new AdminRegisterAdminCommand(), List.of(ADMIN)),
    ADMIN_REGISTER_PROTOCOL_COMMAND(new AdminRegisterProtocolCommand(), List.of(ADMIN)),

    ADMIN_TAKE_ALL_PATIENTS_COMMAND(new AdminTakeAllPatientsCommand(), List.of(ADMIN, DOCTOR)),
    ADMIN_TAKE_ALL_PATIENTS_BY_INSURANCE_COMMAND(new AdminTakePatientByInsuranceCommand(), List.of(ADMIN,DOCTOR)),
    ADMIN_TAKE_ALL_PATIENTS_BY_DISCOUNT_COMMAND(new AdminTakePatientByDiscountCommand(), List.of(ADMIN,DOCTOR)),
    ADMIN_TAKE_ALL_PATIENTS_BY_LOGIN_COMMAND(new AdminTakePatientByLoginCommand(), List.of(ADMIN,DOCTOR)),

    ADMIN_TAKE_ALL_USERS_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN)),

    ADMIN_TAKE_ALL_PROTOCOLS_COMMAND(new AdminTakeAllProtocolsCommand(), List.of(ADMIN, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_DATA_COMMAND(new AdminTakeProtocolByDataCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_PAYER_COMMAND(new AdminTakeProtocolByPayerCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_DOCTOR_COMMAND(new AdminTakeProtocolByDoctorCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_BY_PATIENT_COMMAND(new AdminTakeProtocolByPatientCommand(), List.of(ADMIN, DOCTOR)),

    ADMIN_TAKE_USER_BY_EMAIL_COMMAND(new AdminTakeUserByEmailCommand(), List.of(ADMIN)),
    ADMIN_TAKE_USER_BY_FIRST_NAME_COMMAND(new AdminTakeUserByFirstNameCommand(), List.of(ADMIN)),
    ADMIN_TAKE_USER_BY_LAST_NAME_COMMAND(new AdminTakeUserByLastNameCommand(), List.of(ADMIN, DOCTOR )),
    ADMIN_TAKE_USER_BY_ID_COMMAND(new AdminTakeUserByIdCommand(), List.of(ADMIN, DOCTOR)),
    ADMIN_TAKE_USER_BY_LOGIN_COMMAND(new AdminTakeUserByLoginCommand(), List.of(ADMIN, DOCTOR)),
    ADMIN_TAKE_PROTOCOL_COST_COMMAND(new AdminTakeProtocolCostCommand(), List.of(ADMIN)),
    MANAGER_PAGE_COMMAND(new AdminTakeAllUsersCommand(), List.of(ADMIN)),

    /*update*/
    UPDATE_USER_ADDRESS_COMMAND(new UpdateUserAddressCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    UPDATE_USER_EMAIL_COMMAND(new UpdateUserEmailCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    UPDATE_USER_FIRST_NAME_COMMAND(new UpdateUserFirstNameCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    UPDATE_USER_LAST_NAME_COMMAND(new UpdateUserLastNameCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    UPDATE_USER_PHONE_NUMBER_COMMAND(new UpdateUserPhoneNumberCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    UPDATE_DOCTOR_CATEGORY_COMMAND(new UpdateDoctorCategoryCommand(), List.of(ADMIN)),
    UPDATE_DOCTOR_EXPERIENCE_COMMAND(new UpdateDoctorExperienceCommand(), List.of(ADMIN)),
    UPDATE_DOCTOR_SPECIALITY_COMMAND(new UpdateDoctorSpecialityCommand(), List.of(ADMIN)),
    UPDATE_PATIENT_INSURANCE_COMMAND(new UpdatePatientInsuranceCommand(), List.of(ADMIN)),
    UPDATE_PATIENT_DISCOUNT_COMMAND(new UpdatePatientDiscountCommand(), List.of(ADMIN)),
    UPDATE_PATIENT_MONEY_ACCOUNT_COMMAND(new UpdatePatientMoneyAccountCommand(), List.of(ADMIN)),
    ADMIN_UPDATE_PROTOCOL_COMMAND(new AdminUpdateProtocolCommand(), List.of(ADMIN)),
    ADMIN_UPDATE_PROTOCOL_APPLICATION_COMMAND(new AdminUpdateProtocolApplicationCommand(), List.of(ADMIN)),
    ADMIN_UPDATE_PROTOCOL_STATUS_COMMAND(new AdminUpdateProtocolStatusCommand(),List.of(ADMIN)),
    /*delete*/
    ADMIN_DELETE_PATIENT_COMMAND(new AdminDeletePatientCommand(), List.of(ADMIN)),
    ADMIN_ARCHIV_PATIENT_COMMAND(new AdminArchivPatientCommand(), List.of(ADMIN)),
    ADMIN_ARCHIV_USER_COMMAND(new AdminArchivUserCommand(), List.of(ADMIN)),
    ADMIN_DELETE_DOCTOR_COMMAND(new AdminDeletePatientCommand(), List.of(ADMIN)),
    ADMIN_DELETE_ADMIN_COMMAND(new AdminDeletePatientCommand(), List.of(ADMIN)),

    /*only patient command*/
    PATIENT_CHOOSE_DOCTOR_COMMAND(new PatientChooseDoctorCommand(), List.of(PATIENT)),
    PATIENT_TAKE_PROTOCOL_COMMAND(new PatientTakeProtocolCommand(), List.of(PATIENT)),
    PATIENT_TAKE_ALL_DOCTOR_COMMAND(new PatientTakeAllDoctorsCommand(), List.of(PATIENT)),
    /* common */
    AUTHENTICATION_COMMAND(new AuthenticationCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    LOG_IN_COMMAND(new LogInCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    LOG_OUT_COMMAND(new LogOutCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    CHANGE_LOCALE(new ChangeLocaleCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    NOT_EXIST_COMMAND(new NotExistCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    CHANGE_USER_PERSONAL_DATA(new ChangeUserPersonalCommand(), List.of(ADMIN, PATIENT, DOCTOR)),
    REGISTRATION_COMMAND(new RegistrationCommand(), List.of(PATIENT));


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
