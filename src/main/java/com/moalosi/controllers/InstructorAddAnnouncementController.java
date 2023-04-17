package com.moalosi.controllers;

import com.moalosi.model.Announcement;
import com.moalosi.id.IdGenerator;
import com.moalosi.service.AnnouncementService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddNewAnnouncement", value = "/new-announcement")
public class InstructorAddAnnouncementController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int instructorId = (int) request.getSession().getAttribute("userId");

        new AnnouncementService().addAnnouncement(new Announcement(
                new IdGenerator().get(),
                instructorId,
                Integer.parseInt(request.getParameter("courseId")),
                request.getParameter("tittle"),
                request.getParameter("announcement"),
                LocalDate.now()
        ));
        response.sendRedirect("InstructorDashboard.jsp");
    }
}
