package by.tms.project.controller;

import by.tms.project.controller.command.CommandType;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

import static by.tms.project.controller.command.PagePath.ERROR_404_PAGE;
import static by.tms.project.controller.command.PagePath.ERROR_500_PAGE;
import static by.tms.project.controller.command.RequestAttribute.CURRENT_PAGE;
import static by.tms.project.controller.command.RequestParameter.COMMAND_TYPE;

/**
 * @author ShchebetovaEK
 *
 * class MainController
 */
@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainController {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Instantiates a new MainController.
     */
    public MainController() {
    }

    /**
     * Do get.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (CommandException e) {
            logger.error(e);
            response.sendRedirect(ERROR_500_PAGE);
        }
    }

    /**
     * Do post.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (CommandException e) {
            logger.error(e);
            response.sendRedirect(request.getContextPath() + ERROR_500_PAGE);
        }
    }

    /**
     * Process request.
     *
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CommandException {
        HttpSession session = request.getSession();
        Router router;
        Optional<CommandType> commandTypeOpt = (Optional<CommandType>) request.getAttribute(COMMAND_TYPE);
        CommandType commandType = commandTypeOpt.get();
        router = commandType.getCommand().execute(request);

        String pagePath = router.getPage();
        if(pagePath.contains(request.getContextPath())){
            pagePath = pagePath.substring(request.getContextPath().length());
        }
        session.setAttribute(CURRENT_PAGE, pagePath);
        switch(router.getType()) {
            case REDIRECT:
                response.sendRedirect(router.getPage());
                break;
            case FORWARD:
                RequestDispatcher dispatcher = request.getRequestDispatcher(router.getPage());
                dispatcher.forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + ERROR_404_PAGE);
        }
    }
}