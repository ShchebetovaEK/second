package by.tms.project.controller.filter;

import by.tms.project.model.entity.Role;
import by.tms.project.model.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static by.tms.project.controller.command.PagePath.*;
import static by.tms.project.controller.command.RequestAttribute.SESSION_USER;
import static jakarta.servlet.http.HttpServletResponse.SC_FORBIDDEN;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

//@WebFilter(urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {

        private static final Logger logger = LogManager.getLogger();
        private static final String START_URI = "/index.jsp";
        private Set<String> guestPages;
        private Set<String> doctorPage;
        private Set<String> patientPages;
        private Set<String> adminPages;

        @Override
        public void init(FilterConfig filterConfig) {
            guestPages = Set.of(INDEX_PAGE
                    , SIGN_IN_PAGE);
            doctorPage = Set.of(INDEX_PAGE
                    , MAIN_PAGE
                    , ABOUT_PAGE
                    , OUR_DOCTORS_PAGE
                    , PEDIATRIC_PAGE
                    , PRICE_PAGE
                    , ACCOUNT_PAGE
                    , AUTHENTICATION_PAGE
                    , FAIL_PAGE
                    , NO_MATCH_PAGE
                    , LOGIN_PAGE
                    , REGISTRATION_PAGE
                    , SEARCH_PAGE
                    , SIGN_IN_PAGE
                    , SUCCESS_PAGE
                    , DOCTOR_PAGE
                    , VIEW_ALL_PATIENT_PAGE
                    , VIEW_PROTOCOL_PAGE
                    , ERROR_404_PAGE
                    , ERROR_500_PAGE
                    , ERROR_400_PAGE);
            patientPages = Set.of(INDEX_PAGE
                    , MAIN_PAGE
                    , ABOUT_PAGE
                    , OUR_DOCTORS_PAGE
                    , PEDIATRIC_PAGE
                    , PRICE_PAGE
                    , ACCOUNT_PAGE
                    , AUTHENTICATION_PAGE
                    , FAIL_PAGE
                    , NO_MATCH_PAGE
                    , LOGIN_PAGE
                    , REGISTRATION_PAGE
                    , SEARCH_PAGE
                    , SIGN_IN_PAGE
                    , SUCCESS_PAGE
                    , CHOOSE_DOCTOR
                    , IMPOSSIBLE_PAGE
                    , VIEW_ALL_DOCTOR
                    , VIEW_MY_PROTOCOL
                    , ERROR_404_PAGE
                    , ERROR_500_PAGE
                    , ERROR_400_PAGE);
            adminPages = Set.of(INDEX_PAGE
                    , MAIN_PAGE
                    , ABOUT_PAGE
                    , OUR_DOCTORS_PAGE
                    , PEDIATRIC_PAGE
                    , PRICE_PAGE
                    , ACCOUNT_PAGE
                    , AUTHENTICATION_PAGE
                    , FAIL_PAGE
                    , NO_MATCH_PAGE
                    , LOGIN_PAGE
                    , REGISTRATION_PAGE
                    , SEARCH_PAGE
                    , SIGN_IN_PAGE
                    , SUCCESS_PAGE
                    , ADMIN_PAGE
                    , ADMIN_REGISTRATION_PAGE
                    , APPLICATION_PAGE
                    , DELETE_PAGE
                    , DOCTOR_REGISTRATION_PAGE
                    , PROTOCOL_PAGE
                    , PROTOCOL_REGISTRATION_PAGE
                    , SELECT_PAGE
                    , SELECT_DOCTOR_PAGE
                    , SELECT_PATIENT_PAGE
                    , UPDATE_PAGE
                    , UPDATE_DOCTOR_PAGE
                    , UPDATE_PATIENT_PAGE
                    , UPDATE_PROTOCOL_PAGE
                    , TOTALSUM_PAGE
                    , USER_MANAGER_PAGE
                    , ERROR_404_PAGE
                    , ERROR_500_PAGE
                    , ERROR_400_PAGE);
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            String requestURI = request.getServletPath();
            System.out.println(requestURI);
            HttpSession session = request.getSession();
            boolean isGuestPage = guestPages.stream().anyMatch(requestURI::contains);
            boolean isDoctorPage = doctorPage.stream().anyMatch(requestURI::contains);
            boolean isPatientPage = patientPages.stream().anyMatch(requestURI::contains);
            boolean isAdminPage = adminPages.stream().anyMatch(requestURI::contains);
            Object userAttribute = session.getAttribute(SESSION_USER);
            Optional<Object> userOptional = Optional.ofNullable(userAttribute);
            if (userOptional.isPresent()) {
                User user = (User) userOptional.get();
                Role role = user.getRole();

                if (role == Role.DOCTOR && isDoctorPage) {
                    chain.doFilter(request, response);
                } else if (role == Role.PATIENT && isPatientPage) {
                    chain.doFilter(request, response);
                } else if (role == Role.ADMIN && isAdminPage) {
                    chain.doFilter(request, response);
                }  else if (role == Role.GUEST && isAdminPage) {
                        chain.doFilter(request, response);
                } else {
                    response.sendError(SC_FORBIDDEN);
                }
            }  else {
                    logger.log(Level.WARN, "Page doesn't exist.");
                    response.sendError(SC_FORBIDDEN);
                }
            }
        }


