package com.moalosi.controllers;

import com.moalosi.id.IdGenerator;
import com.moalosi.model.User;
import com.moalosi.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "signup", value = "/registration")
public class SignUpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                new IdGenerator().get(),
                request.getParameter("name"),
                request.getParameter("surname"),
                request.getParameter("gender"),
                LocalDate.parse(request.getParameter("dateOfBirth")),
                Integer.parseInt(request.getParameter("districtCode")),
                3);
        UserService service = new UserService();

        service.userRegistration(user);

        if(service.checkIfUserExits(user.id())) successfulUserRegistration(request, response);
        else throw new RuntimeException("User not registered");
    }

    private void successfulUserRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SigInAndSignUp.jsp");
        dispatcher.forward(request, response);
    }
}
