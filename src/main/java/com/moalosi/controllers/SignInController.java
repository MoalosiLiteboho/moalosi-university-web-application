package com.moalosi.controllers;

import com.moalosi.model.SignInCredentials;
import com.moalosi.model.UserIdAndAuthorityDto;
import com.moalosi.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "signIn", value = "/login")
public class SignInController extends HttpServlet {
    private SignInCredentials credentials;
    private static final Logger LOGGER = Logger.getLogger(SignInController.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        credentials = new SignInCredentials(request.getParameter("username"), request.getParameter("password"));
        logIn(request, response);
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserIdAndAuthorityDto authorityAndUserIdByCredentials = new UserService().getUserIdAndAuthorityByCredentials(credentials);

        String authority = authorityAndUserIdByCredentials.authority();

        HttpSession session = request.getSession();
        session.setAttribute("userId", authorityAndUserIdByCredentials.id());
        session.setAttribute("username", credentials.username());

        switch (authority) {
            case "Student" -> showStudentDashboard(response);
            case "Instructor" -> showInstructorDashboard(response);
            case "Administrator" -> showAdministratorDashboard(response);
        }
    }

    private void showAdministratorDashboard(HttpServletResponse response) throws IOException {
        response.sendRedirect("AdministratorDashboard.jsp");
    }

    private void showInstructorDashboard(HttpServletResponse response) throws IOException {
        response.sendRedirect("InstructorDashboard.jsp");
    }

    private void showStudentDashboard(HttpServletResponse response) throws IOException {
        response.sendRedirect("StudentDashboard.jsp");
    }

    private void invalid(HttpServletRequest request) {
        String errorMessage = "Invalid credentials. Please try again.";
        LOGGER.warning("Invalid login attempt: username=" + credentials.username());
        request.getSession().setAttribute("errorMessage", errorMessage);
    }
}
