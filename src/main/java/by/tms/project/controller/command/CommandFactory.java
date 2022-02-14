package by.tms.project.controller.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ShchebetovaEK
 * <p>
 * class CommandFactory
 */
public class CommandFactory {
    private static final Logger logger = LogManager.getLogger();

    public static Command getCommand(String commandStr) {
        Command command = CommandType.NOT_EXIST_COMMAND.getCommand();
        try {
            if (commandStr != null) {
                CommandType commandType = CommandType.valueOf(commandStr.toUpperCase());
                command = commandType.getCommand();
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, "Not exist command:", e);
        }
        return command;
    }
}