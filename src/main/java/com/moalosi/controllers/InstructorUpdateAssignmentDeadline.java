package com.moalosi.controllers;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "instructorUpdateAssignmentDeadline", value = "/instructor-update-assignment-deadline")
public class InstructorUpdateAssignmentDeadline extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new CourseService().updateDeadlineById(
                Integer.parseInt(request.getParameter("assignmentId")),
                LocalDate.parse(request.getParameter("deadline")));

        response.sendRedirect("InstructorDashboard.jsp");
    }
}
