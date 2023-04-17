package com.moalosi.instructor;

import com.moalosi.service.CourseService;
import com.moalosi.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "instructorMenuStudentFeedback",value = "/instructor-student-feedback")
public class InstructorMenuStudentFeedback extends HttpServlet {
    private final CourseService service = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int instructorId = (int) session.getAttribute("userId");

        out.println("<h4>Student Feedback</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course</th>");
        out.println("<th>Feedback</th>");
        out.println("<th>Rating</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        new UserService().getStudentFeedbackList()
                .stream()
                .filter(studentFeedback -> service.findAllCoursesIdByInstructorId(instructorId).contains(studentFeedback.courseId()))
                .toList()
                .forEach(studentFeedback -> {
                    out.println("<tr>");
                    out.println("<td>" + studentFeedback.id() + "</td>");
                    out.println("<td>" + service.getCourseNameById(studentFeedback.courseId()) + "</td>");
                    out.println("<td>" + studentFeedback.feedback() + "</td>");
                    out.println("<td>" + studentFeedback.rating() + "</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
