package by.tms.project.controller.filter;

import by.tms.project.controller.command.CommandType;
import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static by.tms.project.controller.command.RequestParameter.COMMAND;

//@WebFilter(urlPatterns = {"/*"})
public class AccessFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String commandStr = request.getParameter(COMMAND);
        logger.debug("Access check. Command is " + commandStr);
        try {
            CommandType commandType = CommandType.valueOf(commandStr.toUpperCase());
            List<Role> allowedRoles = commandType.getRoleList();
//            EnumSet<Role> allowedRoles = commandType.getAllowedRoles();
            Optional<Object> optionalUser = Optional.ofNullable(session.getAttribute(SESSION_USER));
            if (optionalUser.isPresent()) {
                User user = (User) optionalUser.get();
                logger.debug( "User role is " + user.getRole());
                if (allowedRoles.contains(user.getRole())) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(403);
                }
            } else {
                if(allowedRoles.contains(Role.GUEST)){
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(403);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug( "Command is absent");
            filterChain.doFilter(request, response);
        }
    }
}
