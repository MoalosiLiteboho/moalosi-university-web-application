package com.moalosi.controllers;

import com.moalosi.model.Assignment;
import com.moalosi.dao.DaoImplementation;
import com.moalosi.id.IdGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddNewAssignment", value = "/instructor-Add-new-course-assigment")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 1_000, maxRequestSize = 1024 * 1024 * 1_000)
public class AddAssignmentController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String folderName = "resources";

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String tittle = request.getParameter("name");
        LocalDate deadLine = LocalDate.parse(request.getParameter("deadline"));
        String path = folderName + File.separator + fileName;

        new DaoImplementation().saveCourseAssignment(new Assignment(
                new IdGenerator().get(),
                courseId,
                tittle,
                LocalDate.now(),
                deadLine,
                path
        ));

        response.sendRedirect("InstructorDashboard.jsp");
    }
}
