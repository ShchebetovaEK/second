package by.tms.project.controller.command.impl;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.RequestParameter.LAST_NAME;

public class UpLastNameCommand implements Command {

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        Map<String, String> checkData = new HashMap<>();
        checkData.put(LAST_NAME, request.getParameter(LAST_NAME));
        return router;
    }
}
