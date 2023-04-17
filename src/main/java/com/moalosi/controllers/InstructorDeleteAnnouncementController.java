package com.moalosi.controllers;

import com.moalosi.service.AnnouncementService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "InstructorDeleteAnnouncement", value = "/delete-announcement")
public class InstructorDeleteAnnouncementController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new AnnouncementService()
                .deleteAnnouncement(Integer.parseInt(request.getParameter("id")));

        response.sendRedirect("InstructorDashboard.jsp");
    }
}
