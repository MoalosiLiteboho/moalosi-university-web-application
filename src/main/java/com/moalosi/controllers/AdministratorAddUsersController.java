package com.moalosi.controllers;

import com.moalosi.id.IdGenerator;
import com.moalosi.service.UserService;
import com.moalosi.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/register-or-register-user")
public class AdministratorAddUsersController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User(
                new IdGenerator().get(),
                request.getParameter("name"),
                request.getParameter("surname"),
                request.getParameter("gender"),
                LocalDate.parse(request.getParameter("dateOfBirth")),
                Integer.parseInt(request.getParameter("districtCode")),
                Integer.parseInt(request.getParameter("authorityId")));
        UserService service = new UserService();
        service.userRegistration(user);

        if(service.checkIfUserExits(user.id()))
            response.sendRedirect("AdministratorDashboard.jsp");
    }
}
