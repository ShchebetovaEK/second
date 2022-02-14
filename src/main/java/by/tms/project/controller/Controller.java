package by.tms.project.controller;

import by.tms.project.controller.command.Command;
import by.tms.project.controller.command.CommandFactory;
import by.tms.project.controller.command.PagePath;
import by.tms.project.controller.command.Router;
import by.tms.project.exception.CommandException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.tms.project.controller.command.RequestParameter.COMMAND;


/**
 * @author ShchebetovaEK
 * <p>
 * class Controller
 */
@WebServlet(urlPatterns = "/controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Instantiates a new Controller.
     */
    public Controller() {
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
            logger.error("Failed at doGet method Controller", e);
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
            logger.error("Failed at doPost method Controller", e);
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
        String commandStr = request.getParameter(COMMAND);
        Command command = CommandFactory.getCommand(commandStr);
        try {
            Router router = command.execute(request);
            if (router.hasError()) {
                response.sendError(router.getErrorCode(), router.getErrorMessage());
            } else {
                switch (router.getRouterType()) {
                    case FORWARD -> getServletContext().getRequestDispatcher(router.getPage()).forward(request, response);
                    case REDIRECT -> response.sendRedirect(request.getContextPath() + router.getPage());
                }
            }
        } catch (CommandException e) {
            logger.log(Level.ERROR, "Internal error has occurred:", e);
            response.sendRedirect(request.getContextPath() + PagePath.ERROR_500_PAGE);

        }
    }
}


