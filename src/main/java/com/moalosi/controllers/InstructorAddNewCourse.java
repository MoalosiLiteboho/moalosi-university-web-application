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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new CourseService().registerCourse(new Course(
                new IdGenerator().get(),
                (int) request.getSession().getAttribute("userId"),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("type"),
                LocalDate.now()
        ));
        response.sendRedirect("InstructorDashboard.jsp");;
    }
}
