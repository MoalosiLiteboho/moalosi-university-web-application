package com.moalosi.instructor;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "instructorMenuAssignmentDeadlines", value = "/instructor-assignment-deadlines")
public class InstructorMenuAssignmentDeadlines extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>Assignment Deadlines</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course</th>");
        out.println("<th>Assigment Tittle</th>");
        out.println("<th>Dead Line</th>");
        out.println("<th>Creation Date</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getAssigmentList()
                .forEach(assignment -> {
                    out.println("<tr>");
                    out.println("<td>" + assignment.id() + "</td>");
                    out.println("<td>" + courseService.getCourseNameById(assignment.courseId()) + "</td>");
                    out.println("<td>" + assignment.name() + "</td>");
                    out.println("<td>" + assignment.deadLine() + "</td>");
                    out.println("<td>" + assignment.creationDate() + "</td>");
                    out.println("<td>" + "<a class\"buttons\" href=\"UpdateDeadline.jsp?id="+ assignment.id() +"\" id=\"updateDeadlineId\"><i class=\"uil uil-edit update\"></i></a>" + "</td>");
                    out.println("</tr>");
                });
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
