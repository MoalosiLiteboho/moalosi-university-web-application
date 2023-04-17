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

@WebServlet(name = "studentCourseEnrollment", value = "/student-add-student-feedback")
public class StudentMenuAddFeedback extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int studentId = (int) session.getAttribute("userId");

        out.println("<h4>Add Student Feedback</h4>");
        out.println("<div class=\"add-form-container\">");
        out.println("<form action=\"student-add-new-feedback\" method=\"post\">");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"rating\" id=\"selectId\">");
        out.println("<option value=\"Very Bad\">Very Bad</option>");
        out.println("<option value=\"Bad\">Bad</option>");
        out.println("<option value=\"No Sure\">No Sure</option>");
        out.println("<option value=\"Good\">Good</option>");
        out.println("<option value=\"Perfect\">Perfect</option>");
        out.println("</select>");
        out.println("<label for=\"selectId\">Rating</label>");
        out.println("</div>");
        out.println("<div class=\"selection-container\">");
        out.println("<select class=\"custom-select\" name=\"courseId\" id=\"selectId\">");

        courseService.getCourseList()
                .stream()
                .filter(course -> courseService.getCourseIdsListByStudentId(studentId).contains(course.id()))
                .forEach(course -> out.println("<option value=\"" + course.id() + "\">" + course.name() + " " + course.type() + "</option>"));

        out.println("</select>");
        out.println("<label for=\"selectId\">Course</label>");
        out.println("</div>");
        out.println("<div class=\"input-container\">");
        out.println("<input type=\"text\" name=\"feedback\" id=\"nameId\">");
        out.println("<label for=\"nameId\">Feedback</label>");
        out.println("</div>");
        out.println("<div class=\"button-container\">");
        out.println("<input type=\"submit\" value=\"Add\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
    }
}
