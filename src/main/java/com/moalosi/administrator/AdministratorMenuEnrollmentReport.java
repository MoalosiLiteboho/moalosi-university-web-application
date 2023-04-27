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

@WebServlet("/administrator-enrollment-report")
public class AdministratorMenuEnrollmentReport extends HttpServlet {
    private final CourseService courseService = new CourseService();
    private final UserService userService = new UserService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>Course Enrollment Report</h4>");
        out.println("<button id=\"add-button\">");
        out.println("<i class=\"uil uil-file-download\"></i>");
        out.println("<a href=\"generate-enrollment-report\">generate report</a>");
        out.println("</button>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Course</th>");
        out.println("<th>Enrollment Date</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getEnrollmentList()
                .forEach(enrollment -> {
                    out.println("<tr>");
                    out.println("<td>" + enrollment.id() + "</td>");
                    out.println("<td>" + userService.getUserNamesById(enrollment.studentId()) + "</td>");
                    out.println("<td>" + courseService.getCourseNameById(enrollment.courseId()) + "</td>");
                    out.println("<td>" + enrollment.enrollmentDate() + "</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
