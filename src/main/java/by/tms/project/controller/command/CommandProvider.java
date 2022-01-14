package by.tms.project.controller.command;

import by.tms.project.controller.command.impl.admin.GoToWelcome;

import java.util.EnumMap;
import java.util.Locale;

public class CommandProvider {

    private static CommandProvider instance;
    private final EnumMap<CommandType, Command> commandEnumMap = new EnumMap<>(CommandType.class);

    private CommandProvider() {
        commandEnumMap.put(CommandType.GO_TO_WELCOME, new GoToWelcome());
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            instance = new CommandProvider();
        }
        return instance;
    }

    public Command takeCommand(String commandName) {
        if (commandName == null) {
            return commandEnumMap.get(CommandType.GO_TO_WELCOME);

        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase(Locale.ROOT));

        } catch (IllegalArgumentException e) {
            commandType = CommandType.GO_TO_WELCOME;

        }
        return commandEnumMap.get(commandType);
    }

}