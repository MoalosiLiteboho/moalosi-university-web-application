package com.moalosi.controllers;

import com.moalosi.model.User;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UpdateUserDetails", value = "/update-user-servlet")
public class UpdateUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                Integer.parseInt(request.getParameter("userId")),
                request.getParameter("name"),
                request.getParameter("surname"),
                request.getParameter("gender"),
                LocalDate.parse(request.getParameter("dateOfBirth")),
                Integer.parseInt(request.getParameter("districtCode")),
                Integer.parseInt(request.getParameter("authorityId"))
        );

        new UserService().updateUser(user);
        response.sendRedirect("AdministratorDashboard.jsp");
    }
}
