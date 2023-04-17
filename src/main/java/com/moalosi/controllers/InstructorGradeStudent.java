package com.moalosi.controllers;

import com.moalosi.model.StudentGrade;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "instructorGradeStudent", value = "/instructor-grade-student-by-id")
public class InstructorGradeStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        int id = Integer.parseInt(request.getParameter("id"));
        int mark = Integer.parseInt(request.getParameter("mark"));
        String grateOfAMark = userService.grateOfAMark(mark);

        userService.gradeStudentById(new StudentGrade(
                id,
                mark,
                grateOfAMark
        ));

        response.sendRedirect("InstructorDashboard.jsp");
    }
}
