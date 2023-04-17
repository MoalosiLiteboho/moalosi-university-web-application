package com.moalosi.controllers;

import com.moalosi.id.IdGenerator;
import com.moalosi.model.AssignmentSubmission;
import com.moalosi.service.CourseService;
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

@WebServlet(name = "studentSubmitAssignment", value = "/student-new-submit-assignment")
@MultipartConfig
public class StudentSubmitAssignment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String folderName = "resources";
        String uploadPath =  request.getServletContext().getRealPath("") + File.separator +  folderName;
        CourseService courseService = new CourseService();


        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String path = folderName + File.separator + fileName;
        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = courseService.getCourseIdByAssignmentId(assignmentId);

        courseService.submitAssignment(new AssignmentSubmission(
                new IdGenerator().get(),
                studentId,
                courseId,
                assignmentId,
                path,
                LocalDate.now()
        ));

        response.sendRedirect("StudentDashboard.jsp");
    }
}
