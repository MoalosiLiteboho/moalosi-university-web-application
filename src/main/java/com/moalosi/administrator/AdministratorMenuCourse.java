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

@WebServlet("/administrator-course")
public class AdministratorMenuCourse extends HttpServlet {
    private final CourseService courseService = new CourseService();
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<h4>Course</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Instructor Name</th>");
        out.println("<th>Description</th>");
        out.println("<th>Type</th>");
        out.println("<th>Creation Date</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getCourseList()
                .forEach(course -> {
                    out.println("<tr>");
                    out.println("<td>" + course.id() + "</td>");
                    out.println("<td>" + course.name() + "</td>");
                    out.println("<td>" + userService.getUserNamesById(course.instructorId()) + "</td>");
                    out.println("<td>" + course.description() + "</td>");
                    out.println("<td>" + course.type() + "</td>");
                    out.println("<td>" + course.createdDate() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"administrator-delete-course-by-id?id=" + course.id() + "\"><i class=\"uil uil-trash-alt delete\"></i></a>");
                    out.println("<a href=\"UpdateCourse.jsp?id=" + course.id() + "\"><i class=\"uil uil-pen update\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
