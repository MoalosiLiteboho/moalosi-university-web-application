package com.moalosi.controllers;

import com.moalosi.model.Course;
import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AdministratorUpdateCourse", value = "/administrator-update-course-by-id")
public class AdministratorUpdateCourseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course(
                Integer.parseInt(request.getParameter("courseId")),
                Integer.parseInt(request.getParameter("instructorId")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("type"),
                LocalDate.parse(request.getParameter("creationDate"))
        );

        new CourseService().updateCourse(course);
        response.sendRedirect("AdministratorDashboard.jsp");
    }
}
