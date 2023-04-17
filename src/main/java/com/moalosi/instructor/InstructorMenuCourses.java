package com.moalosi.instructor;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "instructorMenuCourses", value = "/instructor-courses")
public class InstructorMenuCourses extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int instructorId = (int) session.getAttribute("userId");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h4>Course</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Name</th>");
        out.println("<th>Description</th>");
        out.println("<th>Type</th>");
        out.println("<th>Creation Date</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        new CourseService().getCourseList()
                .stream()
                .filter(course -> course.instructorId() == instructorId)
                .forEach(course -> {
                    out.println("<tr>");
                    out.println("<td>" + course.id() + "</td>");
                    out.println("<td>" + course.name() + "</td>");
                    out.println("<td>" + course.type() + "</td>");
                    out.println("<td>" + course.description() + "</td>");
                    out.println("<td>" + course.createdDate() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"#\">");
                    out.println("<i class=\"uil uil-trash-alt delete\"></i>");
                    out.println("</a>");
                    out.println("<a href=\"#\">");
                    out.println("<i class=\"uil uil-pen update\"></i>");
                    out.println("</a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
