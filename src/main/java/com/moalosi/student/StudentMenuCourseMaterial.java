package com.moalosi.student;

import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentMenuCourseMaterial", value = "/student-course-material")
public class StudentMenuCourseMaterial extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>Course Material</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Material Tittle</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getCourseMaterialList()
                .forEach(material -> {
                    out.println("<tr>");
                    out.println("<td>" + material.id() + "</td>");
                    out.println("<td>" + courseService.getCourseNameById(material.courseId()) + "</td>");
                    out.println("<td>" + material.name() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"download-a-file?filePath=resources/text.txt\"><i class=\"uil uil-download-alt update\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
