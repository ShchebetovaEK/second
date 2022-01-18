package by.tms.project.controller.command;

import by.tms.project.controller.command.impl.common.*;
import by.tms.project.controller.command.impl.move.GoToRegistrationCommand;
import by.tms.project.controller.command.impl.move.GoToWelcomeCommand;
import by.tms.project.controller.command.impl.move.GotoMainCommand;
import by.tms.project.controller.command.impl.user.ChangeUserPersonalCommand;
import by.tms.project.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

import static by.tms.project.model.entity.Role.*;

public enum CommandType {
    GO_TO_WELCOME(new GoToWelcomeCommand(), List.of(ADMIN, PATIENT,DOCTOR)),
    GO_TO_MAIN(new GotoMainCommand(),List.of(ADMIN, PATIENT,DOCTOR)),
    REGISTRATION_PAGE(new GoToRegistrationCommand(),List.of(ADMIN, PATIENT,DOCTOR)),
    AUTHENTICATION_PAGE(new AuthenticationCommand(),List.of(ADMIN, PATIENT,DOCTOR)),
    LOG_IN_PAGE(new LogInCommand(),List.of(ADMIN, PATIENT,DOCTOR)),
    CHANGE_LOCALE(new ChangeLocaleCommand(),List.of(ADMIN, PATIENT,DOCTOR)),
    CHANGE_USER_PERSONAL_DATA(new ChangeUserPersonalCommand(),List.of(ADMIN, PATIENT,DOCTOR));

    private final Command command;
    private final List<Role> roleList;

    CommandType(Command command){
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
        return roleList;}
}
