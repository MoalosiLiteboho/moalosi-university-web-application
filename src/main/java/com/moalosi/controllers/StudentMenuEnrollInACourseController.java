package com.moalosi.controllers;

import com.moalosi.dao.DaoImplementation;
import com.moalosi.model.EnrollmentCourse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "studentMenuEnrollInACourseController", value = "/student-menu-enroll-in-a-course-controller")
public class StudentMenuEnrollInACourseController extends HttpServlet {
    private final DaoImplementation daoImplementation = new DaoImplementation();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int studentId = (int) session.getAttribute("userId");

        daoImplementation.enrollStudent(new EnrollmentCourse(
                0,
                studentId,
                Integer.parseInt(request.getParameter("courseId")),
                LocalDate.now()
        ));

        response.sendRedirect("StudentDashboard.jsp");
    }
}
