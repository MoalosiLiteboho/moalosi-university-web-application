package com.moalosi.controllers;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdministratorDeleteCourseById", value = "/administrator-delete-course-by-id")
public class AdministratorDeleteCourseController extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));

        if(courseService.checkIfCourseExistById(courseId))
            courseService.deleteCourseById(courseId);
        response.sendRedirect("AdministratorDashboard.jsp");
    }
}
