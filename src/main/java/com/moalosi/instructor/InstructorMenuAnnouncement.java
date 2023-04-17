package com.moalosi.instructor;

import com.moalosi.service.AnnouncementService;
import com.moalosi.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AnnouncementTable", value = "/instructor-announcement")
public class InstructorMenuAnnouncement extends HttpServlet {
    private final CourseService courseService = new CourseService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int instructorId = (int) session.getAttribute("userId");

        out.println("<h4>Announcement</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course</th>");
        out.println("<th>Announcement Tittle</th>");
        out.println("<th>Creation Date</th>");
        out.println("<th>Announcement</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        new AnnouncementService().getAnnouncementsList()
                .stream()
                .filter(announcement -> announcement.instructorId() == instructorId)
                .forEach(announcement -> {
                    out.println("<tr>");
                    out.println("<td>" + announcement.id() + "</td>");
                    out.println("<td>" + courseService.getCourseNameById(announcement.courseId()) + "</td>");
                    out.println("<td>" + announcement.tittle() + "</td>");
                    out.println("<td>" + announcement.createdDate() + "</td>");
                    out.println("<td>" + announcement.announcement() + "</td>");
                    out.println("<td>");
                    out.println("<a href=\"delete-announcement?id=" + announcement.id() + "\"><i class=\"uil uil-trash-alt delete\"></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                });
        
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
