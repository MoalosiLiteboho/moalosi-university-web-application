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

@WebServlet(name = "DisplayTheFormOnTheInstructorDashboard", value = "/instructor-add-course-material")
public class InstructorMenuAddCourseMaterial extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int instructorId = (int) session.getAttribute("userId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>Add Course Material</h4>");
        out.println("<div class=\"add-form-container\">");
        out.println("<form action=\"instructor-add-new-course-material\" method=\"post\" enctype=\"multipart/form-data\">");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"name\" id=\"nameId\">");
        out.println("<label for=\"nameId\">Tittle</label>");
        out.println("</div>");
        out.println("<div class=\"file-upload\">");
        out.println("<input type=\"file\" name=\"file\">");
        out.println("</div>");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"courseId\" id=\"selectId\">");

        new CourseService().getCourseList()
                .stream()
                .filter(course -> course.instructorId() == instructorId)
                .forEach(course -> out.println("<option value=\"" + course.id() + "\">" + course.name() + "</option>"));

        out.println("</select>");
        out.println("<label for=\"selectId\">Course</label>");
        out.println("</div>");
        out.println("<div class=\"button-container\">");
        out.println("<input type=\"submit\" value=\"Add Material\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
    }
}
