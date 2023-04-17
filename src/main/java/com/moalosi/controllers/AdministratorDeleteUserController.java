package com.moalosi.controllers;

import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="AdministratorDeleteUserById", value = "/delete-user-by-user-id")
public class AdministratorDeleteUserController extends HttpServlet {
    private final UserService service = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        if(service.checkIfUserExits(userId))
            getDeleteUser(userId, response);
        else goBackToDashboard(response);
    }

    private void goBackToDashboard(HttpServletResponse response) throws IOException {
        response.sendRedirect("AdministratorDashboard.jsp");
    }

    private void getDeleteUser(int userId, HttpServletResponse response) throws IOException {
        service.deleteUser(userId);

        if(!service.checkIfUserExits(userId))
            response.sendRedirect("AdministratorDashboard.jsp");
    }
}
