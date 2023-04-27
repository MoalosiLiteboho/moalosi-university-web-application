package com.moalosi.administrator;

import com.moalosi.service.CourseService;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/administrator-student-grades")
public class AdministratorMenuStudentsGrades extends HttpServlet {
    private final UserService userService = new UserService();
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>Student Grades</h4>");
        out.println("<button id=\"add-button\">");
        out.println("<i class=\"uil uil-file-download\"></i>");
        out.println("<a href=\"generate-student-grade-report\">generate report</a>");
        out.println("</button>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Student Names</th>");
        out.println("<th>Course</th>");
        out.println("<th>Assessment Tittle</th>");
        out.println("<th>Duration</th>");
        out.println("<th>Marks</th>");
        out.println("<th>Grade</th>");
        out.println("<th>Submitted</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        userService.getStudentsGradesList()
                        .forEach(studentGrades -> {
                            out.println("<tr>");
                            out.println("<td>" + studentGrades.id() + "</td>");
                            out.println("<td>" + userService.getUserNamesById(studentGrades.studentId()) + "</td>");
                            out.println("<td>" + courseService.getCourseNameById(studentGrades.courseId()) + "</td>");
                            out.println("<td>" + courseService.getAssignmentNameById(studentGrades.assignmentId()) + "</td>");
                            out.println("<td>" + courseService.getAssigmentDurationById(studentGrades.assignmentId()) + "</td>");
                            out.println("<td>" + studentGrades.marks() + "</td>");
                            out.println("<td>" + studentGrades.Grade() + "</td>");
                            out.println("<td>" + (!studentGrades.submitted() ? "<i class=\"uil uil-multiply delete\"></i>" : "<i class=\"uil uil-check update\"></i>") + "</td>");
                            out.println("</tr>");
                        });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
