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

@WebServlet(name = "signIn", value = "/login")
public class SignInController extends HttpServlet {
    private SignInCredentials credentials;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        credentials = new SignInCredentials(request.getParameter("username"), request.getParameter("password"));
        logIn(request, response);
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserIdAndAuthorityDto authorityAndUserIdByCredentials = new UserService().getUserIdAndAuthorityByCredentials(credentials);

        HttpSession session = request.getSession();
        session.setAttribute("userId", authorityAndUserIdByCredentials.id());
        session.setAttribute("username", credentials.username());

        response.sendRedirect(authorityAndUserIdByCredentials.authority() + "Dashboard.jsp");
    }
}
