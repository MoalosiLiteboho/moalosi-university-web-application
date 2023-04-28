package com.moalosi.controllers;

import com.moalosi.dao.DaoImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UnEnrollInACourse", value = "/un-enroll-in-a-course")
public class StudentUnEnrollInACourseController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new DaoImplementation().unEnrollStudent(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("StudentDashboard.jsp");
    }
}
