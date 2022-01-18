package by.tms.project.controller.command;

import by.tms.project.controller.command.impl.common.*;
import by.tms.project.controller.command.impl.user.ChangeUserPersonalCommand;
import by.tms.project.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

import static by.tms.project.model.entity.Role.*;

public enum CommandType {
    GO_TO_WELCOME(new GoToWelcomeCommand(), List.of(ADMIN, PATIENT,DOCTOR)),
    GO_TO_MAIN(new GotoMainCommand()),
    REGISTRATION_PAGE(new GoToRegistrationCommand()),
    AUTHENTICATION_PAGE(new AuthenticationCommand()),
    LOG_IN_PAGE(new LogInCommand()),
    CHANGE_LOCALE(new ChangeLocaleCommand()),
    CHANGE_USER_PERSONAL_DATA(new ChangeUserPersonalCommand());

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
