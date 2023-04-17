package com.moalosi.controllers;

import com.moalosi.model.Course;
import com.moalosi.id.IdGenerator;
import com.moalosi.service.CourseService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "instructorAddNewCourse", value = "/instructor-add-new-course")
public class InstructorAddNewCourse extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int instructorId = (int) request.getSession().getAttribute("userId");

        courseService.registerCourse(new Course(
                new IdGenerator().get(),
                instructorId,
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("type"),
                LocalDate.now()
        ));
        response.sendRedirect("InstructorDashboard.jsp");;
    }
}
