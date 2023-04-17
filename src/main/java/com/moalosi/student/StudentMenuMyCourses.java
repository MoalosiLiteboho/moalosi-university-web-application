package com.moalosi.student;

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

@WebServlet(name = "studentMenuMyCourses", value = "/student-courses")
public class StudentMenuMyCourses extends HttpServlet {
    private final CourseService courseService = new CourseService();
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int studentId = (int) session.getAttribute("userId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h4>My Courses</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Instructor Name</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        courseService.getEnrollmentList()
                .stream()
                .filter(course -> course.studentId() == studentId)
                .forEach(course -> {
                    out.println("<tr>");
                    out.println("<td>" + course.id() +"</td>");
                    out.println("<td>" + courseService.getCourseNameById(course.courseId()) + "</td>");
                    out.println("<td>" + userService.getInstructorNamesByCourseId(course.courseId()) + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"un-enroll-in-a-course?id=" + course.id() +"\"><i class=\"uil uil-trash-alt delete\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
