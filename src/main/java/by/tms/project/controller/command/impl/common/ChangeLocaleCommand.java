package by.tms.project.controller.command.impl.common;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import by.tms.project.model.validator.LocaleValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tms.project.controller.command.RequestAttribute.CURRENT_PAGE;
import static by.tms.project.controller.command.RequestAttribute.SESSION_LOCALE;

/**
 * @author ShchebetovaEK
 * <p>
 * class ChangeLocaleCommand
 */
public class ChangeLocaleCommand implements Command {
    public static final Logger logger = LogManager.getLogger();

    /**
     * @param request the request
     * @return the router.
     * @throws CommandException
     */
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(CURRENT_PAGE);
        String newLocale = request.getParameter(SESSION_LOCALE);
        if (LocaleValidator.getInstance().isLocaleExist(newLocale)) {
            session.setAttribute(SESSION_LOCALE, newLocale);

        } else {
            logger.error("wrong locale" + newLocale);
        }
        router.setPage(currentPage);
        return router;
    }
}
