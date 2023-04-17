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

@WebServlet("/administrator-assignment-submissions")
public class AdministratorMenuAssignmentSubmissions extends HttpServlet {
    private final CourseService courseService = new CourseService();
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h4>Assigment Submission</h4>");
        out.println("<button id=\"add-button\">");
        out.println("<i class=\"uil uil-file-download\"></i>");
        out.println("<a href=\"#\">generate report</a>");
        out.println("</button>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course</th>");
        out.println("<th>Assigment Tittle</th>");
        out.println("<th>Duration</th>");
        out.println("<th>Student</th>");
        out.println("<th>Submission Date</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getAssigmentSubmissionsList()
                .forEach(submission -> {
                    out.println("<tr>");
                    out.println("<td>" + submission.id() + "</td>");
                    out.println("<td>" + courseService.getCourseNameById(submission.courseId()) + "</td>");
                    out.println("<td>" + courseService.getAssignmentNameById(submission.assignmentId()) + "</td>");
                    out.println("<td>" + courseService.getAssigmentDurationById(submission.assignmentId()) + "</td>");
                    out.println("<td>" + userService.getUserNamesById(submission.studentId()) + "</td>");
                    out.println("<td>" + submission.submissionDate() + "</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
