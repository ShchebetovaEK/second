package by.tms.project.controller.command;

import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class GoToWelcome implements Command{
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}
