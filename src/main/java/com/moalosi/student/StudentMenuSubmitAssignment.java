package com.moalosi.student;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentMenuSubmitAssignment", value = "/student-submit-assignment")
public class StudentMenuSubmitAssignment extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int studentId = (int) session.getAttribute("userId");

        out.println("<h4>Submit Assignment</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Course</th>");
        out.println("<th>Assignment Tittle</th>");
        out.println("<th>Started Date</th>");
        out.println("<th>Submission Date</th>");
        out.println("<th>Submitted</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getAssigmentList()
                .forEach(assignment -> {
                    boolean submitted = courseService.studentSubmitted(studentId, assignment.id());
                    out.println("<tr>");
                    out.println("<td>" + courseService.getCourseNameById(assignment.courseId()) + "</td>");
                    out.println("<td>" + courseService.getAssignmentNameById(assignment.id()) + "</td>");
                    out.println("<td>" + assignment.creationDate() + "</td>");
                    out.println("<td>" + assignment.deadLine() + "</td>");
                    out.println("<td>" + (!submitted ? "<i class=\"uil uil-multiply delete\"></i>" : "<i class=\"uil uil-check update\"></i>") + "</td>");
                    out.println("<td>");
                    out.println("<a href=\" \"><i class=\"uil uil-file-download update\"></i></a>");
                    out.println("<a href=\"StudentAssignmentSubmission.jsp?sid=" + studentId + "&aid=" + assignment.id() + "\"><i class=\"uil uil-file-upload update\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
