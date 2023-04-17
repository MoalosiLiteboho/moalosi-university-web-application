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

@WebServlet(name = "instructorMenuAddCourseAssignment", value = "/instructor-add-course-assignment")
public class InstructorMenuAddCourseAssignment extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int instructorId = (int) session.getAttribute("userId");

        out.println("<div class=\"add-form-container\">");
        out.println("<form action=\"instructor-Add-new-course-assigment\" method=\"post\" enctype=\"multipart/form-data\">");
        out.println("<h4>Add Course Assignment</h4>");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"courseId\" id=\"selectId\">");

        new CourseService().getCourseList()
                .stream()
                .filter(course -> course.instructorId() == instructorId)
                .forEach(course -> out.println("<option value=\"" + course.id() + "\">" + course.name() + "</option>"));

        out.println("</select>");
        out.println("<label for=\"selectId\">Course</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"name\" id=\"nameId\">");
        out.println("<label for=\"nameId\">Tittle</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"date\" name=\"deadline\" id=\"deadlineId\" placeholder=\" \">");
        out.println("<label for=\"deadlineId\">Deadline</label>");
        out.println("</div>");
        out.println("<div class=\"file-upload\">");
        out.println("<input type=\"file\" name=\"file\">");
        out.println("</div>");
        out.println("<div class=\"button-container\">");
        out.println("<input type=\"submit\" value=\"Add Assigment\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
    }
}
